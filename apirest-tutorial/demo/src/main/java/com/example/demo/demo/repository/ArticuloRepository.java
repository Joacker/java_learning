package com.example.demo.demo.repository;
import com.example.demo.demo.entity.Articulo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticuloRepository extends  JpaRepository<Articulo, Integer> {
    
}
