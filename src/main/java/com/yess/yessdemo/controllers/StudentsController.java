package com.yess.yessdemo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.yess.yessdemo.models.Student;
import com.yess.yessdemo.repositories.StudentRepository;

@RestController
@RequestMapping ("/api/departments/klasses")
public class StudentsController {
	@Autowired
	private StudentRepository studentRepository;

	@GetMapping("/students")
	public List<Student> students() {

		return studentRepository.findAll();
	}
	

	@GetMapping(path = { "/students/{id}" })
	public Student getOne(@PathVariable (name="id") long id)
	{
		return studentRepository.findById(id).get();
	}

	@PostMapping(path = { "/students/add" })
	public Student save(@RequestBody Student student) {
		return studentRepository.save(student);

	}

	@PutMapping(path = "/students/{id}")
	public Student update(@PathVariable(name="id") long id, @RequestBody Student student) {
		student.setId(id);
		return studentRepository.save(student);
		}

	@DeleteMapping(path = { "/students/{id}" })
	public void delete(@PathVariable(name="id") long id) {
		studentRepository.deleteById(id);
			
}}
