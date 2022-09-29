package com.example.SpringMVCWebApp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.example.SpringMVCWebApp.modal.Country;
import com.example.SpringMVCWebApp.service.countryService;

@Controller
public class HomeController {

	@Autowired
	countryService countryService;
	
	@RequestMapping("/list_countries")
	public String listCountries(Model model) {
		List<Country> countryList = countryService.getCountryList();
		model.addAttribute("countries", countryList);
		return "list";
	}
	
	@RequestMapping("/delete/{id}")
	public String deleteCountry(@PathVariable(name="id") int id) {
		countryService.delete(id);
		return "redirect:/list_countries";
	}
	
	@RequestMapping("/country/{id}")
	public ModelAndView getCountryInfo(@PathVariable(name = "id") int id) {
		ModelAndView mav = new ModelAndView("countries");
		Country country = countryService.get(id);
		mav.addObject("country", country);
		return mav;
		
	}
	
	@RequestMapping("/edit/{id}")
	public ModelAndView showEditCountryPage(@PathVariable(name = "id") int id) {
		ModelAndView mav = new ModelAndView("edit_country");
		Country country = countryService.get(id);
		mav.addObject("country", country);
		return mav;
	}
	
	@RequestMapping(value="/save", method=RequestMethod.POST)
	public String saveCountry(@ModelAttribute("country") Country country) {
		countryService.saveCountry(country);
		return "redirect:/list_countries";
	}
	
	@RequestMapping("/new")
	public String newCountry(Model model) {
		Country country = new Country();
		model.addAttribute("country", country);
		return "newcountry";
	}
}
