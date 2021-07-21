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
		PensionerModel curr=new  PensionerModel("ABCD", "Kaushik", "9855321221", 23658);
		PensionerModel curr1=new PensionerModel("MDMDU191234","Prasad","9855321222",23659);
		PensionerModel curr2=new PensionerModel("MDMDU191235","Ravi","9855321223",23660);
		PensionerModel curr3=new PensionerModel("MDMDU191236","Satish","9855321224",23661);
		PensionerModel curr4=new PensionerModel("MDMDU191235","Ajay","9855321226",23662);
        repo.save(curr);
        repo.save(curr1);
        repo.save(curr2);
        repo.save(curr3);
		repo.save(curr4);
		return this.repo.findAll();
	}
	@PostMapping("/add")
	public java.util.List<PensionerModel> add(@RequestBody PensionerModel model) {
		repo.save(model);
		return repo.findAll();
	}
	
}
