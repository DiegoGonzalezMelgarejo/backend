### 1 Herramientas de desarrollo

* IntelliJ
* JAVA 11
* Maven
*******

### 2 Ejecutar aplicación

- Debe tener el puerto 8080 libre
- mvn clean install
- mvn spring-boot:run

Luego de lo anterior la aplicación se ejecutar en http://localhost:8080/

### 2 Acceder al swagger
#### Swagger http://localhost:8080/v1/api/swagger-ui/index.html#/
#### Ejemplo de petición  curl -X POST "http://localhost:8080/v1/api/price" -H "accept: application/json" -H "Content-Type: application/json" -d "{ \"date\": \"2020-06-16-21.00.00\", \"idBrand\": 1, \"idProduct\": 35455}"