# Employees Management System 

Employees Management System

Resources
Website : <https://www.javaguides.net/2018/10/free-open-source-projects-using-spring-boot.html>

'Please note that you don't have PostgreSQL already installed locally on your machine'

Spinning a Postgres SQL container on Docker

1. Pull the docker image
`docker pull postgres:alpine`

2. Spin a container with the following attributes

- container name : postgres_container
- database name : ems_db
- super username : ems_user
- password : ems_pass

`docker run -d --name postgres_container -e POSTGRES_DB=ems_db -e POSTGRES_USER=ems_user -e POSTGRES_PASSWORD=ems_pass -p 5432:5432 postgres:alpine`

3. Log into the container
`docker exec -it postgres_container bash`
4. Log into as ems_user with ems_db as database
`psql -U ems_user -d ems_db`

If login with \l you would see ems_user as the main user and even we have a database with the name : ems_user
