package com.theironyard.invoicify.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.theironyard.invoicify.models.BillingRecord;
import com.theironyard.invoicify.models.Company;
import com.theironyard.invoicify.repositories.CompanyRepository;

@Controller
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	private CompanyRepository companyRepository;

	@GetMapping("/companies")
	public ModelAndView showCompanies() {
		ModelAndView mv = new ModelAndView("admin/companies");
		mv.addObject("companies", companyRepository.findAll(new Sort(Sort.Direction.ASC, "name")));
		return mv;
	}
	
	@PostMapping("/companies")
	public String createCompany(Company company) {
		companyRepository.save(company);
		return ("redirect:/admin/companies");
	}
}
