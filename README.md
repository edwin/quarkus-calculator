# About this Repo

A front end app created with HTML, JQuery and Quarkus as Backend. It display a basic functionality for a simple calculator with database connectivity for history.

How To
------------

Run the app
 ```
 $ mvn quarkus:dev -s settings.xml
 ```

Build by using mvn
 ```
 $ mvn clean package -s settings.xml
 ```

Docker build
 ```
 $ docker build -t quarkus-calculator .
 ```

Docker run with specific environment (dev/prod)
 ```
 $ docker run  -p 8080:8080 quarkus-calculator
 ```

Database
-----------
```sql
create table t_calculator
(
	id int auto_increment,
	value1 bigint null,
	method varchar(20) null,
	value2 bigint null,
	total bigint null,
	constraint t_calculator_pk
		primary key (id)
);
```

Libraries
------------
- Java 11
- Quarkus 2.11.3.Final
- Bootstrap 4.6.1
- JQuery 3.6.0