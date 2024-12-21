# Car Management System

## Objective
The Car Management System is designed to allow users to efficiently manage car details, including adding, updating, viewing, and deleting car information. It also includes advanced features like global search, pagination, sorting, input validation, and API documentation.

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

### Base URL
The API is hosted at: [http://34.93.234.254:8080/swagger-ui/index.html](http://34.93.234.254:8080/swagger-ui/index.html)

### Endpoints
1. **Create Car**:
    - `POST /Car/create`
    - Add a new car to the system.

2. **Update Car**:
    - `PUT /Car/update/{id}`
    - Update the details of an existing car.

3. **Delete Car**:
    - `DELETE /Car/delete/{id}`
    - Delete a car by its ID.

4. **Get Car by ID**:
    - `GET /Car/get/{id}`
    - Retrieve car details by ID.

5. **Get All Cars**:
    - `GET /Car/cars/{page}/{size}`
    - Retrieve all cars with support for pagination and sorting.

6. **Global Search**:
    - `GET /Car/search`
    - Search for cars based on name, model, year, color, or fuel type.

---

## Deployment Details

- **Hosting**: Google Kubernetes Engine (GKE).
- **API Documentation**: Accessible at [Swagger UI](http://34.93.234.254:8080/swagger-ui/index.html).

---

## Setup Instructions

1. **Clone the Repository**:
   ```bash
   https://github.com/Ashutosh-rajput/TrainingMug.git
