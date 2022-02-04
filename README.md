# metaVerseStudy-back

## Project description

In this capstone project, I sought to leverage my new learnings of Java, CRUD applications,and REST APIs to build a study helper for my interests in the MetaVerse. Through this backend production, this app serves as a to do tracker, resource log, and meta news hub for all things related to the meta verse.

Live Link: https://jue-lan.github.io/metaVerseStudy-back/

## User Stories
- User can add items to their study to do list and check them off as completed.
- User can view all tasks or sort tasks by category
- User can edit and view a progress log on a task
- User can see a feed of current news related to things meta verse (external API)
- User can create and manipulate a resource folder that can be organized by topic, and files versus links

### System Tools
- Intelligi
- Spring Boot
- Maven
- Postman
- PG Admin
- LucidCharts

## ERD

#### OLD Mapping
![MetaVerseStudy ERD (3)](https://user-images.githubusercontent.com/72534273/151443953-da3bca20-06ba-4fca-b1b7-344c52cf65d6.png)

#### Current Mapping
![MetaVerseStudy ERD (4)](https://user-images.githubusercontent.com/72534273/152343122-89ba0935-434f-4ef6-a248-80b443f2df09.png)


## EndPoints

Request Type    |Action    |URL    |Request Body    |Request Header    |Access
------------ |------------ | ------------- | ------------- | ------------- | -------------
|GET	|gets all tasks	|/api/categories/{catgoryid}/tasks	|None	|Authorization Bearer TOKEN	|PRIVATE
|GET	|get single task	|/api/categories/{catgoryid}/tasks/(tasks1}	|None	|Authorization Bearer TOKEN	|PRIVATE
|POST	|create single task	|/api/categories/{catgoryid}/tasks	|Task info	|Authorization Bearer TOKEN	|PRIVATE
|PUT	|update task	|/api/categories/{catgoryid}/tasks/(tasks1}	|Task info	|Authorization Bearer TOKEN	|PRIVATE
|DELETE	|delete task	|/api/categories/{catgoryid}/tasks/(tasks1}	|None	|Authorization Bearer TOKEN	|PRIVATE
|GET	|get all Categories	|/api/categories	|None	|None	|PUBLIC
|GET	|get single Categories	|/api/categories/{catgoryid}	|None	|None	|PUBLIC
|POST	|create single Categories	|/api/categories	|Podcast info	|None	|ADMIN
|PUT	|update Categories	|/api/categories/{catgoryid}	|Podcast info	|Authorization Bearer TOKEN	|ADMIN
|DELETE	|delete Categories	|/api/categories/{catgoryid}	|None	|Authorization Bearer TOKEN	|ADMIN
|GET	|get all Resources	|/api/types/{typeid}/resources	|None	|None	|PUBLIC
|GET	|get single Resource	|/api/types/{typeid}/resources/{resourcesid}	|None	|None	|PUBLIC
|POST	|create  Resource	|/api/types/{typeid}/resources	|Resource info	|Authorization Bearer TOKEN	|ADMIN
|PUT	|update Resource	|/api/types/{typeid}/resources/{resourcesid}	|Resource info	|Authorization Bearer TOKEN	|ADMIN
|DELETE	|delete Resource	|/api/types/{typeid}/resources/{resourcesid}	|None	|Authorization Bearer TOKEN	|ADMIN
|GET	|get all Types	|/api/types	|None	|None	|PUBLIC
|GET	|get single Type	|/api/types/{typeid}	|None	|None	|PUBLIC
|POST	|create Type	|/api/types	|Type info	|Authorization Bearer TOKEN	|ADMIN
|PUT	|update Type	|/api/types/{typeid}	|Type info	|Authorization Bearer TOKEN	|ADMIN
|DELETE	|delete Type	|/api/types/{typeid}	|None	|Authorization Bearer TOKEN	|ADMIN

## POM Dependencies

```
        <!-- https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-starter-data-rest -->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-data-rest</artifactId>
            <version>2.6.1</version>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter</artifactId>
        </dependency>

        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-devtools</artifactId>
            <scope>runtime</scope>
            <optional>true</optional>
        </dependency>
        <dependency>
            <groupId>org.postgresql</groupId>
            <artifactId>postgresql</artifactId>
            <scope>runtime</scope>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-data-jpa</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-test</artifactId>
            <scope>test</scope>
        </dependency>
```
## Project Progression
Day 1    |Day 2    |Day 3   |Day 4    |Day 5    |Day 6    |Day 7    |Day 8
------------ |------------ | ------------- | ------------- | ------------- | -------------| ------------- | -------------
|Mapped org. ERD, started wireframe, mapped org. project timeline, created database | Mapped endpoints, modified ERD, started on controller and models.| Built out repositories and service. | Completed all files and started testing. Ran into run error.  | Corrected run error. Ran into Auth issues. Started building out front end components.| Solved backend Auth issues. Backend completed. Started to connect the front and back end with login form. | Unsuccessful connection. Started to refactor backend to remove users and authorization dependencies |Successfully refactored. Second try at connecting backend to front.

## Hurdles
#### Problem 1
Run error that took me almost 24 hrs to debug. 
-Solution: I did not capitalize my B for Bearer token.
#### Problem 2
Refactoring my backend to get rid of the JWT and Authentication. I had a tragic time communicating from my backend to my front end and the added layer burned a lot of time I could have spent elsewhere. So I decided to refactor and scrap the idea. However, refactoring a big problem, because although I corrected my methods and even deleted all my security and user files, I was still being prompted to login for the web application.
-Solution:There was an extra pop dependency that I needed to also remove.


```
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-security</artifactId>
        </dependency>
        <dependency>
            <groupId>io.jsonwebtoken</groupId>
            <artifactId>jjwt</artifactId>
            <version>0.9.1</version>
        </dependency>
```

##### Frontend Link
https://github.com/Jue-lan/metaVerseStudy-front


