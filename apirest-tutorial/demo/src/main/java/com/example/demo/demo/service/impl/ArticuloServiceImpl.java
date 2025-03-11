package com.example.demo.demo.service.impl;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.example.demo.demo.entity.Articulo;
import com.example.demo.demo.repository.ArticuloRepository;
import com.example.demo.demo.service.ArticuloService;
import com.example.demo.demo.validator.ArticuloValidator;

import org.springframework.transaction.annotation.Transactional;

import org.springframework.stereotype.Service;

import org.springframework.beans.factory.annotation.Autowired;

@Service
public class ArticuloServiceImpl implements ArticuloService{
    @Autowired //Para la inyeccion de dependencias, para agregar en un objeto la dependencia de ArticuloRepository (nuestro repositorio)
    private ArticuloRepository repository;

    @Override
    @Transactional(readOnly=true) //Para que se ejecute en una transaccion de lectura y una transaccion es un conjunto de operaciones que se ejecutan como una sola unidad logica de trabajo
    public List<Articulo> findAll(Pageable page) {
        try {
            //lista de todos los articulos y/o registros
            return repository.findAll(page).toList();
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    @Transactional(readOnly=true)
    public List<Articulo> findByNombre(String nombre, Pageable page) {
        try {
            //lista de todos los articulos y/o registros
            return repository.findByNombreContaining(nombre,page);
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    @Transactional(readOnly=true)
    public Articulo findById(int id) {
        try {
            Articulo registro = repository.findById(id).orElseThrow();
            return registro;
        } catch (Exception e) {
            return null;
        }
    }

    @Override
public Articulo save(Articulo articulo) {
   try {
        ArticuloValidator.save(articulo);
        
        // Asegurar que el artículo no tenga un ID inválido antes de guardar
        if (articulo.getId() != null && articulo.getId() == 0) {
            System.out.println("🚨 ERROR: Intentando guardar un Artículo con ID = 0.");
            return null;
        }

        articulo.setActivo(true);  // Asegurar que está activo antes de guardar
        Articulo registro = repository.save(articulo);

        if (registro == null) {
            System.out.println("🚨 ERROR: `repository.save()` devolvió NULL.");
        } else {
            System.out.println("✅ Artículo guardado con éxito: " + registro);
        }

        return registro;
   } catch (Exception e) {
       System.out.println("❌ ERROR en `save()`: " + e.getMessage());
       e.printStackTrace();
       return null;
   }
}

    @Override
    public Articulo update(Articulo articulo) {
       try {
            ArticuloValidator.save(articulo);
            Articulo registro = repository.findById(articulo.getId()).orElseThrow();
            registro.setNombre(articulo.getNombre());
            registro.setPrecio(articulo.getPrecio());
            repository.save(registro);
            return registro;
       }catch (Exception e) {
           return null;
       }
    }

    @Override
    public void delete(int id) {
        try{
            Articulo registro = repository.findById(id).orElseThrow();
            repository.delete(registro);
        } catch (Exception e) {
            
        } 
    }


}
