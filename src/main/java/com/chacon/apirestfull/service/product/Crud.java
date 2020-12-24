package com.chacon.apirestfull.service.product;

import java.util.List;

import com.chacon.apirestfull.model.Product;
import com.chacon.apirestfull.repository.ProductRepository;
import com.chacon.apirestfull.service.auth.Authentication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Crud {
    
    @Autowired
    ProductRepository productRepository;
    Authentication authentication = new Authentication() ;

    //Listar os produtos do banco de dados
    public List<Product> listProduct(String token){

        if(authentication.status(token)){
            return productRepository.findAll();
        }
        else
        {
            return null;
        }
        
    }
    // //retornar o produto procurado
    public Product listProduct_id(long id,String token){

        if(authentication.status(token)){
            return productRepository.findById(id);
        }
        else
        {
            return null;
        }
        
    }
    // //Inserir um novo produto no banco de dados
    public Product salveProduct( Product product, String token )
    {
        if(authentication.status(token)){
            return productRepository.save(product);
        }
        else
        {
            return null;
        }
    }
     // //Alterar um produto especifico no banco de dados
    public Product attProduct( Product product, String token )
    {
        if(authentication.status(token)){
            return productRepository.save(product);
        }
        else
        {
            return null;
        }
    }
    // //Deletar um produto especifio no banco de dados
    public void delete( Product product, String token )
    {
        if(authentication.status(token)){
            productRepository.delete(product);
        }
    }
}
