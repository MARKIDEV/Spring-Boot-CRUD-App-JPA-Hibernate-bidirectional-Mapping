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
import org.springframework.web.bind.annotation.RestController;

import com.yess.yessdemo.models.Department;
import com.yess.yessdemo.repositories.DepartmentRepository;


@RestController
@RequestMapping ("/api")
public class DepartmentsController {
	@Autowired
	private DepartmentRepository departmentRepository;

	@GetMapping("/departments")
	public List<Department> departments() {

		return departmentRepository.findAll();
	}

	@GetMapping(path = { "/departments/{id}" })
	public Department getOne(@PathVariable (name="id") long id)
	{
		return departmentRepository.findById(id).get();
	}

	@PostMapping(path = { "/departments/add" })
	public Department save(@RequestBody Department department) {
		return departmentRepository.save(department);

	}

	@PutMapping(path = "/departments/{id}")
	public Department update(@PathVariable(name="id") long id, @RequestBody Department department) {
		department.setId(id);
		return departmentRepository.save(department);
		}

	@DeleteMapping(path = { "/departments/{id}" })
	public void delete(@PathVariable(name="id") long id) {
		departmentRepository.deleteById(id);
			
}}
