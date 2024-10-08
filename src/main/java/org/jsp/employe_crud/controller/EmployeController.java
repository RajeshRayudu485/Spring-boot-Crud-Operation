package org.jsp.employe_crud.controller;

import java.util.Optional;

import org.jsp.employe_crud.dto.Employe;
import org.jsp.employe_crud.repositery.EmployeRepositery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class EmployeController {

	@Autowired
	EmployeRepositery repositery;

	@GetMapping("/")
	public String loadHome() {
		return "home.html";
	}

	@GetMapping("/add-employe")
	public String addEmploye(ModelMap map) {
		map.put("add", "add");
		return "home.html";
	}

	@PostMapping("/add-employe")
	public String addEmploye( Employe employe, ModelMap map) {
		map.put("success", "Employe Record Added Success");
		repositery.save(employe);
		return "home.html";
	}

	@GetMapping("/fetch-records")
	public String fetchRecords(ModelMap map) {
		map.put("fetch", "fetch");
		map.put("employe", repositery.findAll());
		return "home.html";
	}

	@GetMapping("/delete")
	public String Delete(@RequestParam int id, ModelMap map) {
		repositery.deleteById(id);
		map.put("success", "Employe Record Deleted Success");
		return "home.html";
	}

	@GetMapping("/edit")
	public String EditRecord(@RequestParam int id, ModelMap map) {
		Employe employe = repositery.findById(id).get();
		map.put("emp",employe);
		return "home.html";
	}

	@PostMapping("/update-record")
	public String updateEmploye(Employe employe, ModelMap map) {
		map.put("success", "Employe Record Updated Success");
		repositery.save(employe);
		return "home.html";
	}
	@GetMapping("/byname")
	public String fetchByName(ModelMap map) {
		map.put("byname","byname");
		return "home.html";
		
	}
	@GetMapping("/fetch-byname")
	public String fetchByName(@RequestParam String name,ModelMap map) {
		Employe employe = repositery.fetchByName(name);
		map.put("fetchbyname", employe);
		return "home.html";
		
	}
}
