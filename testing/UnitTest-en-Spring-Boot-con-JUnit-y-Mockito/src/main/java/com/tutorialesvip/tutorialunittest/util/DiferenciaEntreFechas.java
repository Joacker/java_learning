package com.tutorialesvip.tutorialunittest.util;

import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

@Component
public class DiferenciaEntreFechas {

    public Period calculateYearsOfIndependency(String independenceDay) {
        // Colocamos la fecha que se nos entrega en un formato de fecha
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");

        LocalDate localDate = LocalDate.parse(independenceDay, formatter);
        // Aquí toma la fecha actual
        LocalDate today = LocalDate.now();
        //Va a retornar un objeto del tipo periodo, ya sea la fehca de hoy menos la fecha que se le pase (independencia)
        return Period.between(localDate, today);
    }
}