# TwitterApp(inspired by the company of the same name)
This is an introduction to the TwitterApp! This projected has been created by using the tools:React,Spring Boot
and postgressSQL to create an indie version of the well known twitter(now X) social media. Every user can login via 
email and password and view tweets and their comments and also give them the ability to post their own tweets.

## Features
-Explore the tweetfeed and several posts and comments
-User authentication and sign-in requirements
-Publish posts to twitter

## Technologies applied
### Backend
-Spring Boot: It is a simpler framework which is used to the developmet of Java applications
-Java:High-level, object oriented programming language
-Maven:Build automation and project management tool in Java development

### Frontend
-React:Frontend UI framework
HTML:HyperText Markup Language for webpage structure
CSS:Cascading Style Sheets for styling

### Database
-PostgreSQL: open-source relational database management system (RDBMS)


## Running the project
### Requirements
The software that needs to be installed before executing the application are the following:
-Node.js
-npm
-postgreSQL v.15

## Utilazing the above stated software
The following steps are need to run the application

1.Run the app to start schema creation:

  -Open new terminal.
  -Navigate to root of the project where the pom.xml of the parent project is located:
  cd {CLONED_DIRECTORY_PATH}\bootcamp.23.06.av\
  -Run the command:mvn spring-boot:run


2.Setting up the database locally
  -After installing PostGreSQL server and the service is running set the PATH environment variables to include:
  {POSTGRESQL_INSTALLATION_DIRECTORY}\{VERSION}\bin
  -Then navigate to:{CLONED_DIRECTORY_PATH}/src/main/resources/migrations/
  -Open a terminal and run: psql -U postgres -d postgres -a -f V1_efant_db_schema.sql -W

3.Restart the backend server: close running application and again the command: nvm spring-boot:run

4.Start the frontend development server:
  -Open a new terminal.
  -Navigate to the frontend application: cd {CLONED_DIRECTORY_PATH}\bootcamp.23.06.av\twitter-frontend
  -Make sure if running the app for the first time run the command:npm install
  -Run the command: npm start

5.Access the app via browser at: http://localhost:3000

## Examples 
In order to make sure this app runs properly the postman tool has been utilized to insert some
"users" in databases which things like email and password included in said user. Otherwise if 
there is already database at your convinience that includes all the details and requiriments of
what a twitter user is supposed to be then you should be able to run your own database at the app


## Screenshots
Running at first
![εικόνα](https://github.com/alexvls07/bootcamp-23-06-av/assets/138501703/76f2e8b9-7b3a-4dec-8fad-820985bede36)

login-page

![εικόνα](https://github.com/alexvls07/bootcamp-23-06-av/assets/138501703/1c3cbcb0-4048-49c5-966d-8fe7f747eb5a)


posting a tweet

![εικόνα](https://github.com/alexvls07/bootcamp-23-06-av/assets/138501703/7132ed35-f6e8-4130-8de9-4dcba8225383)


