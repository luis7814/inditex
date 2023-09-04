# inditex

Microservicio en springboot, que consulta la información de precios de productos.
La información se encuentra en dos tablas Prices y PriceList, en una base de datos H2.

#### Controller: Maneja la solicitud de entrada como servicio REST

#### Facade: Se encarga de distribuir la información a las diferentes entidades y de construir el objeto que va a visualizar el usuario.

#### Service: Lógica de negocio de cada entidad.

#### Repository: Interfaz que interactua con la base de datos.


# Base de datos

#### Prices: Se encuentra toda la información definida en el ejercicio
#### PriceList: Se crea está tabla para almacenar la información de la tarifa a aplicar, ya que en la tabla Prices, solo se encuentra el Id de la tarifa.

# Test

En la descripción, solo se indica la hora y el día, se asume que el año es 2020 y el mes 06.
Es un servicio GET que devuelve como resultado el siguiente JSON:

[
{
"productId": 35455,
"brandId": 1,
"priceList": 10.10,
"startDate": "2020-06-14T00:00:00",
"endDate": "2020-12-31T23:59:59",
"price": 35.50
}
]

## Test al endpoint
http://localhost:8080/price?applicationDate=2020-06-14T14:00:00&productId=35455&brandId=1
http://localhost:8080/price?applicationDate=2020-06-14T16:00:00&productId=35455&brandId=1
http://localhost:8080/price?applicationDate=2020-06-14T21:00:00&productId=35455&brandId=1
http://localhost:8080/price?applicationDate=2020-06-15T10:00:00&productId=35455&brandId=1
http://localhost:8080/price?applicationDate=2020-06-16T21:00:00&productId=35455&brandId=1