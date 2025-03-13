## Getting Started

Welcome to the VS Code Java world. Here is a guideline to help you get started to write Java code in Visual Studio Code.
i developed a simple Java project using the JavaFX framework for the user interface and Oracle 21c for database management. The project focused on creating an interactive and user-friendly application with features such as data input, retrieval, and basic CRUD (Create, Read, Update, Delete) operations. JavaFX provided a dynamic and responsive UI, while Oracle 21c ensured efficient data storage and management. The project demonstrated seamless database connectivity using JDBC, enabling smooth interaction between the front-end and back-end. It served as a practical implementation of UI development and database integration using modern Java technologies.

## Folder Structure

The workspace contains two folders by default, where:

- `src`: the folder to maintain sources
- `lib`: the folder to maintain dependencies

Meanwhile, the compiled output files will be generated in the `bin` folder by default.

> If you want to customize the folder structure, open `.vscode/settings.json` and update the related settings there.

## Dependency Management
### JavaFX Project with Oracle 21c Database  

This project is a simple Java application built using the JavaFX framework for the graphical user interface and Oracle 21c for database management. It allows users to interact with a database, performing operations like storing and retrieving user details.  

#### Setup Instructions Before Running the Project:  

1. Build JavaFX Dependencies:  
   - Ensure you have the necessary JavaFX libraries configured in your project.  
   - If using VS Code, add the required JavaFX modules in your build path.  

2. Database Setup (Oracle 21c):  
   - Before running the project, create a table in your Oracle 21c database:  

     ```sql
     CREATE TABLE users (
         usernames VARCHAR2(50) PRIMARY KEY,
         passwords VARCHAR2(50) NOT NULL,
         mobile_numbers VARCHAR2(15) UNIQUE NOT NULL,
         emailids VARCHAR2(100) UNIQUE NOT NULL
     );
     ```

3. Add Required Libraries:  
   - Include the JDBC driver for Oracle 21c in your project to enable database connectivity.  
   - In VS Code, ensure all required dependencies (JavaFX, JDBC) are added to the build path.
   - Add the necessary paths of pictures in fxml files from java_pictures directory

Once these dependencies are set up, you can run the project and interact with the database seamlessly.

The `JAVA PROJECTS` view allows you to manage your dependencies. More details can be found [here](https://github.com/microsoft/vscode-java-dependency#manage-dependencies).
