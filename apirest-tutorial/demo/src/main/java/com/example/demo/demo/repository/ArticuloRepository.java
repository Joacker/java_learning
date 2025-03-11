package com.example.demo.demo.repository;
import com.example.demo.demo.entity.Articulo;

import java.util.List;

import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArticuloRepository extends  JpaRepository<Articulo, Integer> {
    List<Articulo> findByNombreContaining(String nombre, Pageable page);
}
