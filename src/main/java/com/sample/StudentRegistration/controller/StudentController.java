package com.sample.StudentRegistration.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.sample.StudentRegistration.domain.Student;
import com.sample.StudentRegistration.service.StudentService;

@Controller
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	
	@GetMapping("/")
	public String viewHomePage(Model model) {
		List<Student> listStudent = studentService.listAll();
		model.addAttribute("listStudent",listStudent);
		System.out.print("Get / ");
		return "index";
	}
	
	@GetMapping("/new")
	public String add(Model model) {
		model.addAttribute("student", new Student());
		return "new";
		
	}
	
	@PostMapping("/save")
	public String saveStudent(@ModelAttribute("student") Student student) {
		studentService.save(student);
		return "redirect:/";
	}
	
	@RequestMapping("/edit/{id}")
	public ModelAndView showEditStudentPage(@PathVariable(name = "id") int id) {
		ModelAndView mav = new ModelAndView("new");
		Student student = studentService.get(id);
		mav.addObject("student", student);
		return mav;
	}
	
	@RequestMapping("/delete/{id}")
	public String deleteStudent(@PathVariable(name="id") int id) {
		studentService.delete(id);
		return "redirect:/";
	}
}
