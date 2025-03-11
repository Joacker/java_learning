package com.example.demo.demo.validator;

import com.example.demo.demo.entity.Articulo;
import com.example.demo.demo.exceptions.ValidateServiceException;

public class ArticuloValidator {
    public static void save(Articulo articulo){
        if (articulo.getNombre() == null || articulo.getNombre().isEmpty()) {
            // Arrojar una excepcion
            throw new ValidateServiceException("El nombre del articulo es requerido");
        }
        if(articulo.getNombre().length() > 100){
            // Arrojar una excepcion
            throw new ValidateServiceException("El nombre del articulo es muy largo");
        }
        if(articulo.getPrecio() == null){
            // Arrojar una excepcion
            throw new ValidateServiceException("El precio del articulo es requerido");
        }
        if (articulo.getPrecio() < 0){
            // Arrojar una excepcion
            throw new ValidateServiceException("El precio del articulo es incorrecto");
        }
    }

}
