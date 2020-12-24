# API REST FULL

Implementation of the CRUD method with jwt authentication.

CRUD (English acronym Create, Read, Update and Delete) are the four basic operations (creation, query, update and destruction of data) used in relational databases (RDBMS) provided to users of the system.

The idea of ​​this project is to register a product in the database, with name, quantity and value. All access to CRUD routes, the user must be authenticated.

## Objetivos de implementação:

- [x] CRUD 
- [x] User authentication
- [ ] User authorization

## End Points for User:

- ### User Register:

    -   End Point :

            "POST"=>"http://localhost/api/user/register"

            Content-Type:
                application/json
    - Json Examplo:  

            {
                "name":"User",
                "email":"user@email.com",
                "password":"password" 
            }
    - Return of Registered User

            {
                "name":"User",
                "email":"user@email.com",
                "password":"5f4dcc3b5aa765d61d8327deb882cf99" 
            }

- ### User Login:
        
    -   End Point :

            "POST"=>"http://localhost:8080/api/user/login"

            Content-Type:
                application/json

    - Json Examplo:  

            {
                "email":"user@email.com",
                "password":"password" 
            }
    - Return User

            {
                "email": "user@email.com",
                "password": "a1ac5e2bdf01f908bdad1690d067d278",
                "token": "token-Bearer"
            }    
          
## End Points for CRUD
- ### List Product:
        
    -   End Point :

            "GET"=>"http://localhost:8080/api/products"

            Headers:
                Bearer: token

    - Return of Object List

            [
                {
                    "id": id,
                    "name": "name_product",
                    "quantity": quantity_product ,
                    "value": value_product
                },
            ]

- ### Find Product by Id:
        
    -   End Point :

            "GET"=>"http://localhost:8080/api/product/{id}"

            Headers:
                Bearer: token

    - Return of the Wanted Object

            
            {
                "id": id,
                "name": "name_product",
                "quantity": quantity_product ,
                "value": value_product
            },

- ### Salve New Product:
        
    -   End Point :

            "POST"=>"http://localhost:8080/api/add-new-product"

            Headers:
                Bearer: token

            Content-Type:
                application/json   

    - Json Example 

            {
                "name": "name_product",
                "quantity": quantity_product ,
                "value": value_product
            }

    - Return  of Saved Object 

            
            {
                "id": id,
                "name": "name_product",
                "quantity": quantity_product ,
                "value": value_product
            }
            
- ### Delete Product:
        
    -   End Point :

            "DELETE"=>"http://localhost:8080/api/delet-product"

            Headers:
                Bearer: token

            Content-Type:
                application/json   

    - Json Example 

             {
                "id": id,
                "name": "name_product",
                "quantity": quantity_product ,
                "value": value_product
            }

    - Return of the Deleted Object 

            
            {
                "id": id,
                "name": "name_product",
                "quantity": quantity_product ,
                "value": value_product
            },

- ### Update Product:
        
    -   End Point :

            "PUT"=>"http://localhost:8080/api/att-product"

            Headers:
                Bearer: token

            Content-Type:
                application/json   

    - Json Example 

             {
                "id": id,
                "name": "name_product",
                "quantity": quantity_product ,
                "value": value_product
            }

    - Return Updated Object 
            
            {
                "id": id,
                "name": "name_product",
                "quantity": quantity_product ,
                "value": value_product
            },
            

