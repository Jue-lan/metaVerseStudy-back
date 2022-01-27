# metaVerseStudy-back

## Project description

A to do list, study log, and information hub for all things related to the meta verse.

## ERD
![MetaVerseStudy ERD (3)](https://user-images.githubusercontent.com/72534273/151443953-da3bca20-06ba-4fca-b1b7-344c52cf65d6.png)

## EndPoints

Request Type	|Action	|URL	|Request Body	|Request Header	|Access
------------ |------------ | ------------- | ------------- | ------------- | -------------
|GET	|get single User	|/auth/user/	|None	|Authorization Bearer TOKEN	|PRIVATE
|POST	|create single User	|/auth/user/register	|User Details	|None	|PUBLIC
|POST	|login User	|/auth/user/login	|User login Info	|None	|PUBLIC
|PUT	|update User	|/auth/user/	|User Details	|Authorization Bearer TOKEN	|PRIVATE
|DELETE	|delete User	|/auth/user/	|None	|Authorization Bearer TOKEN	|PRIVATE
|GET	|gets all tasks	|/api/user/{userId}/category/{catgoryid}/tasks	|None	|Authorization Bearer TOKEN	|PRIVATE
|GET	|get single task	|/api/user/{userId}/category/{catgoryid}/tasks/(tasks1}	|None	|Authorization Bearer TOKEN	|PRIVATE
|POST	|create single task	|/api/user/{userId}/category/{catgoryid}/tasks	|Task info	|Authorization Bearer TOKEN	|PRIVATE
|PUT	|update task	|/api/user/{userId}/category/{catgoryid}/tasks/(tasks1}	|Task info	|Authorization Bearer TOKEN	|PRIVATE
|DELETE	|delete task	|/api/user/{userId}/category/{catgoryid}/tasks/(tasks1}	|None	|Authorization Bearer TOKEN	|PRIVATE
|GET	|get all Categories	|/api/user/{userId}/category	|None	|None	|PUBLIC
|GET	|get single Categories	|/api/user/{userId}/category/{catgoryid}	|None	|None	|PUBLIC
|POST	|create single Categories	|/api/user/{userId}/category	|Podcast info	|None	|ADMIN
|PUT	|update Categories	|/api/user/{userId}/category/{catgoryid}	|Podcast info	|Authorization Bearer TOKEN	|ADMIN
|DELETE	|delete Categories	|/api/user/{userId}/category/{catgoryid}	|None	|Authorization Bearer TOKEN	|ADMIN
|GET	|get all Resources	|/api/user/{userId}/type/{typeid}/resources	|None	|None	|PUBLIC
|GET	|get single Resource	|/api/user/{userId}/type/{typeid}/resources/{resourcesid}	|None	|None	|PUBLIC
|POST	|create  Resource	|/api/user/{userId}/type/{typeid}/resources	|Resource info	|Authorization Bearer TOKEN	|ADMIN
|PUT	|update Resource	|/api/user/{userId}/type/{typeid}/resources/{resourcesid}	|Resource info	|Authorization Bearer TOKEN	|ADMIN
|DELETE	|delete Resource	|/api/user/{userId}/type/{typeid}/resources/{resourcesid}	|None	|Authorization Bearer TOKEN	|ADMIN
|GET	|get all Types	|/api/user/{userId}/type	|None	|None	|PUBLIC
|GET	|get single Type	|/api/user/{userId}/type/{typeid}	|None	|None	|PUBLIC
|POST	|create Type	|/api/user/{userId}/type	|Type info	|Authorization Bearer TOKEN	|ADMIN
|PUT	|update Type	|/api/user/{userId}/type/{typeid}	|Type info	|Authorization Bearer TOKEN	|ADMIN
|DELETE	|delete Type	|/api/user/{userId}/type/{typeid}	|None	|Authorization Bearer TOKEN	|ADMIN
