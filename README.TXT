PROJECT TITLE: SCIS Student Complaint Registration System
PURPOSE OF PROJECT:
VERSION or DATE:
HOW TO START THIS PROJECT:
AUTHORS: 
USER INSTRUCTIONS:

# SCIS Student Complaint Registration System

## Project Overview

This is a text-based Java application developed as a mini-project for students at the University of Hyderabad (UoH), School of Computer and Information Sciences (SCIS). It allows students to **register complaints**, track them, and enables **admins and faculty** to manage and resolve them.

---

## Features Implemented

- **Student login and complaint submission**
- **Admin login to review and assign complaints**
- **Faculty login to view and resolve complaints**
- **Persistent file-based complaint storage**
- **Menu-driven console interaction for all roles**

---

## How to Run the Application

### Requirements
BlueJ(recommended)

### Compilation

Compile all class files:


### Execution

Run the main class:


The system will prompt for login. Use predefined credentials:

## File Storage

- Complaint data is stored in a file: `data/complaints.ser`
- Complaints are saved after every action and reloaded at startup.
- Serialization ensures persistence of data between sessions.

---

## Object-Oriented Concepts Used

### 1. **Abstraction**
- Abstract class `User` provides a common interface for all types of users.
- Subclasses implement their own `displayMenu()` behavior.

### 2. **Encapsulation**
- Fields like `password`, `complaint ID`, etc., are kept private/protected and accessed via methods.
- Complaint state changes are controlled via methods like `assignTo()` and `resolve()`.

### 3. **Inheritance**
- `Student`, `Admin`, and `Faculty` all extend `User`, inheriting common properties.

### 4. **Polymorphism**
- The system uses **runtime polymorphism** through `displayMenu()` — the method call behaves differently depending on the actual user object.

### 5. **Information Hiding**
- Internal logic like complaint status changes, file saving/loading is hidden within `ComplaintManager`.

---

## Class Structure Summary

| Class              | Role |
|--------------------|------|
| `User` (abstract)  | Base class for all users |
| `Student`          | Submits and views their complaints |
| `Admin`            | Views and assigns all complaints |
| `Faculty`          | Views and resolves assigned complaints |
| `Complaint`        | Stores complaint details |
| `ComplaintManager` | Manages storage, retrieval, and updates of complaints |
| `Main`             | Runs the application, handles login and setup |

---

## Notes for Evaluator

- All user roles interact through clean console menus.
- Complaint data survives restarts via `Serializable` file storage.
- Faculty and students see only complaints relevant to them, using proper reference matching after deserialization.
- The code follows Java OOP best practices and includes exception handling and validation.

---

## Future Enhancements (optional)
- Add registration for new users
- Integrate with a database (in future phases)
- Add complaint categories and priorities
