package com.joaquin.springboot.di.app.springboot_di.repositories;
import java.util.Arrays;
import java.util.List;
import com.joaquin.springboot.di.app.springboot_di.models.Product;

//import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.context.annotation.Primary;
//@Primary
@Repository
public class ProductRepositoryImpl implements ProductRepository {

    private List<Product> data;

    //Crear constructor
    public ProductRepositoryImpl() {
        this.data = Arrays.asList(
            new Product(1, "Laptop",  700),
            new Product(2, "Mouse",  20),
            new Product(3, "Keyboard", 50),
            new Product(4, "Monitor",  150)
        );
    }

    @Override
    public List<Product> findAll() {
        return data;
    }
    
    @Override
    public Product findById(long id){
        return data.stream().filter(p -> p.getId() == id).findFirst().orElse(null);
    }
}