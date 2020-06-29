# kamlaxapi

# Kamlax API
Introduction: Kamlax API is a Spring based RESTFul Web Service deployed on Linode having CRUD operations of a Student module. For the CRUD operation in-process database Hyper SQL has been used. Spring Security has been used for Authentication/Authorization. Request and Response are in JSON format.

API Endpoints: There are 4 API endpoints for performing basic CRUD operations, they are as follows:

1.	http://172.105.122.109:8080/kamlaxapi/student/save - this is a POST request for adding a new student, it requires name, address and age values to be passed as a JSON object. The JSON object looks like below:
   {
  	"name": "John Doe",
       "address": "Malim Jaya",
       "age": 36        
          }
      Success: On success it returns “SUCCESS: Successfully saved Student”
      Failure: On failure it returns “ERROR: Error while saving Student”

2.	http://172.105.122.109:8080/kamlaxapi/student/list - this is a GET request to get the list of students. It returns a JSON object list, following is a sample student list:

 [
    {
        "address": "Merdeka",
        "age": 35,
        "id": "16f6b79e-ce65-4257-83ca-e7c11c9a6dee",
        "name": "Smith"
    },
    {
        "address": "Addd",
        "age": 36,
        "id": "9c25a24c-9be2-4b20-9676-f6cbf5aa189b",
        "name": "Sin"
    },
    {
        "address": "KG 88",
        "age": 36,
        "id": "b41c4bcf-5d0c-46b0-902d-726ea1cfd507",
        "name": "Asdfg"
    },
    {
        "address": "Malim Jaya",
        "age": 36,
        "id": "a8ee8244-1946-4367-89e9-6d72f10f1e43",
        "name": "John Doe"
    }
]

3.	http://172.105.122.109:8080/kamlaxapi/student/update - this is a POST request for adding a new student, it requires id, name, address and age values to be passed as a JSON object. The JSON object looks like below:
                     {
             "address": " Malim Jaya",
             "age": 36,
             "id": "9c25a24c-9be2-4b20-9676-f6cbf5aa189b",
             "name": " John Doe"
          }
                  Get a JSON object returned from list operation for updating so the id will be correct for updating.

	    Success: On success it returns “SUCCESS: Successfully updated Student”
      	  Failure: On failure it returns “ERROR: Error while saving Student”


4.	http://172.105.122.109:8080/kamlaxapi/student/delete?id=<encryptedId> - this is a DELETE request to delete student by id. The id has to be AES-256 encrypted and of course encoded to be passed on URL. The value will be decrypted and used for deleting student. At the end it will return the message as AES-256 encrypted value. AES encryption secret key and salt are as follows: 
secretKey = "kamlax_secret"
      salt = "kamlax_salt"

    
Success: On success it returns “SUCCESS: Successfully deleted Student” as  AES-256 encrypted value.
Failure: On failure it returns “ERROR: Error occured while deleting Student” or “ERROR: No id found” both as AES-256 encrypted value.

Authentication/Authorization: Basic Authentication and Authorization have been implemented. A user may be a valid user and authenticated but not able to perform any operation for not having authorization to perform an operation. On the other hand, a user may be a valid user as well as an authorised user to perform operation. 

There are 3 users namely admin, rest and user. Both admin and rest users have authorization to perform operations whereas user doesn’t have authorization to perform any operation but can be authenticated. All 3 users’ username and password are same.

Authentication and Authorization scenarios: Postman has been used for performing all REST operations. Following are the scenarios for authentication and authorization:

1.	On Postman in Authorization tab select No Auth from Type dropdown and try to perform an operation, it will return unauthorized:
 

2.	On Postman in Authorization tab select Basic Auth from Type dropdown and key in “user” for both username and password and then try to perform an operation, it will return forbidden:
 

Means the user is authenticated but not authorized to perform any operation.


3.	On Postman in Authorization tab select Basic Auth from Type dropdown and key in “admin” or “rest” for both username and password and then try to perform an operation, it will return correct output as both are authorized to perform operations.


Technologies Used: Following are the technologies used for developing the REST API:

Language: Java
Framework: Spring, Spring Web MVC
Security: Spring Security
ORM: MyBatis
Database: Hyper SQL 
Build Tool: Maven
Application Server: Tomcat
Cloud: Linode
Unit Test: Mockito, JUnit


