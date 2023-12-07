# Product Project

This project is a simple Spring Boot application that provides CRUD (Create, Read, Update, Delete) operations for managing products. It includes unit testing, data validation during save operations, and Swagger OpenAPI documentation for easy exploration of exposed APIs.

## Features

- **CRUD Operations:** Perform Create, Read, Update, and Delete operations on products.
- **Unit Testing:** Comprehensive unit tests for service layer methods.
- **Data Validation:** Ensure data integrity by validating inputs during the save operation.
- **Swagger OpenAPI Documentation:** Explore and test APIs easily using Swagger UI.

## API Endpoints

### Create Operations
- **Add a Single Product:** `POST /api/products/add-one`
- **Add Multiple Products:** `POST /api/products/add-multi`

### Read Operations
- **Get All Products:** `GET /api/products/all`
- **Get Product by ID:** `GET /api/products/id/{id}`
- **Get Product by Name:** `GET /api/products/name/{name}`

### Update Operation
- **Update Product:** `PUT /api/products/update/{id}`

### Delete Operation
- **Delete Product:** `DELETE /api/products/delete/{id}`

## Data Validation

- Name is required and cannot be blank.
- Quantity is required and must be greater than or equal to 0.
- Price is required and must be greater than or equal to 0.

## Swagger Documentation

Explore the APIs using Swagger UI by visiting [http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html) after starting the application.

 ## Getting Started

Follow these steps to get the Product Project up and running:

1. *Clone this repository to your local machine*
2. *Configure your database connection:*

      Open the src/main/resources/application.properties file and update the following properties with your database details:
      ```
      spring.datasource.url=jdbc:mysql://localhost:3306/yourdatabase
      spring.datasource.username=yourusername
      spring.datasource.password=yourpassword
      ```
      Replace yourdatabase, yourusername, and yourpassword with your actual database information.

4. *Import the project into your IDE:*

      For Eclipse:
      
        Open Eclipse.
        File -> Import -> Existing Maven Project.
        Select the cloned product-project directory.
        Click Finish.
      For other IDEs, follow the equivalent steps for importing a Maven project.

5. *Build and run the application*
6. Access the application through a web browser:

    Open your web browser and go to http://localhost:8080.
   

Now, your Product Project is up and running! You can start exploring the CRUD operations for managing products. Don't forget to check out the Swagger OpenAPI documentation at http://localhost:8080/swagger-ui.html to understand and test the exposed APIs.
