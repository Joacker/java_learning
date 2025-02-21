package com.joaquin.springboot.di.app.springboot_di.services;

import java.util.List;
import java.util.stream.Collectors;

import com.joaquin.springboot.di.app.springboot_di.models.Product;
import com.joaquin.springboot.di.app.springboot_di.repositories.ProductRepository;

public class ProductService {

    // Repositry es la capa de acceso a datos
    private ProductRepository repository = new ProductRepository();
    public List<Product> findAll() {
        return repository.getProducts().stream().map(p -> {
            Double price = p.getPrice() * 1.25d;
            p.setPrice(price.longValue());
            return p;
        }).collect(Collectors.toList());
    }

    public Product findById(long id){
        return repository.findById(id);
    }
}
