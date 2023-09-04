#to build the container
#must be lower cas
docker build -t produkt-db .

#to run the container
docker run --name my-mongo-instance -d -p 30001:27017 produkt-db