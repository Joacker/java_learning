package com.joaquin.springboot.di.app.springboot_di.repositories;
import java.util.Collections;
import java.util.List;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import com.joaquin.springboot.di.app.springboot_di.models.Product;

@Primary
@Repository
public class ProductRepositoryFoo implements ProductRepository{

    @Override
    public List<Product> findAll() {
        // TODO Auto-generated method stub
        return Collections.singletonList(new Product(1L, "Monitor Asus 27", 200L));
    }

    @Override
    public Product findById(long id) {
        // TODO Auto-generated method stub
        return new Product(id, "Monitor Asus 27", 200L);
    }

}
