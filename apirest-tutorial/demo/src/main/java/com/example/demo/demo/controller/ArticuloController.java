package com.example.demo.demo.controller;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.PageRequest;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.demo.service.ArticuloService;
import com.example.demo.demo.entity.Articulo;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import com.example.demo.demo.converter.ArticuloConverter;
import com.example.demo.demo.dto.ArticuloDTO;

@RestController
@RequestMapping("/v1/articulos")
public class ArticuloController {
    @Autowired
    private ArticuloService service;

    @Autowired
    private ArticuloConverter converter;

    @GetMapping()
    public ResponseEntity<List<ArticuloDTO>> findAll(
            @RequestParam(value = "nombre", required = false, defaultValue = "") String nombre,
            @RequestParam(value = "offset", required = false, defaultValue = "0") int pageNumber,
            @RequestParam(value = "limit", required = false, defaultValue = "5") int pageSize
            ) {
        Pageable page = PageRequest.of(pageNumber, pageSize);
        List<Articulo> articulos;
        if (nombre==null || nombre.isEmpty()) {
            articulos = service.findAll(page);
        } else {
            articulos = service.findByNombre(nombre, page);
        }

        if (articulos == null) {
            return ResponseEntity.notFound().build();
        }
        List<ArticuloDTO> articulosDTO = converter.fromEntity(articulos);
        return ResponseEntity.ok(articulosDTO);
    }

    @GetMapping(value="/{id}")
    public ResponseEntity<ArticuloDTO> findById(@PathVariable("id") int id) {
        Articulo articulo = service.findById(id);
        if (articulo == null) {
            return ResponseEntity.notFound().build();
        } 
        ArticuloDTO articuloDTO = converter.fromEntity(articulo);
        return ResponseEntity.ok(articuloDTO);
    }

    @PostMapping()
    public ResponseEntity<ArticuloDTO> create(@RequestBody ArticuloDTO articuloDTO) {
        Articulo registro = service.save(converter.fromDTO(articuloDTO));
        ArticuloDTO registroDTO = converter.fromEntity(registro);
        return ResponseEntity.status(HttpStatus.CREATED).body(registroDTO);
    }

    @PutMapping(value="/{id}")
    public ResponseEntity<ArticuloDTO> update(@PathVariable("id") int id, @RequestBody ArticuloDTO articuloDTO) {
        Articulo registro = service.update(converter.fromDTO(articuloDTO));
        if (registro == null) {
            return ResponseEntity.notFound().build();
        } else {
            ArticuloDTO registroDTO = converter.fromEntity(registro);
            return ResponseEntity.status(HttpStatus.CREATED).body(registroDTO);
        }
    }

    @DeleteMapping(value="/{id}")
    public ResponseEntity<ArticuloDTO> delete(@PathVariable("id") int id) {
        service.delete(id);
        return ResponseEntity.ok(null);
    }
}
