package com.example.crud.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import com.example.crud.services.ServiceStudent;
import com.example.crud.model.Student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

	@Autowired
	ServiceStudent serviceStudent;

	@GetMapping("/")
	public String login() {
		return "login";
	}

	@GetMapping("/register")
	public String register() {
		return "register";
	}

	@GetMapping("/forgotpassword")
	public String forgotpassword() {
		return "forgotpassword";
	}

	@GetMapping("/dashboard")
	public String dashboard() {
		return "dashboard";
	}

	@GetMapping("/category")
	public String category() {
		return "category";
	}

	@GetMapping("/student")
	public ModelAndView student() {
		List<Student> students = serviceStudent.getStudents();
		return new ModelAndView("student", "students", students);
	}

	@GetMapping("/newstudent")
	public String newRegistration(ModelMap model) {
		Student std = new Student();
		model.addAttribute("student", std);
		return "newstudent";

	}

	@GetMapping("/delete/{id}")
	public String deleteStudent(@PathVariable Integer id) {
		serviceStudent.deleteStudent(id);
		return "redirect:/student";
	}

	@GetMapping("/editstudent/{id}")
	public String editForm(@PathVariable Integer id, ModelMap model) {
		Student std = serviceStudent.getStudent(id);
		model.addAttribute("student", std);
		return "editstudent";
	}

	@PostMapping("/savestudent")
	public String saveStudent(@Valid Student std, BindingResult result, ModelMap model) {
		if (!result.hasErrors()) {
			serviceStudent.saveStudent(std);
		}
		return "redirect:/student";
	}

	@PostMapping("/updatestudent")
	public String updateStudent(@Valid Student std, BindingResult result, ModelMap model) {
		if (!result.hasErrors()) {
			serviceStudent.saveStudent(std);
		}
		return "redirect:/student";
	}

	@ModelAttribute("countries")
	public List<String> getCountries() {
		List<String> countries = new ArrayList<String>();
		countries.add("Thai");
		countries.add("English");
		countries.add("USA");
		return countries;
	}

	@ModelAttribute("sections")
	public List<String> getsections() {
		List<String> sections = new ArrayList<String>();
		sections.add("Low Class");
		sections.add("Hight Class");
		return sections;
	}

}