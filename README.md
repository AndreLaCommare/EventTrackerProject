# EventTrackerProject

# Description
Event Tracker as of now is a project that implements some new technologies like REST Controllers and APIs. The goal was to create a database consisting of one or more tables, use a JPA to map said 
table(s) to a Java POJO, and finally utilize a Spring Boot application in order to implement API and and query the database. This project also allwoed us to use APi for the creation of CRUD operations within the app. My particular Event Tracker is a Gym Tracker, as of now the database consists of two tables (Gym and Member), and allows CRUD operations through API for both entities. All CRUD operations were tested through Postman while Entity mappings were tested through JUnit.

This project has been updated this week o=for two primary purposes. One, to build a front end with the use of HTML and JavaScript so that the user may access the Database and perform CRUD operations. And two, implememtn said CRUD operations through the use of XML Http Request on our JavaScript throught the use of EventListeners that track certain user interactions with the web page. 


# Technologies Used
Java, Spring Data JPA, REST Controller, XML Http Request, AJAX, REST API, Spring Boot, JPA Repository, Postman, JUnit, BOootstrap, HTML

# Lessons Learned
This project definitely gave me a familiarity and apprecitation of JPA Repository technology and how it allows us as programmers to query the database through Java methods. I also found particular utility in choosing to, at times, return an Optional<> when attempting to find an entity by ID in order to null check and prevent issues when performing read operations. Postman was a new and welcome change to test CRUD operations, the format of writing in urls to test emphasized for me the flow from url to controller to database. Once again JUnit test proved invaluable to ensure that my entities were mapped correctly and that entity relationships were being recognized. Personally I found the introduction of Services and Service Impls implace of DAOs and DAOImpls to be refreshing and a bit easier to understand code flow. And finally I think this project really helped understand Controllers more thouroughly as well as HttpServletResponse and HttpServletRequest to direct and secure information for/from the webpage.

This week's update to Event Tracker taught me quite a few things. One of the coolest being the ability to construct HTML elements like tables and lists throught the use of document.createElement(); and immediately append data to those elements. Another useful lesson is building the habit of calling an event's prevent default method when submitting forms in order to prevent severe issues with when loading a page. XHR format was new and challenging but its utility is undeniable and interesting to work with. Finally I found the window.location.reload(); to be a pivotal function in redirecting and reloadinf a page properly while tryign to implement CRUD operations.

| HTTP Verb | URI                  | Request Body | Response Body |
|-----------|----------------------|--------------|---------------|
| GET       | `/api/gyms`      	   |   			  | Collection of representations of all _gym_ resources    |collection** endpoint |
| GET		| `/api/members`	   |			  | Collection of representations of all _member_ resources |collection** endpoint |
| GET       | `/api/gyms/17`   	   |              | Representation of _gym_ `17` 							|
| GET       | `/api/members/17`    |              | Representation of _member_ `17` 						|
| POST      | `/api/gyms`      	   | Representation of a new _gym_ resource 		   | Description of the result of the operation | **
| POST      | `/api/members`       | Representation of a new _member_ resource 		   | Description of the result of the operation | **
| PUT       | `/api/gyms/17`   	   | Representation of a new version of _gym_ `17` 	   |
| PUT       | `/api/members/17`    | Representation of a new version of _member_ `17`  |
| DELETE    | `/api/gyms/17`   	   |             | |
| DELETE    | `/api/members/17`    |             | |