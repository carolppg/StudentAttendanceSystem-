## StudentAttendanceSystem-
Java GUI application to manage and record student attendance with SQLite.

## Project Overview

This project is a Java-based GUI application for managing student attendance. It allows instructors to add students, mark attendance by subject and date, and view records in a tabular format. The application uses a local SQLite database for data storage and Java Swing for the user interface.


## Features

- Add new students to the database
- Mark attendance for students by subject and date
- View all attendance records in a table
- SQLite database integration for persistent local storage
- Input validation and error messages for empty fields
- Clean and beginner-friendly user interface using Java Swing


## Project Structure 
StudentAttendanceSystem/
│
├── src/
│ ├── MainMenu.java # Main navigation menu
│ ├── AddStudentUI.java # UI to add new students
│ ├── MarkAttendanceUI.java # UI to mark attendance
│ ├── ViewAttendanceScreen.java # UI to display attendance records
│ └── DBConnection.java # Handles SQLite database connection
│
├── attendance.db # SQLite database file
├── README.md # Project documentation


## Technologies Used

- **Java** – for core application logic
- **Swing** – for building GUI components
- **AWT** – for layout management
- **SQLite** – for local database storage
- **JDBC** – for connecting Java to SQLite
- **IntelliJ IDEA** – development environment
- ## How I Ran the Project

I developed and ran the project using IntelliJ IDEA. I used the SQLite JDBC driver to connect the application to a local SQLite database.

To run the project, I set up the following:

- I opened the project folder in IntelliJ IDEA.
- I downloaded the SQLite JDBC driver from the official GitHub repository:  
  https://github.com/xerial/sqlite-jdbc/releases
- I added the `.jar` file to the project library using the **Project Structure** settings in IntelliJ.
- I made sure the database path in `DBConnection.java` matches the location of the database file on my system.
- I ran the `MainMenu.java` file, which opens the main menu of the application.
- From there, I was able to access all features: add student, mark attendance, and view attendance records.

The database file (`attendance.db`) is included in the project and is created automatically if it doesn’t exist. All data is stored locally.


