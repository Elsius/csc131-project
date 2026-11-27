# csc131-project
CSC131 Project
# Description
Our project is to create a health data application that tracks and calculates user health such as sleep, exercise, and eating habits. Users can view their health data over time and obtain a healthier lifestyle through the application’s feedback based on the user’s input data.
# Architecture diagram
<img alt="Software architecture diagram" src="https://github.com/user-attachments/assets/86b86715-1ad6-416d-8930-50f0f07a3fc9" />

# Development tools
- Java (JDK 8)
- SQLite
- SQLite JDBC Driver
# Compile and run
1. Place the SQLite JDBC Driver JAR file in the app directory. 
2. `javac Main.java`
3. `java -classpath ".;sqlite-jdbc-VERSION.jar Main` where VERSION is the version of SQLite JDBC Driver you are using. If you are not using Windows, use `:` instead of `;`.
