# Student Data Entry Application

This is a simple Student Data Entry application that uses **JDBC** to interact with a **MySQL** database. It allows users to perform basic CRUD (Create, Read, Update, Delete) operations on student records.

---

## 🎯 Features

- **Add Student**: Add a new student to the database.
- **Display All Students**: View all student records.
- **Search Student**: Search for students by PRN, name, or student ID.
- **Update Student**: Modify an existing student’s name and age using their PRN.
- **Delete Student**: Remove a student record using their PRN.

---

## 🛠️ Requirements

- **Java**: JDK 8 or later  
- **MySQL Database**: MySQL server should be installed and running  
- **MySQL Connector/J**: JDBC driver for MySQL

---

## ⚙️ Setup Instructions

### 1. Set up MySQL Database

Before running the application, you need to create a database and the required table in MySQL. Use the following SQL commands:

```sql
CREATE DATABASE student_db;

USE student_db;

CREATE TABLE students (
    id INT AUTO_INCREMENT PRIMARY KEY,
    prn VARCHAR(20) NOT NULL UNIQUE,
    name VARCHAR(100) NOT NULL,
    age INT NOT NULL
);
---
markdown
Copy
Edit
### 2. Download and Add MySQL JDBC Driver

Download the MySQL JDBC driver from [here](https://dev.mysql.com/downloads/connector/j/).

Once downloaded, follow these steps to add it to your IntelliJ project:

1. Open your project in **IntelliJ**.
2. Go to **File > Project Structure > Modules > Dependencies**.
3. Click the **+ (Add)** button and choose **JARs or directories**.
4. Select the MySQL JDBC `.jar` file you downloaded.
5. Click **Apply** and **OK**.

---

### 3. Update Database Connection Details

Update the following lines in your `Main.java` file to match your MySQL server configuration:

```java
private static final String URL = "jdbc:mysql://localhost:3306/student_db";
private static final String USER = System.getenv("DB_USER");
private static final String PASSWORD = System.getenv("DB_PASSWORD");
> 💡 **Make sure your environment variables `DB_USER` and `DB_PASSWORD` are set**, or replace them directly with your credentials in the code (not recommended for production use).

---

### 4. Running the Application

1. Open your project in **IntelliJ**.
2. Locate and open the `Main.java` file.
3. Right-click on `Main.java` and select **Run 'Main'**.

---

### 5. Available Operations

Once the application starts, you can choose from the following options:

Add Student: Add a student by entering their PRN, name, and age.

Display All Students: View the list of all students in the database.

Search Student: Search for students by PRN, name, or ID.

Update Student: Update a student's name and age by their PRN.

Delete Student: Delete a student by their PRN.

Exit: Exit the application.