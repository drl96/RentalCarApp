# Rental Car Application - Android

## Technologies Used:

Java, JSON, Firebase Realtime Database, REST API, Andriod Studio

## Description:

RentalCarApp is a mobile app for android that allows users to view information on all available rental cars, calculate total rental cost for the selected rental period, and update each car's daily rental fee. 

## Sample Features:

### View Rental Car Information:

![CarInfo1](https://github.com/drl96/RentalCarApp/blob/master/Resources/CarInfo1.PNG)![CarInfo2](https://github.com/drl96/RentalCarApp/blob/master/Resources/CarInfo2.PNG)

### Calculate Total Rental Cost:

![TotalCost1](https://github.com/drl96/RentalCarApp/blob/master/Resources/TotalCost1.PNG)![TotalCost2](https://github.com/drl96/RentalCarApp/blob/master/Resources/TotalCost2.PNG)

### Update Rental Cost-per-day:

![DailyCostUpdate1](https://github.com/drl96/RentalCarApp/blob/master/Resources/DailyCostUpdate1.PNG)![DailyCostUpdate2](https://github.com/drl96/RentalCarApp/blob/master/Resources/DailyCostUpdate2.PNG)

## Rental Cars JSON:

```json
{
  "rentalcars" : [ {
    "brand" : "Honda",
    "color" : "White",
    "id" : 104,
    "name" : "Accord",
    "rent" : 122.0,
    "url" : "https://automobiles.honda.com/accord-sedan"
  }, {
    "brand" : "Toyota",
    "color" : "Yellow",
    "id" : 105,
    "name" : "Avalon",
    "rent" : 121.0,
    "url" : "https://www.toyota.com/avalon/"
  }, {
    "brand" : "Chevrolet",
    "color" : "red",
    "id" : 101,
    "name" : "Camaro",
    "rent" : 250,
    "url" : "https://www.chevrolet.com/performance/camaro-sports-car"
  }, {
    "brand" : "Nissan",
    "color" : "Black",
    "id" : 101,
    "name" : "Frontier",
    "rent" : 223,
    "url" : "https://www.nissanusa.com/vehicles/trucks/frontier.html"
  }, {
    "brand" : "Ford",
    "color" : "Tan",
    "id" : 102,
    "name" : "Mustang",
    "rent" : 200,
    "url" : "https://www.ford.com/cars/mustang/"
  } ]
}
```

