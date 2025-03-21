package com.tutorialesvip.tutorialunittest.controller;

import org.apache.catalina.connector.Response;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.tutorialesvip.tutorialunittest.models.Country;
import com.tutorialesvip.tutorialunittest.models.CountryResponse;
import com.tutorialesvip.tutorialunittest.repositories.CountryRepository;
import com.tutorialesvip.tutorialunittest.util.DiferenciaEntreFechas;

import java.util.Optional;
import org.mockito.Mockito;

import org.junit.jupiter.api.Assertions;
import static org.junit.jupiter.api.Assertions.*;

import org.springframework.http.ResponseEntity;

public class IndependencyControllerTest {


    @Autowired
    CountryResponse countryResponse;
    @Autowired
    Optional<Country> country;

    CountryRepository countryRepositoryMock = Mockito.mock(CountryRepository.class);
    
    @Autowired
    DiferenciaEntreFechas diferenciaEntreFechas = new DiferenciaEntreFechas();

    @Autowired
    IndependencyController independencyController = new IndependencyController(countryRepositoryMock,diferenciaEntreFechas);
    // significa que se va a ejecutar antes de cualquier cosa
    // corre antes que la prueba unitaria
    // sino que tambien para las n pruebas unitarias
    @BeforeEach
    void setUp() {
        //System.out.println("Antes de cada prueba unitaria");
        Country mockCountry = new Country();
        mockCountry.setCountryName("República Dominicana");
        mockCountry.setCountryCapital("Santo Domingo");
        mockCountry.setCountryIdependenceDate("27/02/1844");
        mockCountry.setIsoCode("DO");
        mockCountry.setCountryId((long) 1);

        Mockito.when(countryRepositoryMock.findCountryByIsoCode("DO")).thenReturn(mockCountry);
    }

    @Test
    void getCountryDetailsWithValidCountryCode() {
        //System.out.println("Prueba unitaria");
        ResponseEntity<CountryResponse> respuestaServicio;

        respuestaServicio = independencyController.getCountryDetails("DO");
        Assertions.assertEquals("República Dominicana", respuestaServicio.getBody().getCountryName());
        //System.out.println("Respuesta: " + respuestaServicio);

    }

    @Test
    void getCountryDetailsWithInvalidCountryCode() {
        //System.out.println("Prueba unitaria");
        ResponseEntity<CountryResponse> respuestaServicio;

        respuestaServicio = independencyController.getCountryDetails("IT");
        Assertions.assertNull(respuestaServicio.getBody().getCountryName());
        //System.out.println("Respuesta: " + respuestaServicio);

    }

    // se ejecuta despues de cada prueba unitaria
    @AfterEach
    void tearDown() {
        System.out.println("Despues de cada prueba unitaria");
    }
    
}
