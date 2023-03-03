package com.feb2023.Repository;

import com.feb2023.model.CountryModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CountryRepo extends JpaRepository<CountryModel,Integer> {
    @Query("select country from CountryModel country where country.name = ?1")
    Optional<CountryModel> getCountryByName(String name);
}
