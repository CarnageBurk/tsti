# Estructura del proyecto
proyecto-logistica/
├── pom.xml
└── src
    └── main
        ├── java
        │   └── com
        │       └── [apellidos]
        │           └── logistica
        │               ├── LogisticaApplication.java
        │               ├── controller
        │               │   ├── CamionController.java
        │               │   ├── PaqueteController.java
        │               │   ├── RutaController.java
        │               │   └── UbicacionController.java
        │               ├── model
        │               │   ├── Camion.java
        │               │   ├── Ciudad.java
        │               │   ├── Paquete.java
        │               │   └── Ruta.java
        │               ├── repository
        │               │   ├── CamionRepository.java
        │               │   ├── CiudadRepository.java
        │               │   ├── PaqueteRepository.java
        │               │   └── RutaRepository.java
        │               └── service
        │                   ├── CamionService.java
        │                   ├── CiudadService.java
        │                   ├── PaqueteService.java
        │                   └── RutaService.java
        └── resources
            └── application.properties

# Contenido del pom.xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 https://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>
    
    <parent>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-parent</artifactId>
        <version>3.2.2</version>
        <relativePath/>
    </parent>
    
    <groupId>com.[apellidos]</groupId>
    <artifactId>proyecto-logistica</artifactId>
    <version>0.0.1-SNAPSHOT</version>
    <name>Proyecto Logística</name>
    
    <properties>
        <java.version>17</java.version>
    </properties>
    
    <dependencies>
        <!-- Spring Web -->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
        </dependency>
        
        <!-- Spring Data JPA -->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-data-jpa</artifactId>
        </dependency>
        
        <!-- Base de datos H2 para desarrollo -->
        <dependency>
            <groupId>com.h2database</groupId>
            <artifactId>h2</artifactId>
            <scope>runtime</scope>
        </dependency>
        
        <!-- Validación -->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-validation</artifactId>
        </dependency>
        
        <!-- Tests -->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-test</artifactId>
            <scope>test</scope>
        </dependency>
    </dependencies>
    
    <build>
        <plugins>
            <plugin>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-maven-plugin</artifactId>
            </plugin>
        </plugins>
    </build>
</project>

# Ejemplo de Configuración de Aplicación
# src/main/resources/application.properties
spring.datasource.url=jdbc:h2:mem:logisticadb
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=password
spring.jpa.database-platform=org.hibernate.dialect.H2Dialect
spring.h2.console.enabled=true
