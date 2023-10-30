package com.springbootjdbcpostgresql.controler;

import com.springbootjdbcpostgresql.model.Employee;
import com.springbootjdbcpostgresql.repository.EmployeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeControler {
	
	@Autowired
	EmployeRepository employeRepository;

	@CrossOrigin
	 @GetMapping("/employee")

	 public ResponseEntity<List<Employee>> getAllTutorials(@RequestParam(required = false) String title) {
		    try {
		      List<Employee> tutorials = new ArrayList<Employee>();
		      if (title == null)
		    	  employeRepository.findAll().forEach(tutorials::add);
		       System.out.println("output")	;	      
		      if (tutorials.isEmpty()) {
		        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		      }
		      return new ResponseEntity<>(tutorials, HttpStatus.OK);
		    } catch (Exception e) {
		      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		    }
	    }
     @CrossOrigin
	 @GetMapping("/employee/{id}")

	  public ResponseEntity<Employee> getTutorialById(@PathVariable("id") int id) {
	    Employee tutorial = employeRepository.findById(id);
	    if (tutorial != null) {
	      return new ResponseEntity<>(tutorial, HttpStatus.OK);
	    } else {
	      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	  }
    @CrossOrigin
	@PostMapping("/employee")
	public ResponseEntity<String> createTutorial(@RequestBody Employee tutorial) {

			try {


				employeRepository.save(new Employee( tutorial.getFname(), tutorial.getLname(), tutorial.getId(),  tutorial.getTel(), tutorial.getEmail(),tutorial.getAddress(), tutorial.getCity(), tutorial.getState(),tutorial.getZip()));

				return new ResponseEntity<>("Employee was created successfully.", HttpStatus.CREATED);
			} catch (Exception e) {
				return new ResponseEntity<>(e.getLocalizedMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
			}

		}

    @CrossOrigin
	@DeleteMapping("/employee/{id}")
	public ResponseEntity<String> deleteTutorial(@PathVariable("id") int id) {
		try {
			int result = employeRepository.deleteById(id);
			if (result == 0) {
				return new ResponseEntity<>("Cannot find Tutorial with id=" + id, HttpStatus.OK);
			}
			return new ResponseEntity<>("Tutorial was deleted successfully.", HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>("Cannot delete tutorial.", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
    @CrossOrigin
	@PutMapping("/employee/{id}")
	public ResponseEntity<String> updateTutorial(@PathVariable("id")int id, @RequestBody Employee tutorial) {
		Employee _tutorial = employeRepository.findById(id);
		if (_tutorial != null) {
			_tutorial.setId(id);
			_tutorial.setFname(tutorial.getFname());
			_tutorial.setLname(tutorial.getLname());
			_tutorial.setTel(tutorial.getTel());
			_tutorial.setEmail(tutorial.getEmail());
			_tutorial.setAddress(tutorial.getAddress());
			_tutorial.setCity(tutorial.getCity());
			_tutorial.setState(tutorial.getState());
			_tutorial.setZip(tutorial.getZip());
			employeRepository.update(_tutorial);
			return new ResponseEntity<>("Tutorial was updated successfully.", HttpStatus.OK);
		} else {
			return new ResponseEntity<>("Cannot find Tutorial with id=" + id, HttpStatus.NOT_FOUND);
		}
	}
}



