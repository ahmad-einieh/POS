# POS Backend

A Spring Boot REST backend experiment for products, orders, and sales, using Spring Data JPA and MySQL. This repository contains the backend, not a checkout frontend.

## Requirements

- Java 11.
- Maven or the included Maven wrapper.
- A local MySQL database. The project uses legacy Connector/J `5.1.22` and a MySQL 5 InnoDB dialect; compatibility with newer servers is not verified.

The project uses Spring Boot `2.6.2`, Lombok, and WAR packaging.

## Local setup

1. Create a disposable MySQL database named `ahmad_pos`.
2. Supply connection settings through environment variables or local configuration:

   ```bash
   export SPRING_DATASOURCE_URL='jdbc:mysql://localhost:3306/ahmad_pos'
   export SPRING_DATASOURCE_USERNAME='your_local_user'
   export SPRING_DATASOURCE_PASSWORD='your_local_password'
   ```

   Do not commit database credentials. The checked-in properties otherwise default to local `root` without a configured password.
3. For a new development database only, enable schema generation with `export SPRING_JPA_HIBERNATE_DDL_AUTO=update`, or provision tables matching the JPA entities yourself. The checked-in schema-generation property is commented out, and no SQL schema is included.
4. Start the backend:

   ```bash
   bash mvnw spring-boot:run
   ```

On Windows, use `mvnw.cmd spring-boot:run` and set environment variables using your shell's syntax. With default Spring Boot settings, the API listens on `http://localhost:8080`.

## API routes

| Method | Route | Input |
| --- | --- | --- |
| POST | `/products/addproduct` | Product JSON |
| POST | `/products/updateproduct` | Product JSON |
| GET | `/products/deleteproduct` | `productid` query parameter; **deletes data** |
| GET | `/products/getbyproductbarcode` | `barcode` query parameter |
| GET | `/products/getbyproductid` | `id` query parameter |
| GET | `/products/getallproducts` | None |
| POST | `/orders/saveorder` | Array of `{ "productid": 1, "productprice": 10.0 }` objects |
| GET | `/orders/getallorders` | None |
| GET | `/sales/getallsales` | None |
| GET | `/sales/getallsalesbyorderid` | `orderid` query parameter |

Product fields include `productid`, `productname`, `productprice`, and `barcode`. Create products before referencing their IDs in an order. Example read request:

```bash
curl http://localhost:8080/products/getallproducts
```

## Source and limitations

Controllers, DAO/service classes, JPA entities, and repositories live under [`src/main/java/com/example/storepos/`](src/main/java/com/example/storepos/). Connection defaults are in [`application.properties`](src/main/resources/application.properties).

This is a legacy learning backend without configured authentication. Product endpoints allow cross-origin access, deletion uses GET, prices come from request data, and order/sale persistence is not wrapped in a service-level transaction. Keep it local with dummy data; do not expose it as a production POS service. Build and live-database behavior have not been tested for this documentation refresh.
