# Problem Definition

## Description

Write a program that sorts a list of comma separated products.

Each input row looks like `"TITLE,POPULARITY,PRICE"`. Meaning `"Selfie Stick,95,29"` says we sold
95 "Selfie Stick"s at 29 dollars each. All numbers are integers. The input will be provided in a
hardcoded array so no file I/O is needed.

The list should be sorted by:

By most popular first. If products are equally popular, sort by cheapest price (lower is better).

You don't need to write your own sorting algorithm. It's recommended to use a built-in sorting
library.

### Example

If the input is:

```plaintext
"Selfie Stick,98,29",
"iPhone Case,90,15",
"Fire TV Stick,48,49",
"Wyze Cam,48,25",
"Water Filter,56,49",
"Blue Light Blocking Glasses,90,16",
"Ice Maker,47,119",
"Video Doorbell,47,199",
"AA Batteries,64,12",
"Disinfecting Wipes,37,12",
"Baseball Cards,73,16",
"Winter Gloves,32,112",
"Microphone,44,22",
"Pet Kennel,5,24",
"Jenga Classic Game,100,7",
"Ink Cartridges,88,45",
"Instant Pot,98,59",
"Hoze Nozzle,74,26",
"Gift Card,45,25",
"Keyboard,82,19"
```

The sorted output should be:

```plaintext
Jenga Classic Game
Selfie Stick
Instant Pot
iPhone Case
Blue Light Blocking Glasses
Ink Cartridges
Keyboard
Hoze Nozzle
Baseball Cards
AA Batteries
Water Filter
Wyze Cam
Fire TV Stick
Ice Maker
Video Doorbell
Gift Card
Microphone
Disinfecting Wipes
Winter Gloves
Pet Kennel
```

## Discussion

### Approach

#### Time Complexity

#### Space Complexity

## Notes

## References
