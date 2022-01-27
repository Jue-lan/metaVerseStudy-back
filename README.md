# metaVerseStudy-back

## Project description

A to do list, study log, and information hub for all things related to the meta verse.

## ERD
![MetaVerseStudy ERD (2)](https://user-images.githubusercontent.com/72534273/151252285-f1439bc5-3395-44c4-8f9a-c94cf3aa36d4.png)

## EndPoints

Request Type	|Action	|URL	|Request Body	|Request Header	|Access
------------ |------------ | ------------- | ------------- | ------------- | -------------
|GET	|get single User	|/auth/user/	|None	|Authorization Bearer TOKEN	|PRIVATE
|POST	|create single User	|/api/register	|User Details	|None	|PUBLIC
|POST	|login User	|/api/login	|User login Info	|None	|PUBLIC
|PUT	|update User	|/auth/user/	|User Details	|Authorization Bearer TOKEN	|PRIVATE
|DELETE	|delete User	|/auth/user/	|None	|Authorization Bearer TOKEN	|PRIVATE
|GET	|gets all tasks	|/auth/user/{userId}/category/{catgoryid}/tasks	|None	|Authorization Bearer TOKEN	|PRIVATE
|GET	|get single task	|/auth/user/{userId}/category/{catgoryid}/tasks/(tasks1}	|None	|Authorization Bearer TOKEN	|PRIVATE
|POST	|create single task	|/auth/user/{userId}/category/{catgoryid}/tasks	|Task info	|Authorization Bearer TOKEN	|PRIVATE
|PUT	|update task	|/auth/user/{userId}/category/{catgoryid}/tasks/(tasks1}	|Task info	|Authorization Bearer TOKEN	|PRIVATE
|DELETE	|delete task	|/auth/user/{userId}/category/{catgoryid}/tasks/(tasks1}	|None	|Authorization Bearer TOKEN	|PRIVATE
|GET	|get all Categories	|/auth/user/{userId}/category	|None	|None	|PUBLIC
|GET	|get single Categories	|/auth/user/{userId}/category/{catgoryid}	|None	|None	|PUBLIC
|POST	|create single Categories	|/auth/user/{userId}/category	|Podcast info	|None	|ADMIN
|PUT	|update Categories	|/auth/user/{userId}/category/{catgoryid}	|Podcast info	|Authorization Bearer TOKEN	|ADMIN
|DELETE	|delete Categories	|/auth/user/{userId}/category/{catgoryid}	|None	|Authorization Bearer TOKEN	|ADMIN
|GET	|get all Resources	|/auth/user/{userId}/type/{typeid}/resources	|None	|None	|PUBLIC
|GET	|get single Resource	|/auth/user/{userId}/type/{typeid}/resources/{resourcesid}	|None	|None	|PUBLIC
|POST	|create  Resource	|/auth/user/{userId}/type/{typeid}/resources	|Resource info	|Authorization Bearer TOKEN	|ADMIN
|PUT	|update Resource	|/auth/user/{userId}/type/{typeid}/resources/{resourcesid}	|Resource info	|Authorization Bearer TOKEN	|ADMIN
|DELETE	|delete Resource	|/auth/user/{userId}/type/{typeid}/resources/{resourcesid}	|None	|Authorization Bearer TOKEN	|ADMIN
|GET	|get all Types	|/auth/user/{userId}/type	|None	|None	|PUBLIC
|GET	|get single Type	|/auth/user/{userId}/type/{typeid}	|None	|None	|PUBLIC
|POST	|create Type	|/auth/user/{userId}/type	|Type info	|Authorization Bearer TOKEN	|ADMIN
|PUT	|update Type	|/auth/user/{userId}/type/{typeid}	|Type info	|Authorization Bearer TOKEN	|ADMIN
|DELETE	|delete Type	|/auth/user/{userId}/type/{typeid}	|None	|Authorization Bearer TOKEN	|ADMIN
