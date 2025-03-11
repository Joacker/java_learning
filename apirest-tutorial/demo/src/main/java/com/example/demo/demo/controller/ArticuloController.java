package com.example.demo.demo.controller;

import org.springframework.data.domain.Pageable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.demo.service.ArticuloService;
import com.example.demo.demo.entity.Articulo;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping("/version1/articulos")
public class ArticuloController {
    @Autowired
    private ArticuloService service;

    @GetMapping()
    public ResponseEntity<List<Articulo>> findAll(
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
        return ResponseEntity.ok(articulos);
    }

    @GetMapping(value="/{id}")
    public ResponseEntity<Articulo> findById(@PathVariable("id") int id) {
        Articulo articulo = service.findById(id);
        if (articulo == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(articulo);
        }
    }

    public ResponseEntity<Articulo> create(@RequestBody Articulo articulo) {
        Articulo registro = service.save(articulo);
        return ResponseEntity.status(HttpStatus.CREATED).body(registro);
    }

}
