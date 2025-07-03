# Java JDBC Employee Management App

Java CLI app using JDBC to perform CRUD on MySQL employee database.

## Features
- Add, View, Update, Delete employee records
- Uses JDBC + PreparedStatement for safe operations
- Console-based UI

## Run
```bash
javac DBConnection.java EmployeeDAO.java EmployeeApp.java
java EmployeeApp

```
## Database Setup
```sql
CREATE DATABASE employee_db;
USE employee_db;
CREATE TABLE employees (
  id INT PRIMARY KEY AUTO_INCREMENT,
  name VARCHAR(100),
  role VARCHAR(100),
  salary DOUBLE
);
```
