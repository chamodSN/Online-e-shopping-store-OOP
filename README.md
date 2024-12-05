# Nexify: An Online E-Shopping Store

![Nexify](readmeImages/home.png)


## Introduction

Nexify is a user-friendly online e-shopping platform designed to simplify the shopping experience. This project was developed as part of the Object-Oriented Programming (OOP) module in Year 2, Semester 1 at SLIIT.

Our project emphasizes **clean code**, **modular design**, and a **well-organized file structure**, adhering to Java naming conventions and best practices.

---

## Features

- **Admin Functionality**: Admins can add new products to the platform.
- **Search Functionality**: Users can search for products by name or category for easier navigation.
- **User Authentication**: Users must log in to add or view reviews for products.
- **Guest Accessibility**: Non-logged-in users can browse and add items to their cart using sessions.
- **Dynamic Shopping Cart**: Allows cart functionality for both logged-in and guest users.
- **Product Reviews**: Reviews and ratings are accessible only after logging in.
- **Order Management**: Order details can be added, updated, or deleted. However, inventory quantity remains unchanged (future enhancement planned).
- **Front-End Validations**: Ensures data integrity and provides a seamless user experience.
  
---

## File Structure

The project is organized following the **MVC architecture** and proper Java coding conventions to ensure clarity and scalability.


---

## Project Highlights

- **Technology Stack**: 
  - Java Servlets and JSP
  - MVC Architecture
- **OOP Principles**: 
  - Utilized abstraction, inheritance, interfaces, and polymorphism.
- **Session Management**: 
  -Enabled shopping cart functionality without requiring a login.
- **Coding Standards**:
  - Proper naming conventions for classes, methods, and variables.
  - Clear separation of concerns across layers: Controller, DAO, Model, Service.
 
---

## Installation Instructions for Users

1. **Download the project** files or clone the repository.
2. **Set up the database** using the provided schema.
3. **Open the project in Eclipse IDE**.
   - Navigate to `File > Import > Existing Projects into Workspace`.
4. **Configure the database connection** in the DBConnect class.
   - Navigate to `dao > DBConnect`.
5. **Configure the server**:
   - Add an **Apache Tomcat** server to Eclipse.
   - Deploy the project on the configured server.
6. **Run the project on the server**:
   - Right-click the project in Eclipse and select `Run As > Run on Server`.
7. **Access the application through the browser**.

---

## We welcome contributions to Nexify!
