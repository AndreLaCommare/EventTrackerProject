# EventTrackerProject

# Description
Event Tracker as of now is a project that implements some new technologies like REST Controllers and APIs. The goal was to create a database consisting of one or more tables, use a JPA to map said 
table(s) to a Java POJO, and finally utilize a Spring Boot application in order to implement API and and query the database. This project also allwoed us to use APi for the creation of CRUD operations within the app. My particular Event Tracker is a Gym Tracker, as of now the database consists of two tables (Gym and Member), and allows CRUD operations through API for both entities. All CRUD operations were tested through Postman while Entity mappings were tested through JUnit.

# Technologies Used
Java, Spring Data JPA, REST Controller, REST API, Spring Boot, JPA Repository, Postman, JUnit

# Lessons Learned
This project definitely gave me a familiarity and apprecitation of JPA Repository technology and how it allows us as programmers to query the database through Java methods. I also found particular utility in choosing to, at times, return an Optional<> when attempting to find an entity by ID in order to null check and prevent issues when performing read operations. Postman was a new and welcome change to test CRUD operations, the format of writing in urls to test emphasized for me the flow from url to controller to database. Once again JUnit test proved invaluable to ensure that my entities were mapped correctly and that entity relationships were being recognized. Personally I found the introduction of Services and Service Impls implace of DAOs and DAOImpls to be refreshing and a bit easier to understand code flow. And finally I think this project really helped understand Controllers more thouroughly as well as HttpServletResponse and HttpServletRequest to direct and secure information for/from the webpage.

| HTTP Verb | URI                  | Request Body | Response Body |
|-----------|----------------------|--------------|---------------|
| GET       | `/api/gyms`      	   |   			  | Collection of representations of all _tacostand_ resources |collection** endpoint |
| GET		| `/api/members`
| GET       | `/api/tacostands/17`   |              | Representation of _tacostand_ `17` |
| POST      | `/api/tacostands`      | Representation of a new _tacostand_ resource | Description of the result of the operation | **
| PUT       | `/api/tacostands/17`   | Representation of a new version of _tacostand_ `17` |
| DELETE    | `/api/tacostands/17`   |              | |