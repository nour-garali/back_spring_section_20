package com.nour.teachers.restcontrollers;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.nour.teachers.entities.University;
import com.nour.teachers.repos.UniversityRepository;
@RestController
@RequestMapping("/api/univ")
@CrossOrigin("*")

public class UniversityRESTController {
	@Autowired
	UniversityRepository UniversityRepository;
	@RequestMapping(method=RequestMethod.GET)
	public List<University> getAllUniversities()
	{
	return UniversityRepository.findAll();
	}
	@RequestMapping(value="/{id}",method = RequestMethod.GET)
	public University getUniversityById(@PathVariable("id") Long id) {
	    return UniversityRepository.findById(id).get();
	}
	
	 @PostMapping
	    public ResponseEntity<University> addUniversity(@RequestBody University university) {
	        University createdUniversity = UniversityRepository.save(university);
	        return new ResponseEntity<>(createdUniversity, HttpStatus.CREATED);
	    }
	}