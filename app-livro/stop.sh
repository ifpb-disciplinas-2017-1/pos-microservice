docker-compose down
docker rmi -f ricardojob/db-livro
docker rmi -f ricardojob/livro
docker volume remove produto_postgres-volume-db
