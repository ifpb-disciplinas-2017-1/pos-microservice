Este projeto consiste de uma implementação de um microserviço usando SpringBoot, PostgreSQL e distribuido com Docker.

# How to

### Clone o projeto:

```
  # git clone https://github.com/ifpb-disciplinas-2017-1/pos-microservice.git
```

### Build do projeto

```
  # cd app-livro/
  # docker-compose up -d 
```

### url (configurável no `docker-compose.yml`)

```
  http://localhost:8083
```

## Métodos

### Create - POST
```
 http://localhost:8083/livro {edicao: String, titulo: String, descricao: String}
```

### Update - PUT
```
 http://localhost:8083/livro {id: long, edicao: String, titulo: String, descricao: String}
```

### READ - GET
```
 http://localhost:8083/livro 
 http://localhost:8083/livro/{id: long}
 http://localhost:8083/livro/{id: long}/autores
```

### Adicionar um Autor - GET
```
 http://localhost:8083/livro/{id: long}/autores/{autor: long}
```

