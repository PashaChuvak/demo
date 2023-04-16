package com.example.demo.cat;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@CrossOrigin("${cross_origin}")
@RequestMapping("/cat/")
public class CatController {

	final private CatService catService;
	
	@GetMapping(value = "list", produces = "application/json")
	public String getAllCats() {
		return catService.getCats();
	}
	
	@PostMapping("save")
	@ResponseStatus(value = HttpStatus.CREATED)
	public Cat saveCat(@RequestBody CatRequest catRequest) {
		return catService.save(catRequest);
	}
	
	@DeleteMapping("delete/{id}")
	public void deleteById(@PathVariable Integer id) {
		catService.deleteById(id);
	}
	
	@PatchMapping("update/{id}")
	public Cat updateById(@PathVariable Integer id, @RequestBody CatRequest catRequest) {
		return catService.updateById(id, catRequest);
	}
	
	@GetMapping("get/{id}")
	public Cat getById(@PathVariable Integer id) {
		return catService.getById(id);
	}
}
