package com.example.SpringMVCWebApp.service;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.SpringMVCWebApp.modal.Country;
import com.example.SpringMVCWebApp.repository.CountryRepository;

@Service
public class countryService {
	
	@Autowired
	CountryRepository countryRepository;
	
	public List<Country> getCountryList() {
		return countryRepository.findAll();
	}

	public void delete(int id) {
		countryRepository.deleteById(id);
	}
	
	public Country get(int id) {
		return countryRepository.findById(id).get();
	}

	public void saveCountry(Country country) {
		countryRepository.save(country);
	}
}
