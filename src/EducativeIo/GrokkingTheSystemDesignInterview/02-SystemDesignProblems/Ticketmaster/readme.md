# Design Ticketmaster

- [Design Ticketmaster](#design-ticketmaster)
  - [What is an online movie ticket booking system](#what-is-an-online-movie-ticket-booking-system)
  - [Requirements and Goals of the System](#requirements-and-goals-of-the-system)
  - [Some Design Considerations](#some-design-considerations)
  - [Capacity Estimation](#capacity-estimation)
    - [Traffic estimates](#traffic-estimates)
    - [Storage estimates](#storage-estimates)
  - [System APIs](#system-apis)
  - [Database Design](#database-design)
    - [Movie](#movie)
    - [Show](#show)
    - [Booking](#booking)
    - [User](#user)
    - [Cinema](#cinema)
    - [Cinema_hall](#cinemahall)
    - [Show_Seat](#showseat)
    - [Payment](#payment)
    - [City](#city)
    - [Cinema_Seat](#cinemaseat)
  - [High Level Design](#high-level-design)
  - [Detailed Component Design](#detailed-component-design)
  - [Concurrency](#concurrency)
  - [Fault Tolerance](#fault-tolerance)
  - [Data Partitioning](#data-partitioning)
    - [Database partitioning](#database-partitioning)
    - [ActiveReservationService and WaitingUserService partitioning](#activereservationservice-and-waitinguserservice-partitioning)

Design an online ticketing system that sells movie tickets like Ticketmaster or BookMyShow.

Similar Services: bookmyshow.com, ticketmaster.com

## What is an online movie ticket booking system

## Requirements and Goals of the System

- Functional Requirements:
  1. Our ticket booking service should be able to list different cities where its affiliate cinemas are located.
  2. Once the user selects the city, the service should display the movies released in that particular city.
  3. Once the user selects a movie, the service should display the cinemas running that movie and its available show times.
  4. The user should be able to choose a show at a particular cinema and book their tickets.
  5. The service should be able to show the user the seating arrangement of the cinema hall. The user should be able to select multiple seats according to their preference.
  6. The user should be able to distinguish available seats from booked ones.
  7. Users should be able to put a hold on the seats for five minutes before they make a payment to finalize the booking.
  8. The user should be able to wait if there is a chance that the seats might become available, e.g., when holds by other users expire.
  9. Waiting customers should be serviced in a fair, first come, first serve manner.
- Non-Functional Requirements:
  1. The system would need to be highly concurrent. There will be multiple booking requests for the same seat at any particular point in time. The service should handle this gracefully and fairly.
  2. The core thing of the service is ticket booking, which means financial transactions. This means that the system should be secure and the database ACID compliant.

## Some Design Considerations

1. For simplicity, let’s assume our service does not require any user authentication.
2. The system will not handle partial ticket orders. Either user gets all the tickets they want or they get nothing.
3. Fairness is mandatory for the system.
4. To stop system abuse, we can restrict users from booking more than ten seats at a time.
5. We can assume that traffic would spike on popular/much-awaited movie releases and the seats would fill up pretty fast. The system should be scalable and highly available to keep up with the surge in traffic.

## Capacity Estimation

### Traffic estimates

- Service has 3 B page views per month.
- Sells 10 M tickets per month.

### Storage estimates

- 500 cities.
- Each city has 10 cinemas.
- 2000 seats per cinema.
- 2 shows per day.
- Each seat needs 50 bytes (IDs, NumberOfSeats, ShowID, MovieID, SeatNumbers, SeatStatus, Timestamp, etc.)
- Information about movies and cinemas: 50 bytes.
- Storage needed for data about all shows of all cinemas of all cities for a day: `500 cities * 10 cinemas * 2000 seats * 2 shows * (50+50) bytes = 2 GB / day`
- Storage needed for 5 years = `2 GB * 365 days * 5 years ~= 3.6 TB`

## System APIs

```text
SearchMovies(api_dev_key, keyword, city, lat_long, radius, start_datetime, end_datetime, postal_code,
includeSpellcheck, results_per_page, sorting_order)

Return JSON.
```

```text
ReserveSeats(api_dev_key, session_id, movie_id, show_id, seats_to_reserve[])

Returns: (JSON)
Returns the status of the reservation, which would be one of the following: 1) "Reservation Successful" 2) "Reservation Failed - Show Full", 3) "Reservation Failed - Retry, as other users are holding reserved seats".
```

## Database Design

Some observations:

1. Each City can have multiple Cinemas.
2. Each Cinema will have multiple halls.
3. Each Movie will have many Shows and each Show will have multiple Bookings.
4. A user can have multiple bookings.

[data modeling](./images/data-modeling_base64.md)

### Movie

### Show

### Booking

### User

### Cinema

### Cinema_hall

### Show_Seat

### Payment

### City

### Cinema_Seat

## High Level Design

- Web servers will manage users' sessions
- Application servers will handle
  - all the ticket management
  - storing data in the databases
  - working with the cache servers to process reservations.

![high level design](https://raw.githubusercontent.com/tuliren/grokking-system-design/master/img/ticketmaster-overview.png)

## Detailed Component Design

- We will build the service assuming it is being served from a single server.
- **Ticket Booking Workflow**
  1. The user searches for a movie.
  2. The user selects a movie.
  3. The user is shown the available shows of the movie.
  4. The user selects a show.
  5. The user selects the number of seats to be reserved.
  6. If the required number of seats are available, the user is shown a map of the theater to select seats. If not, the user is taken to 'step 8' below.
  7. Once the user selects the seat, the system will try to reserve those selected seats.
  8. If seats can’t be reserved, we have the following options:
     - Show is full; the user is shown the error message.
     - The seats the user wants to reserve are no longer available, but there are other seats available, so the user is taken back to the theater map to choose different seats.
     - There are no seats available to reserve, but all the seats are not booked yet, as there are some seats that other users are holding in the reservation pool and have not booked yet. The user will be taken to a waiting page where they can wait until the required seats get freed from the reservation pool. This waiting could result in the following options:
       - If the required number of seats become available, the user is taken to the theater map page where they can choose seats.
       - While waiting, if all seats get booked or there are fewer seats in the reservation pool than the user intend to book, the user is shown the error message.
       - User cancels the waiting and is taken back to the movie search page.
       - At maximum, a user can wait one hour, after that user’s session gets expired and the user is taken back to the movie search page.
  9. If seats are reserved successfully, the user has five minutes to pay for the reservation. After payment, booking is marked complete. If the user is not able to pay within five minutes, all their reserved seats are freed to become available to other users.

    [ticket booking workflow](./images/ticket-booking-workflow_base64.md)

- **How would the server keep track of all the active reservation that haven't been booked yet? And how would the server keep track of all the waiting customers?**
  - Two daemon services
    - One to keep track of all active reservations and remove any expired reservation from the system: **ActiveReservationService**.
    - Other would be keeping track of all the waiting user requests and, as soon as the required number of seats become available, it will notify the (the longest waiting) user to choose the seats: **WaitingUserService**.
- **ActiveReservationService**
  - All reservations of a show will be kept in memory using a Linked HashMap or TreeMap data structure (along with keeping all the data in the d/b).
  - Linked HashMap kind of data structure allows jumping to any reservation to remove it when booking is complete.
  - Given each reservation will have an expiration time, head of the HashMap will point to the oldest reservation record so that it can be removed when the expiration timeout is reached.
  - To store reservation for every show, we can use a HashTable:
    - Key: ShowID
    - Value: Linked HashMap containing BookingID and creation Timestamp.
  - In d/b
    - Reservation will be stored in Booking table.
    - Expiry time will be in Timestamp column.
    - Status field:
      - Initially: Reserved (1)
      - When booking is complete: Booked (2)
    - Also, when booking is complete, reservation record will be removed from the Linked HashMap of the relevant show.
    - When reservation has expired,
      - in d/b
        - Remove it from Booking table, or
        - Mark as Expired (3) in status field
      - Remove from memory
  - Will work with external service for user payment processing.
  - When a booking is complete, or reservation expires
    - WaitingUsersService will get notified so that any waiting customer can be served.

      | key    | value                                                 |
      | ------ | ----------------------------------------------------- |
      | ShowID | LinkedHashMap<BookingID, Timestamp>                   |
      | 123    | { (1, 1499818500), (2, 1499818700), (3, 1499818800) } |

- **WaitingUsersService**
  - Keep all waiting users of a show in memory in a Linked HashMap or a TreeMap.
  - Data structure similar to Linked HashMap will allow us to jump to any user to remove them from the HashMap when a request is canceled.
  - Head of the Lined HashMap will always point to the longest waiting user
    - So when seats become available, we can easily server users in first-come-first-serve manner.
  - HashTable to store all waiting users for every Show.
    - Key: ShowID
    - Value: LinkedHashMap containing UserIDs and their wait-start-time.
  - Clients can use Long Polling to keep them updated for reservation status. Server will use this request to notify user when seats become available.
- **Reservation Expiration**
  - On the server, ActiveReservationsService will keep track of expiry (based on reservation time) of active reservations.
  - Client side time may be out of sync with server.
  - Buffer of 5 seconds can be used on the server to prevent client time out after the server preventing a successful purchase.

## Concurrency

- **Presenting two users from booking the same seat**
  - Transactions in SQL databases to avoid any clashes.
  - If using SQL server, [Transaction Isolation Levels](https://docs.microsoft.com/en-us/sql/odbc/reference/develop-app/transaction-isolation-levels) can be used to lock the rows before we can update them.
  - Note: 'Serializable' is the highest isolation level and guarantees safety from [Dirty](https://en.wikipedia.org/wiki/Isolation_(database_systems)#Dirty_reads), [Nonrepeatable](https://en.wikipedia.org/wiki/Isolation_(database_systems)#Non-repeatable_reads), and [Phantoms](https://en.wikipedia.org/wiki/Isolation_(database_systems)#Phantom_reads) reads
  - Once the database transaction is successful, we can start tracking the reservation in ActiveReservationService.

## Fault Tolerance

- **Handling crashes in ActiveReservationsService or WaitingUsersService services**
  - Approach 1:
    - When ActiveReservationsService crashes, we can read all active reservations from Booking table. We know which reservations are active using the status column (Reserved (1)).
  - Approach 2:
    - Have a master-slave configuration.
  - Since we do not store waiting users in d/b, only means of ensuring fault-tolerance for WaitingUsersService in case of crashes is to use master-slave setup.
  - We can have master-slave setup for d/b.

## Data Partitioning

### Database partitioning

- Approach 1: Partition by MovieID
  - All Shows of a movie will be on single server.
  - Will cause hotspot and performance issues for a hot movie.
- Approach 2: Partition by ShowID
  - Load will get distributed among different servers.

### ActiveReservationService and WaitingUserService partitioning

- Web servers will manage all the active users’ sessions and handle all the communication with the users.
- Consistent hashing
  - Can be used to allocate application servers for both daemon services based on the ShowID.
  - All reservations and waiting users of a particular show will be handled by a certain set of servers.
- Say, Consistent Hashing allocates 3 servers for any Show, then, when a reservation expires, the server holding the reservation will:
  1. Update database to remove the Booking (or mark it expired) and update the seats’ Status in 'Show_Seats' table.
  2. Remove the reservation from the Linked HashMap.
  3. Notify the user that their reservation has expired.
  4. Broadcast a message to all WaitingUserService servers that are holding waiting users of that Show to figure out the longest waiting user. Consistent Hashing scheme will tell what servers are holding these users.
  5. Send a message to the WaitingUserService server holding the longest waiting user to process their request if required seats have become available.
- When a reservation is successful:
  1. The server holding that reservation sends a message to all servers holding the waiting users of that Show, so that those servers can expire all the waiting users that need more seats than the available seats.
  2. Upon receiving the above message, all servers holding the waiting users will query the database to find how many free seats are available now. A database cache would greatly help here to run this query only once.
  3. Expire all waiting users who want to reserve more seats than the available seats. For this, WaitingUserService has to iterate through the Linked HashMap of all the waiting users.
