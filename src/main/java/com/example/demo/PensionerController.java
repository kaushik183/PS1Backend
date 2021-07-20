package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping()
public class PensionerController {
	@Autowired
	private PensionerRepository repo;
	
	@GetMapping("/find/{id}")
	public PensionerModel solve(@PathVariable(value ="id") String id) {
		return this.repo.findById(id).orElseThrow();
	}
	
	@GetMapping("/")
	public java.util.List<PensionerModel> get(){
		PensionerModel curr=new PensionerModel("ABCD", "Kaushik", 3.0, 8373738);
		repo.save(curr);
		return this.repo.findAll();
	}
	@PostMapping("/add")
	public java.util.List<PensionerModel> add(@RequestBody PensionerModel model) {
		repo.save(model);
		return repo.findAll();
	}
	
}
