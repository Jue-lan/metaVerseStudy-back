# metaVerseStudy-back

## Project description

A to do list, study log, and information hub for all things related to the meta verse.

## ERD

![MetaVerseStudy ERD (3)](https://user-images.githubusercontent.com/72534273/151443953-da3bca20-06ba-4fca-b1b7-344c52cf65d6.png)

## EndPoints

Request Type    |Action    |URL    |Request Body    |Request Header    |Access
------------ |------------ | ------------- | ------------- | ------------- | -------------
|GET	|get single User	|/auth/user/	|None	|Authorization Bearer TOKEN	|PRIVATE
|POST	|create single User	|/auth/user/register	|User Details	|None	|PUBLIC
|POST	|login User	|/auth/user/login	|User login Info	|None	|PUBLIC
|PUT	|update User	|/auth/user/	|User Details	|Authorization Bearer TOKEN	|PRIVATE
|DELETE	|delete User	|/auth/user/	|None	|Authorization Bearer TOKEN	|PRIVATE
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

