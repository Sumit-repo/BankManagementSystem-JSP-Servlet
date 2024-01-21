# Bank Management System - JSP & Servlet
## Table of Contents

- [Introduction](#introduction)
- [Features](#features)
- [Technologies Used](#technologies-used)
- [Getting Started](#getting-started)
  - [Prerequisites](#prerequisites)
  - [Installation](#installation)
- [Contributing](#contributing)
- [License](#license)

## Introduction

Welcome to the Bank Management System, a Java web application built using JSP and Servlet technologies. This project provides a comprehensive system for managing bank operations, catering to both employees and customers.
![Login Page](https://github.com/Sumit-repo/BankManagementSystem-JSP-Servlet/assets/52080842/68d63715-0b38-40b9-950e-8223aff4ce81)
## Features

![Employee Portal](https://github.com/Sumit-repo/BankManagementSystem-JSP-Servlet/assets/52080842/702ac183-b1e5-45a2-a70f-763a4a863e47)
- **Employee Portal:**
  - Customer Management
    - Add new customer.
    - View details of customers.
    - Update name/password.
    - Block/unblock customer accounts.
    - Delete customer accounts.
    - View all customer accounts.

![Customer Portal](https://github.com/Sumit-repo/BankManagementSystem-JSP-Servlet/assets/52080842/d294fae4-0a8e-4d79-b5d4-f15842bd85fc)
- **Customer Portal:**
  - Account Management
    - Transfer money.
    - Deposit money.
    - Withdraw money.
    - Check balance.
    - Update account details.
    - Account statement.
    - Delete accounts.

- **Security and Transactions:**
  - User Authentication and Authorization.
  - Transaction Management.
  - Database Normalization.

- **Logging and Error Handling:**
  - Comprehensive error handling for user-friendly feedback.
  - Logging mechanisms to track critical actions and events.

## Technologies Used

- Java
- JSP (JavaServer Pages)
- Servlets
- JDBC (Java Database Connectivity)
- Maven
- JUnit (for testing)

## Getting Started

### Prerequisites

- Java Development Kit (JDK)
- Apache Maven
- Servlet Container (e.g., Apache Tomcat)
- Database (Prefered `MySQL`)

### Installation

1. Clone the repository:
   ```bash
   git clone https://github.com/your-username/BankManagementSystem-JSP-Servlet.git
   ```
2. Configure your database settings as shown in Schema diagram
   ![Schema](https://github.com/Sumit-repo/BankManagementSystem-JSP-Servlet/assets/52080842/9fd36401-b64e-45f4-9c54-fe1326866584)
3. Build the project using Maven:
   ```bash
   mvn clean install
   ```
4. Deploy the application to your servlet container.
5. Access the application at `http://localhost:8080/Your-project-name`

## Contributions
Contributions are welcome! If you have suggestions or find bugs, please open an issue or submit a pull request. Follow our contribution guidelines for more details.

## License
This project is licensed under the MIT License.
