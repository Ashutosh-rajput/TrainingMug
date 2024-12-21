# Car Management System

## Objective
The Car Management System is designed to allow users to efficiently manage car details, including adding, updating, viewing, and deleting car information. It also includes advanced features like global search, pagination, sorting, input validation, and API documentation.

---

## Deployment Details

- **Hosting**: Google Kubernetes Engine (GKE).
- **API Documentation**: Accessible at [http://34.93.234.254:8080/swagger-ui/index.html](http://34.93.234.254:8080/swagger-ui/index.html).

---

## Features

### Functional Requirements
1. **CRUD Operations**:
    - **Create**: Add new cars with details:
        - Car Name
        - Model
        - Year
        - Price
        - Color
        - Fuel Type (Petrol, Diesel, Electric, etc.)
    - **Read**:
        - View a list of all cars.
        - Filter cars by name, model, or year.
    - **Update**: Modify details of existing cars.
    - **Delete**: Remove car entries by ID.
2. **Additional Features**:
    - **Global Search**: Search for cars using various attributes like name, model, year, color, or fuel type.
    - **Pagination & Sorting**: Display large datasets with ease, supporting pagination and sorting.
    - **Validation**: Ensure proper data submission by validating all inputs.
    - **API Documentation**: Document all API endpoints using Swagger/OpenAPI.
    - **API Hosting**: The APIs are hosted on Google Kubernetes Engine (GKE) and accessible via a public URL.

### Technical Requirements
- **Backend Framework**: Spring Boot.
- **Database**: MySQL.
- **API Documentation**: Swagger.

---

## API Endpoints

### Endpoints

- **Create Car**:  
  `POST /cars`  
  Add a new car to the system.

- **Update Car**:  
  `PUT /cars/{id}`  
  Update the details of an existing car.

- **Delete Car**:  
  `DELETE /cars/{id}`  
  Delete a car by its ID.

- **Get Car by ID**:  
  `GET /cars/{id}`  
  Retrieve car details by ID.

- **Get All Cars**:  
  `GET /cars`  
  Retrieve all cars with support for pagination and sorting.

- **Global Search**:  
  `GET /cars/search`  
  Search for cars based on name, model, year, color, or fuel type.


