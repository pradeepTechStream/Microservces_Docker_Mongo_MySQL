# Microservces_Docker_Mongo_MySQL
This is Microservice project
1) API Gateway [9000]
2) Product Service [8080]
3) Order Service [8081]
4) Inventory Service [8082]

Order service have internal call to Inventory service using open FeignClient.
CircuitBreaker also used.
