# SpringBootCRUDMySQL
build CRUD springboot with JPA Mysql

### run project
```
$ mvn spring-boot:run
```

### clean | Install dependencies pom.ml
```bash 
$ mvn clean install
```

### build .jar file
```bash 
$ mvn clean package
```

### serve docker and with logs
```bash
$ docker-compose up --build
```

### serve docker without logs
```bash
$ docker-compose up --build -d
```
### serve spring-boot project
```bash 
# springboot project
http://localhost:8888 

# serve phpmyadmin
http://localhost:8000

```