# CRUD-TomCatApplicationserver

a Rest web service that implemented by tomcat applicationserver and connects to the oracle database by JDBC and writes in ,updates,deletes and shows information of user

for use of this webservice you should have tomcat Applicatios server and Oracle dataBase in your computer

COMMANDS:

1)for insert: http://localhost:8081/rest/person/save?name= write a name 


2)for delete: http://localhost:8081/rest/person/delete?id= write a number 


3)for update: http://localhost:8081/rest/person/update?name= write a name&id=write a number


4)for read a row: http://localhost:8081/rest/person/findOne?id= write a number


5)for read all : http://localhost:8081/rest/person/findAll


TIPS:

1)has been tried written clean code


2)the portNumber of URl set to 8081 because the 8080 portNumber Occupied by Oracle database
