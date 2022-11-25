# Backend Motos
Projecto dedicado a la creación de un sistema de administración para diferentes utilidades

Created with SpringBoot, ApacheTomCat, Mongo and Lombok

# Requeriments
- Java 11
- Docker

# Setup
Para iniciar la base de datos se debe instalar docker (bien sea solo el CLI o el Desktop)
Dentro de una terminal ejecutar el comando `docker-compose -up -d`

En caso de que no estén dentro del archivo `application.properties` se deben agregar las siguientes lineas:
```
    spring.data.mongodb.authentication-database=admin
    spring.data.mongodb.database=motosdb-local
    spring.data.mongodb.port=27017
    spring.data.mongodb.username=rootuser
    spring.data.mongodb.password=rootpass
    spring.data.mongodb.host=localhost
```

Una vez validado que todo esté correcto y el contenedor con la BD se esté ejecutando, se debe ejecutar la tarea `MotosApplication`


*CodeScripters*