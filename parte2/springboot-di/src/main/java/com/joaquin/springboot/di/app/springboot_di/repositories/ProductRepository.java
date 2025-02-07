package com.joaquin.springboot.di.app.springboot_di.repositories;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import com.joaquin.springboot.di.app.springboot_di.models.Product;

public class ProductRepository {

    private List<Product> data;

    //Crear constructor
    public ProductRepository() {
        this.data = Arrays.asList(
            new Product(1, "Laptop",  700),
            new Product(2, "Mouse",  20),
            new Product(3, "Keyboard", 50),
            new Product(4, "Monitor",  150)
        );
    }

    public List<Product> getProducts() {
        return data;
    }

    public Product findById(long id){
        return data.stream().filter(p -> p.getId() == id).findFirst().orElse(null);
    }
}
