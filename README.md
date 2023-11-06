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

This project was created and run with inteliJ Ultimate and the above software depending on the version of
the editor will likely be already installed in process. Just in case make sure all above is installed regardless
of the version you have.


## Utilazing the above stated software
The following steps are need to run the application.
In our case we are using inteliJ editor to run all we need.

1.Start schema creation:

First method: inteliJ Ultimate provides built-in tools to create and modify the database you need.

Second method: In case you have no access to inteliJ Ultimate you can inteliJ community edition which
is free but the only thing you must consider when you attempt to run the app is that the database
tools will not be included in the community edition therefore you need to establish the database in different
app which many of them are free of charge.

Whatever method you choose the database server must be connected to the localhost for this app at all times to run properly.

2.Running the API
To start the backend process by using inteliJ navigate to

twitter-rest-api->src->main->java->bootcamp2306_av->TwitterRestApiApplication
Run TwitterRestApiApplication with debug and wait for a while to make sure the backend is not interrupted.

For the frontend go the terminal of inteliJ and navigate to \Program Files\nodejs\npm.cmd then type "run start".
After a few seconds the app will run to your default browser.

You can also access the app via browser at: http://localhost:3000

## Examples 
In order to make sure this app runs properly the postman tool has been utilized to insert some
"users" in databases which things like email and password are included in said user. Otherwise if 
there is already database at your convinience that includes all the details and requirements of
what a twitter user is supposed to be then you should be able to run your own database at the app.
At this point the app needs a database to see the full potential otherwise it will show no users
whatsoever but it will still have base interface intact.


## Screenshots
Running at first
![Screenshot_1](https://github.com/alexvls07/bootcamp-23-06-av/assets/138501703/3c799c25-9852-407f-a9ea-88d94b8490fc)

login-page
![Screenshot_2](https://github.com/alexvls07/bootcamp-23-06-av/assets/138501703/f5209563-3cc0-4232-ba9a-4e8977616147)




posting a tweet
![Screenshot_3](https://github.com/alexvls07/bootcamp-23-06-av/assets/138501703/1667515e-ed86-433c-b361-38eb58891f89)
![Screenshot_4](https://github.com/alexvls07/bootcamp-23-06-av/assets/138501703/2a95d908-68c7-450e-86db-f54946cc0d53)




