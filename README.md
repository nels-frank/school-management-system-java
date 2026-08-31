# School Management System — Java EE

### Full-Stack Java Enterprise School Management System

A comprehensive school management application developed in **2022** to support student administration, academic result computation, fee management, staff/user administration and other core school operations.

This project was developed using **Java EE, JSF, MySQL and GlassFish**, and represents an important stage in my progression as a software developer.

---

## 🚀 Project Overview

The School Management System was designed to provide schools with a centralized application for managing academic, administrative and financial operations.

The system brings several school processes together within one application, reducing the need for separate manual processes and providing administrators and school personnel with structured access to important information.

### Major Areas Covered

* Student Management
* Student Profiles
* Result Management
* Result Computation
* Subject Management
* Class Management
* Teacher Allocation
* Fees Management
* Expenditure Management
* User Management
* Student Result Printing
* Student Profile Printing
* Financial Receipts

---

## 📸 Project Preview

![School Management System](src/LandingPage.JPG)

---

## ✨ Key Features

### 👨‍🎓 Student Management

* Student registration and management
* Student profile management
* Student listing
* Student information viewing
* Student profile printing
* Student result viewing

### 📊 Result Management

* Result computation
* Class result computation
* Subject result computation
* Affective domain computation
* Computed subjects management
* Result management dashboard
* Student result printing
* Full result printing

### 👨‍🏫 Academic Administration

* Subject management
* Form teacher allocation
* Head teacher replacement
* Class-based academic management

### 💰 Fees Management

* Fees management dashboard
* Student fee payment
* Payment using registration number
* Payment confirmation
* Payment receipts
* Fees management authentication

### 💼 Financial Management

* Expenditure management
* Financial record management
* Fee payment tracking
* Payment receipt generation

### 👥 User Management

* User dashboard
* User authentication
* Administrative access
* Role-based system functionality

---

# 📸 Screenshots

## 🏠 System Interface

### Landing Page

![Landing Page](src/LandingPage.JPG)

### User Dashboard

![User Dashboard](src/UserDashboard.JPG)

---

## 👨‍🎓 Student Management

### All Students — First View

![All Students First View](src/AllStudentsFirstView.JPG)

### All Students List

![All Students List](src/AllStudentsList.JPG)

### Student Profile — Part A

![Student Profile A](src/StudentProfileA.JPG)

### Student Profile — Part B

![Student Profile B](src/StudentProfileB.JPG)

### Student Profile Printout

![Student Profile Printout](src/StudentProfilePrintOut.JPG)

---

## 📊 Result Management

### Result Management Login

![Result Management Login](src/ResultManagementLogin.JPG)

### Result Computation Dashboard

![Result Computation Dashboard](src/ResultComputationDashboard.JPG)

### Class Result Computation

![Class Result Computation](src/ClassResultComputation.JPG)

### Subject Computation by Class

![Subject Computation by Class](src/SubjectComputationByClass.JPG)

### Affective Domain Computation

![Affective Domain Computation](src/AffectiveDomainComputation.JPG)

### Computed Subjects List

![Computed Subjects List](src/ComputedSubjectsList.JPG)

---

## 📝 Student Results

### Student Result — Part A

![Student Result A](src/StudentResultA.JPG)

### Student Result — Part B

![Student Result B](src/StudentResultB.JPG)

### Print Student Result

![Print Student Result](src/PrintStudentResult.JPG)

### Full Printed Result

![Full Printed Result](src/FullPrintedResult.JPG)

---

## 💰 Fees Management

### Fees Management Login

![Fees Management Login](src/FeesManagementLogin.JPG)

### Fees Dashboard

![Fees Dashboard](src/FeesDashboard.JPG)

### Fees Payment with Registration Number

![Fees Payment With Registration Number](src/FeesPaymentWithRegNo.JPG)

### Payment Confirmation

![Fees Payment Confirmation](src/FeesPaymentConfirmation.JPG)

### Fees Payment Receipt

![Fees Payment Receipt](src/FeesPaymentReciept.JPG)

### Fees Payment Receipt — Additional View

![Fees Payment Recipt](src/FeesPaymentRecipt.JPG)

---

## 💼 Financial Management

### Expenditure Management

![Expenditure Management](src/ExpenditureManagement.JPG)

---

## 👨‍🏫 Academic Administration

### Form Teacher Allocation

![Form Teacher Allocation](src/FormTeacherAllocation.JPG)

### Head Teacher Replacement

![Head Teacher Replacement](src/HeadTeacherReplacement.JPG)

---

# 🛠️ Technology Stack

### Backend

* Java
* Java EE

### Frontend

* JSF (JavaServer Faces)

### Database

* MySQL

### Application Server

* GlassFish

### Development Environment

* NetBeans
* Java Development Kit (JDK)

---

# 🏗️ Application Architecture

The application follows a Java enterprise application architecture in which the presentation layer communicates with the application's business logic and database.

```text
User
 ↓
JSF User Interface
 ↓
Java EE Application
 ↓
Business Logic
 ↓
Database Access
 ↓
MySQL Database
```

The application is deployed and executed through **GlassFish Server**, providing the runtime environment for the Java EE application.

---

# 🔄 Application Workflow

A typical system workflow follows this pattern:

```text
User
 ↓
Authentication
 ↓
Dashboard
 ↓
Select Management Module
 ↓
Application Processing
 ↓
Database Operation
 ↓
Result / Record
 ↓
User Interface
```

Different modules provide specialized workflows for students, academic results, fees and financial management.

---

# ⚙️ Getting Started

## Prerequisites

To run the project locally, you would typically need:

* Java JDK
* NetBeans IDE
* GlassFish Server
* MySQL Server
* MySQL database configuration
* Git

## Installation

Clone the repository:

```bash
git clone https://github.com/nels-frank/school-management-system-java.git
```

Navigate into the project directory:

```bash
cd school-management-system-java
```

Open the project using **NetBeans IDE**.

Configure the application according to the project's Java EE and GlassFish configuration.

---

# 🗄️ Database Setup

The application uses **MySQL** as its database system.

Create/configure the required database and update the application's database connection configuration to point to the local MySQL server.

The database configuration should contain the appropriate:

* Database name
* Username
* Password
* Host
* Port

Database credentials should never be committed to the repository.

---

# ▶️ Running the Application

After configuring the database and GlassFish Server:

1. Open the project in NetBeans.
2. Configure the GlassFish application server.
3. Configure the MySQL database connection.
4. Build the application.
5. Deploy the application to GlassFish.
6. Start the GlassFish server.
7. Open the deployed application in a web browser.

---

# ☁️ Deployment

The original application was developed as a **Java EE enterprise application** and designed to run on **GlassFish Server**.

Unlike the modern school management project, this application represents an earlier generation of enterprise web application architecture.

---

# 🧩 Challenges & Solutions

## Managing Multiple School Operations

The system needed to support several different areas of school administration within one application.

**Solution:**
The application was organized into functional modules covering student management, academic results, fees, financial operations and user management.

## Result Computation

Academic results required several different computations, including class results, subject results and affective-domain assessments.

**Solution:**
Dedicated result management and computation functionality was developed to process and present academic information.

## Student Records

Student information needed to be accessible across different areas of the system.

**Solution:**
Student information was organized into structured profiles and connected to related academic and administrative records.

## Fees Management

The system needed to support fee payments and provide confirmation and receipt functionality.

**Solution:**
A dedicated fees management module was implemented with payment lookup, confirmation and receipt-generation functionality.

## Enterprise Deployment

The application needed an appropriate Java enterprise runtime environment.

**Solution:**
The system was developed for deployment through **GlassFish Server**, providing the Java EE runtime required by the application.

---

# 🔒 Security Considerations

* Authentication is used to restrict access to management functions.
* Database credentials should be kept outside publicly accessible source code.
* Administrative functions should be protected according to user permissions.
* Production credentials should never be committed to GitHub.

---

# 📚 What I Learned

Developing this project strengthened my understanding of enterprise application development and provided practical experience with:

* Java
* Java EE
* JSF
* MySQL
* GlassFish
* Enterprise web application architecture
* Database-driven application development
* Student information management
* Academic result computation
* Financial management systems
* Authentication
* Application deployment

---

# 🔄 Development Journey

This project is an important part of my development journey.

### 2022

**Java • Java EE • JSF • MySQL • GlassFish**

↓

### 2026

**Next.js • TypeScript • Node.js • Prisma • PostgreSQL**

The 2022 system established my experience with enterprise Java application development, while my 2026 School Management System demonstrates my transition into modern full-stack web development.

---

# 🚀 Future Improvements

If this system were to be modernized further, potential improvements could include:

* Migration to a modern TypeScript/Next.js architecture
* RESTful backend services
* Modern responsive UI
* Cloud deployment
* Advanced analytics and reporting
* Online payment gateway integration
* Automated notifications
* Parent and student portals
* Enhanced role-based access control
* Mobile-focused experience

---

# 📌 Project Status

**Completed — 2022**

This project is maintained as part of my professional software development portfolio and demonstrates my experience with Java enterprise application development.

---

# 👨‍💻 Author

## Adzua Terhemen Frank

**Full-Stack Software Developer**

I build modern web applications and business systems that solve real-world problems.

**GitHub:**
https://github.com/nels-frank

**LinkedIn:**
https://www.linkedin.com/in/adzua-frank-523302324/

**Email:**
[frankadzua@gmail.com](mailto:frankadzua@gmail.com)

**Phone:**
+234 706 665 2626
+234 815 480 0458

---

# 📄 License

This project is presented as a professional portfolio project.
