package com.example.demo.demo.converter;

import org.springframework.stereotype.Component;

import com.example.demo.demo.dto.ArticuloDTO;
import com.example.demo.demo.entity.Articulo;

@Component
public class ArticuloConverter extends AbstractConverter<Articulo /* Entidad */, ArticuloDTO /* DTO */> {

    @Override
    public ArticuloDTO fromEntity(Articulo entity) { //convertir de una entidad a un DTO
        return ArticuloDTO.builder()
        .id(entity.getId())
        .nombre(entity.getNombre())
        .precio(entity.getPrecio())
        .build();
    }

    @Override
    public Articulo fromDTO(ArticuloDTO dto) { //convertir de un DTO a una entidad
        if(dto == null){
            return null;
        }
        return Articulo.builder()
        .id(dto.getId())
        .nombre(dto.getNombre())
        .precio(dto.getPrecio())
        .build();
    }

}
