PUT http://localhost:8001/sensorApi/measure/temperature

{
	"placeName": "House-1",
    "sensorName": "sensor-2",
    "date": "2019-04-01T12:26:38.411+0000",
    "value": "-15.3"
}

POST http://localhost:8001/sensorApi/getByDate

{
    "sensorName": "sensor-2",
    "dateFrom": "2019-03-01T12:26:38.411+0000",
    "dateTo": "2019-04-29T12:26:38.411+0000"
}

POST http://localhost:8001/sensorApi/getCurrentValueByPlace

{
	"name": "House-1"
}

POST http://localhost:8001/sensorApi/getMiddleValue


