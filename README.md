# Student Records Management System

## Overview
The **Student Records Management System** is a Java-based application that allows users to manage student data efficiently. It provides full CRUD (Create, Read, Update, Delete) operations to handle student records stored in a MySQL database. This project is designed for educational purposes to demonstrate the integration of Java with JDBC for database management.

## Features
- Add new student records to the database.
- View all student records.
- Update existing student details.
- Delete student records.
- Console-based user interface for seamless interaction.

## Technologies Used
- **Programming Language:** Java
- **Database:** MySQL
- **Database Connectivity:** JDBC

## Installation Guide

### Prerequisites
- Java Development Kit (JDK) installed ([Download here](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html))
- MySQL server installed ([Download here](https://dev.mysql.com/downloads/installer/))
- An IDE like IntelliJ IDEA, Eclipse, or VSCode (optional but recommended)

### Steps
1. Clone this repository:
   ```bash
   git clone https://github.com/Lakhsmi-16/StudentRecords-Java-JDBC-MySQL.git
   ```
2. Open the project in your preferred IDE or navigate to the project directory.
3. Create a MySQL database using the following command:
   ```sql
   CREATE DATABASE student_records;
   ```
4. Import the provided SQL schema (if available) or create a `students` table:
   ```sql
   CREATE TABLE students (
     id INT AUTO_INCREMENT PRIMARY KEY,
     name VARCHAR(50) NOT NULL,
     age INT NOT NULL,
     department VARCHAR(50),
     email VARCHAR(100)
   );
   ```
5. Update the database configuration in the Java code (`DBConfig` class or equivalent):
   ```java
   String jdbcURL = "jdbc:mysql://localhost:3306/student_records";
   String username = "your_mysql_username";
   String password = "your_mysql_password";
   ```
6. Compile and run the application:
   ```bash
   javac Main.java
   java Main
   ```

## Usage
1. Follow the menu options displayed in the console to:
   - Add a student
   - View all students
   - Update a student's record
   - Delete a student's record

### Example Commands
**Adding a Student:**
```
Enter name: John Doe
Enter age: 22
Enter department: Computer Science
Enter email: john.doe@example.com
```

**Viewing Records:**
```
ID: 1, Name: John Doe, Age: 22, Department: Computer Science, Email: john.doe@example.com
```

## Contributions
Contributions are welcome! To contribute:
1. Fork the repository.
2. Create a new branch for your feature or bug fix:
   ```bash
   git checkout -b feature-name
   ```
3. Commit your changes and push to the branch:
   ```bash
   git commit -m "Add feature description"
   git push origin feature-name
   ```
4. Create a pull request.

## License
This project is licensed under the MIT License. See the `LICENSE` file for details.

---
Feel free to reach out for any queries or suggestions!

