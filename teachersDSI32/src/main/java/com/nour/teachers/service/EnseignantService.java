package com.nour.teachers.service;
import java.util.List;

import org.springframework.data.repository.query.Param;

import com.nour.teachers.entities.University;
import com.nour.teachers.dto.EnseignantDTO;
import com.nour.teachers.entities.Enseignant;
public interface EnseignantService {
	EnseignantDTO saveEnseignant(EnseignantDTO e);
	EnseignantDTO updateEnseignant(EnseignantDTO e);
    void deleteEnseignant(Enseignant e);
    void deleteEnseignantById(Long idEnseignant);
    EnseignantDTO getEnseignant(Long idEnseignant);
    List<EnseignantDTO> getAllEnseignant();
    

	 List<Enseignant> findByNomEnseignant(String nom);
	 List<Enseignant>findByNomEnseignantContains(String nom); 
	 List<Enseignant> findByNomSalaire(@Param("nom") String nom,@Param("salaire") Double salaire); 
	 List<Enseignant>findByUniversity (University university); 
	 List<Enseignant>findByUniversityIdUniversity(Long id); 
	 List<Enseignant>findByOrderByNomEnseignant(); 
	 List<Enseignant> trierEnseignantNomSalaire();
	
	 
	 EnseignantDTO convertEntityToDto (Enseignant enseignant);
	 Enseignant convertDtoToEntity(EnseignantDTO enseignantDTO);
}
