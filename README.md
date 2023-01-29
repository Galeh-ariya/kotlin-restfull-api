# API Spec

## Authentication
All api must use this authentication

Request:
- Header: 
  - X-Api-Key: "Your secret api key"

## CREATE Mahasiswa
Request :
- Method : POST
- Endpoint : `api/mhs`
- Header :
  - Content-type: application/json
  - Accept: application/json
- Body :

 ```json
{
  "nim" : "Long, unique",
  "name" : "String",
  "email" : "String",
  "prodi" : "String"
}
```

- Response :

 ```json
{
  "code": "number",
  "status": "Sting",
  "data": {
    "nim" : "Long, unique",
    "name" : "String",
    "email" : "String",
    "prodi" : "String"
  }
}
```

## GET Mahasiswa
Request :
- Method : GET
- Endpoint : `api/mhs{nimMhs}`
- Header :
    - Accept: application/json

- Response :
 ```json
{
  "code": "number",
  "status": "Sting",
  "data": {
    "nim" : "Long, unique",
    "name" : "String",
    "email" : "String",
    "prodi" : "String"
  }
}
```

## UPDATE Mahasiswa
Request :
- Method : PUT
- Endpoint : `api/mhs/{nimMhs}`
- Header :
    - Content-type: application/json
    - Accept: application/json
- Body :

 ```json
{
  "name" : "String",
  "email" : "String",
  "prodi" : "String"
}
```

- Response :
 ```json
{
  "code": "number",
  "status": "Sting",
  "data": {
    "nim" : "Long, unique",
    "name" : "String",
    "email" : "String",
    "prodi" : "String"
  }
}
```

## LIST Mahasiswa
Request :
- Method : GET
- Endpoint : `api/mhs`
- Header :
    - Accept: application/json
- Query Param:
  - size : number,
  - page : number

- Response :

 ```json
{
  "code": "number",
  "status": "Sting",
  "data": [
    {
      "nim" : "Long, unique",
      "name" : "String",
      "email" : "String",
      "prodi" : "String"
    },
    {
      "nim" : "Long, unique",
      "name" : "String",
      "email" : "String",
      "prodi" : "String"
    }
  ]
}
```


## DELETE Mahasiswa
Request :
- Method : DELETE
- Endpoint : `api/mhs/{nimMhs}`
- Header :
    - Accept: application/json


- Response :

 ```json
{
  "code": "number",
  "status": "Sting",
  "data": "nim"
}
```

