package com.example.SpringMVCWebApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.SpringMVCWebApp.modal.Country;

@Repository
public interface CountryRepository extends JpaRepository<Country, Integer> {

}
