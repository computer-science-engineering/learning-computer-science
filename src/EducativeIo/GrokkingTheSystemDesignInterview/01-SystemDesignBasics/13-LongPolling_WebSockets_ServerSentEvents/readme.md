# Long-Polling vs WebSockets vs Server-Sent Events

## Ajax Polling

* Client repeatedly polls (or requests) a server for data.
* Client makes a request and waits for the server to respond with data. If no data is available, an empty response is returned.
* Client has to keep asking the server for any new data. As a result, a lot of responses are empty creating HTTP overhead.

## HTTP Long-Polling

Client requests information from the server exactly as in normal polling, but the server may not respond immediately. This technique is sometimes called "Hanging GET".

* If server does not have data available, instead of sending empty response server holds request and wait till either a timeout occurs, or data is available to send back to the client.
* Once server responds to client with data, client will send another request either immediately or after a pause to allow for latency, such that server will always have an awaiting request to process and respond to, as and when data is available.
* Long-poll requests have timeouts, which if occurs, will result in connection being closed, thus requiring the client to reconnect.

## WebSockets

* [Full duplex](https://en.wikipedia.org/wiki/Duplex_(telecommunications)#Full_duplex) communication channels over a single TCP connection.
* Persistent connection between a client and a server - both parties can use to start sending data at any time.
* Connection is establihed using WebSocket handshake, subsequent to which client and server can exchange data in eithe direction.
* Websockets allow for low overhead messaging by providing a dtandardized wayto send messages and keeping connection open for messaging in either direction.

## Server-Sent Events (SSEs)

* Client establishes a persistent and long-term connection with the server. Server uses this connection to send data to a client.
* If the client wants to send data to the server, it would require the use of another technology/protocol to do so.
* SSEs are best when
  * we need real-time traffic from the server to the client or
  * if the server is generating data in a loop and will be sending multiple events to the client.