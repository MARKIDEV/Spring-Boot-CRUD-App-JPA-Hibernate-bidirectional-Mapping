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

import com.yess.yessdemo.models.Klass;
import com.yess.yessdemo.repositories.KlassRepository;

@RestController
@RequestMapping ("/api/departments")
public class KlassesController {
	@Autowired
	private KlassRepository klassRepository;

	@GetMapping("/klasses")
	public List<Klass> klasses() {

		return klassRepository.findAll();
	}

	@GetMapping(path = { "/klasses/{id}" })
	public Klass getOne(@PathVariable (name="id") long id)
	{
		return klassRepository.findById(id).get();
	}

	@PostMapping(path = { "/klasses/add" })
	public Klass save(@RequestBody Klass klass) {
		return klassRepository.save(klass);

	}

	@PutMapping(path = "/klasses/{id}")
	public Klass update(@PathVariable(name="id") long id, @RequestBody Klass klass) {
		klass.setId(id);
		return klassRepository.save(klass);
		}

	@DeleteMapping(path = { "/klasses/{id}" })
	public void delete(@PathVariable(name="id") long id) {
		klassRepository.deleteById(id);
			
}}
