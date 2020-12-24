package com.chacon.apirestfull.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.chacon.apirestfull.model.Product;
import com.chacon.apirestfull.service.product.Crud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping(value="/api")
public class ProductController {
    @Autowired
    Crud crud;
    

    //Listar os produtos do banco de dados
    @GetMapping(value="products")
    public List<Product> listProduct(@RequestHeader(value="Authorization") String authToken, HttpServletRequest request){
        return crud.listProduct(authToken);
    }
    // //retornar o produto procurado
    @GetMapping(value="product/{id}")
    public Product listProduct_id(@PathVariable(value="id") long id , @RequestHeader(value="Authorization") String authToken, HttpServletRequest request){
        return crud.listProduct_id(id,authToken);
    }
    // //Inserir um novo produto no banco de dados
    @PostMapping(value="add-new-product")
    public Product salveProduct(@RequestBody Product product, @RequestHeader(value="Authorization") String authToken, HttpServletRequest request){
        return crud.salveProduct(product,authToken);
    }
    // //Alterar um produto especifico no banco de dados
    @PutMapping(value="att-product")
    public Product putProduct(@RequestBody Product product,@RequestHeader(value="Authorization") String authToken, HttpServletRequest request){
        return crud.attProduct(product, authToken);
    }
    // //Deletar um produto especifio no banco de dados
    @DeleteMapping(value = "delet-product")
    public Product deletProduct(@RequestBody Product product,@RequestHeader(value="Authorization") String authToken, HttpServletRequest request){
        crud.delete(product, authToken );
        return product;
    }
}
