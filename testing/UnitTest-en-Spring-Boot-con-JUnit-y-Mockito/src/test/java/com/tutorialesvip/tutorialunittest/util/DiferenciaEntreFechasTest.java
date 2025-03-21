package com.tutorialesvip.tutorialunittest.util;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.time.Period;

import static org.junit.jupiter.api.Assertions.*;

class DiferenciaEntreFechasTest {
    
    @Autowired
    private DiferenciaEntreFechas diferenciaEntreFechas;

    @Test
    void calculateYearsOfIndependency() {
        /*
        int numero1 = 5;
        int numero2 = 5;
        
        Assertions.assertEquals(10, numero1 + numero2);
        */
        diferenciaEntreFechas = new DiferenciaEntreFechas();
        LocalDate today = LocalDate.now();
        String fechaIndependencia = "27/02/1844";

        Period resultado = diferenciaEntreFechas.calculateYearsOfIndependency(fechaIndependencia);
        
        System.out.println("Resultado: " + resultado.getMonths());
        System.out.println("Resultado: " + resultado.getDays());
        System.out.println("Resultado: " + resultado.getYears());
        Assertions.assertEquals(0,resultado.getMonths() );
        Assertions.assertEquals(21,resultado.getDays() );
        Assertions.assertEquals(181,resultado.getYears() );
        /*
        diferenciaEntreFechas = new DiferenciaEntreFechas();
        String fechaIndependencia = "27/02/1844";

        Period resultado = diferenciaEntreFechas.calculateYearsOfIndependency(fechaIndependencia);

        Assertions.assertEquals(2,resultado.getMonths() );
        Assertions.assertEquals(29,resultado.getDays() );
        Assertions.assertEquals(176,resultado.getYears() );
        */
    }
}
