# Spring Boot Demo Project

## Overview

The Spring Boot Demo Project is a sample application built using Spring Boot, designed to demonstrate the capabilities of the Spring framework for building RESTful web services. This project showcases various features such as dependency injection, data access, and RESTful API development.

## Features

- **RESTful API**: Provides a set of endpoints for managing resources (e.g., customers, orders).
- **Spring Data JPA**: Utilizes Spring Data JPA for seamless database interactions.
- **H2 Database**: Uses an in-memory H2 database for quick setup and testing.
- **Exception Handling**: Implements global exception handling for better error management.
- **Validation**: Includes input validation for request data.
- **Unit and Integration Testing**: Contains tests to ensure the functionality of the application.

## Technologies Used

- **Java 11**: The programming language used for the application.
- **Spring Boot**: The framework for building the application.
- **Spring Data JPA**: For data access and repository management.
- **H2 Database**: An in-memory database for development and testing.
- **Maven**: For project management and dependency management.

## Getting Started

### Prerequisites

- Java 11 or higher
- Maven 3.6 or higher

### Installation

1. **Clone the repository**:

   ```bash
   git clone https://github.com/see-why/spring-boot-demo.git
   cd spring-boot-demo
   ```

2. **Build the project**:

   ```bash
   mvn clean package
   ```

3. **Run the application**:

   ```bash
   mvn spring-boot:run
   ```

4. **Access the application**: Open your web browser and navigate to `http://localhost:8080`.

### API Endpoints

The following endpoints are available in the application:

- **GET /customers**: Retrieve a list of all customers.
- **GET /customers/{id}**: Retrieve a specific customer by ID.
- **POST /customers**: Create a new customer.
- **PUT /customers/{id}**: Update an existing customer.
- **DELETE /customers/{id}**: Delete a customer by ID.

### Example Requests

#### Create a Customer

```http
POST /customers
Content-Type: application/json

{
    "name": "John Doe",
    "email": "john.doe@example.com",
    "age": 30
}
```

#### Get All Customers

```http
GET /customers
```

#### Update a Customer

```http
PUT /customers/1
Content-Type: application/json

{
    "name": "Jane Doe",
    "email": "jane.doe@example.com",
    "age": 28
}
```

#### Delete a Customer

```http
DELETE /customers/1
```

## Testing

The project includes unit and integration tests to ensure the functionality of the application. You can run the tests using Maven:

```bash
mvn test
```

## Configuration

The application can be configured using the `application.properties` file located in the `src/main/resources` directory. You can customize the database connection settings, logging levels, and other properties as needed.

### Example Configuration

```properties
# H2 Database Configuration
spring.datasource.url=jdbc:h2:mem:testdb
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=

# JPA Configuration
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

## Contributing

Contributions are welcome! If you have suggestions for improvements or new features, please open an issue or submit a pull request.

1. Fork the repository.
2. Create a new branch (`git checkout -b feature/YourFeature`).
3. Make your changes and commit them (`git commit -m 'Add some feature'`).
4. Push to the branch (`git push origin feature/YourFeature`).
5. Open a pull request.

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

## Acknowledgments

- Thanks to the Spring community for their support and resources.
- Special thanks to the contributors and open-source projects that inspired this demo.
