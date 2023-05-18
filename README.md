My TV Schedule API
===============================
It is test assignment to one software development company.

Requirements:
- Your mission is to create a backend Rest API for a web application - “My Tv Schedule”.
- The API should expose the following:
- Adding a tv show to my schedule. Input: tv show id
- Removing tv show from my schedule. Input: tv show id
- Getting tv shows in my schedule. Response: each show should include info on the tv show:
  id, name, image URL and the cast: id, name, image URL.
- Getting the first unwatched episode for each tv show in my schedule. Response: each tv
  show should include info on the show and episode info: id, episode name, season and
  episode number, and air date
- Marking an episode as watched. Input: episode id
- To get all the tv shows data use http://www.tvmaze.com/api
- Use any JVM-based language
- Use any Java/Kotlin/Scala/etc. framework or library that will help you to do your job
- Code should be easy to understand (even without comments)
- Data should be persistent, no matter if you will use sql or NoSQL solution, as long as it will
  suite the problem
- Test your code to make sure it works

** Optional:
- Provide suggestions for tv shows to watch based on the cast of tv shows that you watch
- Add to the “get tv shows api” the option to filter by shows with unwatched episodes,
  all.
- Add sorting by first episode air date, date of the first unwatched episode
- Add your own feature and explain why you chose to add it


Prerequisites:
- Java 17
- Mysql up and running

How to run:
1. Download and start docker with MySQL
docker pull mysql/mysql-server:latest
docker run -d -p 3306:3306 --name mysql-docker-container -e MYSQL_ROOT_PASSWORD=sergey -e MYSQL_DATABASE=tv_show_app -e MYSQL_USER=test -e MYSQL_PASSWORD=test mysql/mysql-server:latest

2. Build and run application
./mvnw clean install
Jacoco code coverage could be seen at target/site/jacoco/index.html
./mvnw spring-boot:run

3. Use swagger for testing
   http://localhost:8080/swagger-ui/index.html#