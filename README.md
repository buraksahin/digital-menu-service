
# eMenu [Restaurant Digital Menu]
### eMenu

eMenu provides digital ordering system for restaurants.
Customers can order meals via eMenu system.

Api Gateway
---
#### Bill:
- **Get Bill**
    - GET <http://localhost:9090/bill/get-by-restaurant-id/{restaurant-id}>
    - GET <http://localhost:9090/bill/get-by-restaurant-id-and-table-id/{restaurant-id}/{table-id}>
---
#### Order:
- **Create Order**
  - POST <http://localhost:9090/order/create>
- **Get All Orders**
    - GET <http://localhost:9090/order/all>
- **Get All Order By Order Id**
  - GET <http://localhost:9090/order/get-by-order-id/{order-id}>
- **Get Order By Table Id**
    - GET <http://localhost:9090/order/get-by-table-id/{table-id}>
- **Get Order By Restaurant Id**
    - GET <http://localhost:9090/order/get-by-restaurant-id/{restaurant-id}>
- **Get Orders By Table Id and Customer Name**
    - GET <http://localhost:9090/order/get-by-table-id-and-customer-name/{table-id}/{customer-name}>
- **Get Orders By Table Id and Customer Name and Restaurant Id**
  - GET <http://localhost:9090/order/get-by-table-id-and-customer-name-and-restaurant-id/{table-id}/{customer-name}/{restaurant-id}>
- **Get Orders By Table Id and Restaurant Name**
    - GET <http://localhost:9090/order/get-by-table-id-and-restaurant-id/{table-id}/{restaurant-id}>
- **Delete Order**
    - DELETE <http://localhost:9090/order/delete/{order-id}>
---
#### Product:
- **Create Product**
    - POST <http://localhost:9090/product/create>
- **Get All Products**
    - GET <http://localhost:9090/product/all>
- **Get Product By Product Id**
    - GET <http://localhost:9090/product/get-by-product-id/{product-id}>
- **Get Product By Restaurant Id**
    - GET <http://localhost:9090/product/get-by-restaurant-id/{restaurant-id}>
- **Get Products By Restaurant Id and Category Id**
    - GET <http://localhost:9090/product/get-by-restaurant-id-and-category-id/{restaurant-id}/{category-id}>
- **Delete Product**
    - DELETE <http://localhost:9090/product/{product-id}>
---
#### Restaurant:
- **Create Restaurant**
    - POST <http://localhost:9090/restaurant/create>
- **Get All Restaurant**
    - GET <http://localhost:9090/restaurant/all>
- **Get Restaurant By Restaurant Id**
    - GET <http://localhost:9090/restaurant/get-by-restaurant-id/{restaurant-id}>
- **Update Restaurant**
   - PATCH <http://localhost:9090/restaurant/update/{restaurant-id}>
- **Delete Restaurant**
    - DELETE <http://localhost:9090/restaurant/delete/{restaurant-id}>
---
#### Table:
- **Create Table**
  - POST <http://localhost:9090/table/create>
- **Get All Tables**
  - GET <http://localhost:9090/table/all>
- **Get Table By Table Id**
  - GET <http://localhost:9090/table/get-by-user-id/{table-id}>
- **Get Table By Restaurant Id**
  - GET <http://localhost:9090/restaurant/get-by-restaurant-id/{restaurant-id}>
- **Update Table**
  - PATCH <http://localhost:9090/table/update/{table-id}>
- **Delete Table**
  - DELETE <http://localhost:9090/table/delete/{table-id}>
- **Open Table**
  - PATCH <http://localhost:9090/table/open/{table-id}>
- **Close Table**
  - PATCH <http://localhost:9090/table/close/{table-id}>
- **Get Session Code**
  - PATCH <http://localhost:9090/table/get-session-code/{table-id}/{restaurant-id}/{table-code}>
---
#### User:
- **Create User**
    - POST <http://localhost:9090/user/create>
- **Get All Users**
    - GET <http://localhost:9090/users/all>
- **Get User By User Id**
    - GET <http://localhost:9090/user/get-by-user-id/{user-id}>
- **Update User**
   - PATCH <http://localhost:9090/user/update/{user-id}>
- **Delete User**
   - DELETE <http://localhost:9090/user/delete/{user-id}>