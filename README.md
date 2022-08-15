# Employees Management System 

This is a simple employee management application manifesting CRUD functionalities made using SpringBoot(Backend) and Thymeleaf.
The application uses PostgresSQL as a database which runs on top of a docker container

`Please note that you don't have PostgreSQL already installed locally on your machine`

Spinning a Postgres SQL container on Docker

1. Pull the docker image

```bash
docker pull postgres:alpine
```


2. Spin a container with the following attributes

- container name : postgres_container
- database name : ems_db
- super username : ems_user
- password : ems_pass

```bash
docker run -d --name postgres_container -e POSTGRES_DB=ems_db -e POSTGRES_USER=ems_user -e POSTGRES_PASSWORD=ems_pass -p 5432:5432 postgres:alpine
```

3. Log into the container
```bash
docker exec -it postgres_container bash
```

4. Log into as ems_user with ems_db as database
```bash
psql -U ems_user -d ems_db
```

If login with \l you would see ems_user as the main user and even we have a database with the name : ems_user
