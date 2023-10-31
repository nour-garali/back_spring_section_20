package com.nour.teachers.restcontrollers;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.nour.teachers.dto.EnseignantDTO;
import com.nour.teachers.entities.Enseignant;
import com.nour.teachers.service.EnseignantService;


@RestController
@RequestMapping("/api")
@CrossOrigin

public class EnseignantRESTController {

	
	@Autowired
	EnseignantService EnseignantService;
	
	@RequestMapping(path="all" ,method=RequestMethod.GET)
	public List<EnseignantDTO> getAllEnseignant() {
	return EnseignantService.getAllEnseignant();
	}
	
	@RequestMapping(value="/getbyid/{id}",method = RequestMethod.GET)
	
	public EnseignantDTO getEnseignantById(@PathVariable("id") Long id) {
	return EnseignantService.getEnseignant(id);
	 }

	@RequestMapping(value="/addEns",method = RequestMethod.POST)
	public EnseignantDTO createEnseignant(@RequestBody EnseignantDTO enseignantDTO) {
	return EnseignantService.saveEnseignant(enseignantDTO);
	}

	@RequestMapping(value="/updateEns",method = RequestMethod.PUT)
	public EnseignantDTO updateEnseignant(@RequestBody EnseignantDTO enseignantDTO) {
	return EnseignantService.updateEnseignant(enseignantDTO);
	}

	@RequestMapping(value="/delEns/{id}",method = RequestMethod.DELETE)
	public void deleteEnseignant(@PathVariable("id") Long id)
	{
		EnseignantService.deleteEnseignantById(id);
	}
	
	
	
	@RequestMapping(value="/ensUniv/{idUniversity}",method = RequestMethod.GET)
	public List<Enseignant> getEnseignantsByUnivId(@PathVariable("idUniv") Long idUniv) {
	return EnseignantService.findByUniversityIdUniversity(idUniv);
	}
	
	
	@RequestMapping(value="/ensByName/{nom}",method = RequestMethod.GET)
	public List<Enseignant> findByNomEnseignantContains(@PathVariable("nom") String nom) {
	return EnseignantService.findByNomEnseignantContains(nom);
	}

	
}
