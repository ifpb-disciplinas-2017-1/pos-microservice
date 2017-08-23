Este projeto consiste de uma implementação de um microserviço usando NodeJs, Mongo e distribuido com Docker.

# How to

### Clone o projeto:

```
  # git clone https://github.com/ifpb-disciplinas-2017-1/pos-microservice.git
```

### Build do projeto

```
  # cd app-autor/
  # docker-compose up -d 
```

### url

```
  http://localhost:8080
```

## Métodos

### Create - POST
```
 http://localhost:8080/autor {nome: String, email: String, abreviacao: String}
```

### Update - PUT
```
 http://localhost:8080/autor {_id: String, nome: String, email: String, abreviacao: String}
```

### READ - GET
```
 http://localhost:8080/autor 
 http://localhost:8080/autor/{nome: String}
```

### DELETE - DELETE
```
 http://localhost:8080/autor/{_id: String}
```
### Agradecimentos 

* https://github.com/brittneykernan/noderest-presentation
* https://github.com/msfidelis/POC-TCC-Docker-NodeJS
* http://bigspaceship.github.io/blog/2014/05/14/how-to-create-a-rest-api-with-node-dot-js/
