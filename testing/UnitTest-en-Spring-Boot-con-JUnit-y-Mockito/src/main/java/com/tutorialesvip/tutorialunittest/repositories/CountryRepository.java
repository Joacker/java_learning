package com.tutorialesvip.tutorialunittest.repositories;

import com.tutorialesvip.tutorialunittest.models.Country;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CountryRepository extends CrudRepository<Country, Long> {
    // Va a buscar los paises por codigo iso 
    Country findCountryByIsoCode(String isoCode);
}
