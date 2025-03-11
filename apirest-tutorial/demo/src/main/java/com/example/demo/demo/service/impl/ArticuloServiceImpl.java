package com.example.demo.demo.service.impl;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.example.demo.demo.entity.Articulo;
import com.example.demo.demo.exceptions.NoDataFoundException;
import com.example.demo.demo.exceptions.ValidateServiceException;
import com.example.demo.demo.repository.ArticuloRepository;
import com.example.demo.demo.service.ArticuloService;
import com.example.demo.demo.validator.ArticuloValidator;
import com.example.demo.demo.exceptions.GeneralServiceException;

import lombok.extern.slf4j.Slf4j;

import org.springframework.transaction.annotation.Transactional;

import org.springframework.stereotype.Service;

import org.springframework.beans.factory.annotation.Autowired;

@Slf4j
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
        } catch (NoDataFoundException e) {
            log.info(e.getMessage(),e);
            throw e;
        } catch (Exception e) {
            log.error(e.getMessage(), e);;
            throw new GeneralServiceException("Error en la capa de servicio", e);
        }
    }

    @Override
    @Transactional(readOnly=true)
    public List<Articulo> findByNombre(String nombre, Pageable page) {
        try {
            //lista de todos los articulos y/o registros
            return repository.findByNombreContaining(nombre,page);
        } catch (ValidateServiceException | NoDataFoundException e) {
            log.info(e.getMessage(),e);
            throw e;
        } catch (Exception e) {
            log.error(e.getMessage(), e);;
            throw new GeneralServiceException("Error en la capa de servicio", e);
        }
    }

    @Override
    @Transactional(readOnly=true)
    public Articulo findById(int id) {
        try {
            Articulo registro = repository.findById(id).orElseThrow(()->
                new NoDataFoundException("No se encontro el articulo con el id: "+id));
            return registro;
        } catch (ValidateServiceException | NoDataFoundException e) {
            log.info(e.getMessage(),e);
            throw e;
        } catch (Exception e) {
            log.error(e.getMessage(), e);;
            throw new GeneralServiceException("Error en la capa de servicio", e);
        }
    }

    @Override
    @Transactional
    public Articulo save(Articulo articulo) {
       try {
            ArticuloValidator.save(articulo);
            articulo.setActivo(true);
            Articulo registro = repository.save(articulo);
            return registro;
       } catch (ValidateServiceException | NoDataFoundException e) {
            log.info(e.getMessage(),e);
            throw e;
        } catch (Exception e) {
            log.error(e.getMessage(), e);;
            throw new GeneralServiceException("Error en la capa de servicio", e);
        }
    }

    @Override
    @Transactional
    public Articulo update(Articulo articulo) {
       try {
            ArticuloValidator.save(articulo);
            Articulo registro = repository.findById(articulo.getId()).orElseThrow(()->
                new NoDataFoundException("No se encontro el articulo con el id: "+articulo.getId()));
            registro.setNombre(articulo.getNombre());
            registro.setPrecio(articulo.getPrecio());
            repository.save(registro);
            return registro;
       } catch (ValidateServiceException | NoDataFoundException e) {
            log.info(e.getMessage(),e);
            throw e;
        } catch (Exception e) {
            log.error(e.getMessage(), e);;
            throw new GeneralServiceException("Error en la capa de servicio", e);
        }
    }

    @Override
    @Transactional
    public void delete(int id) {
        try{
            Articulo registro = repository.findById(id).orElseThrow(()->
                new NoDataFoundException("No se encontro el articulo con el id: "+id));
            repository.delete(registro);
        } catch (ValidateServiceException | NoDataFoundException e) {
            log.info(e.getMessage(),e);
            throw e;
        } catch (Exception e) {
            log.error(e.getMessage(), e);;
            throw new GeneralServiceException("Error en la capa de servicio", e);
        }
    }

}
