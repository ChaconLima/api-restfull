package com.chacon.apirestfull.controller;

import com.chacon.apirestfull.repository.ProductRepository;
import com.chacon.apirestfull.model.Product;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping(value="/api")
public class ProductController {
    @Autowired
    ProductRepository productRepository;

    //Listar os produtos do banco de dados
    @GetMapping(value="products")
    public List<Product> listProduct(){
        return productRepository.findAll();
    }
    //retornar o produto procurado
    @GetMapping(value="product/{id}")
    public Product listProduct_id(@PathVariable(value="id") long id){
        return productRepository.findById(id);
    }
    //Inserir um novo produto no banco de dados
    @PostMapping(value="add-new-product")
    public Product salveProduct(@RequestBody Product product){
        return productRepository.save(product);
    }
    //Alterar um produto especifico no banco de dados
    @PutMapping(value="att-product")
    public Product putProduct(@RequestBody Product product){
        return productRepository.save(product);
    }
    //Deletar um produto especifio no banco de dados
    @DeleteMapping(value = "delet-product")
    public Product deletProduct(@RequestBody Product product){
        productRepository.delete(product);
        return product;
    }
}
