package com.nour.teachers.service;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import com.nour.teachers.entities.University;
import com.nour.teachers.dto.EnseignantDTO;
import com.nour.teachers.entities.Enseignant;
import com.nour.teachers.repos.EnseignantRepository;


@Service
public class EnseignantServiceImpl implements EnseignantService{

	 @Autowired
	    EnseignantRepository enseignantRepository;
	 
	 @Autowired
	 ModelMapper modelMapper;
	
	 @Override
	    public EnseignantDTO saveEnseignant(EnseignantDTO e) {
	        return convertEntityToDto( enseignantRepository.save(convertDtoToEntity(e)));

	    }

	    @Override
	    public EnseignantDTO updateEnseignant(EnseignantDTO e) {
	        return convertEntityToDto(enseignantRepository.save(convertDtoToEntity(e)));
	    }

	    @Override
	    public void deleteEnseignant(Enseignant e) {
	        enseignantRepository.delete(e);
	    }

	    @Override
	    public void deleteEnseignantById(Long id) {
	        enseignantRepository.deleteById(id);
	    }

	    @Override
	    public EnseignantDTO getEnseignant(Long id) {
	        return convertEntityToDto( enseignantRepository.findById(id).get());
	    }

	    @Override
	    public List<EnseignantDTO> getAllEnseignant() {
	        return enseignantRepository.findAll().stream()
	        		.map(this::convertEntityToDto)
	        		.collect(Collectors.toList());

	    }
	

	    
	    
	    @Override
	    public List<Enseignant> findByNomEnseignant(String nom){
	    	return enseignantRepository.findByNomEnseignant(nom);
	    }
	    @Override
	    public  List<Enseignant>findByNomEnseignantContains(String nom){
	    	return enseignantRepository.findByNomEnseignantContains(nom);
	    
	    }
	    @Override
	    public  List<Enseignant> findByNomSalaire(@Param("nom") String nom,@Param("salaire") Double salaire){
	    	return enseignantRepository.findByNomSalaire(nom,salaire);
	        
	    }
	    @Override
	    public List<Enseignant>findByUniversity (University university){
	    	return enseignantRepository.findByUniversity(university);
	        
	    }
	    @Override
	    public List<Enseignant>findByUniversityIdUniversity(Long id){
	    	return enseignantRepository.findByUniversityIdUniversity(id);
	        
	    }
	    
	    @Override
	    public List<Enseignant>findByOrderByNomEnseignant(){
	    	return enseignantRepository.findByOrderByNomEnseignant();
	        
	    }
	    @Override
	    public  List<Enseignant> trierEnseignantNomSalaire(){
	    	return enseignantRepository.trierEnseignantsNomEnseignantSalaire();
	        
	    }
	    
	    

	   
	    	@Override
	    	public EnseignantDTO convertEntityToDto(Enseignant enseignant) {
	    		EnseignantDTO enseignantDTO = modelMapper.map(enseignant, EnseignantDTO.class);
	    	 return enseignantDTO; 
	    	 }

	    	/*@Override
	    	public Enseignant convertEntityToDto(EnseignantDTO enseignantDTO) {
	    	
	    		Enseignant enseignant= new Enseignant();

	    		
	    		
	    		enseignant=modelMapper.map(enseignantDTO, Enseignant.class);
	    	 return enseignant; 
	    	 }*/

	    	
	    	/*EnseignantDTO enseignantDTO = new EnseignantDTO();
	    	enseignantDTO.setIdEnseignant(enseignant.getIdEnseignant());
	    	enseignantDTO.setNomEnseignant(enseignant.getNomEnseignant());
	    	enseignantDTO.setVilleEnseignant(enseignant.getVilleEnseignant());
	    	
	    	//enseignantDTO.setSalaire(enseignant.getSalaire());
	    	enseignantDTO.setDateNaissance(enseignant.getDateNaissance());
	    	enseignantDTO.setUniversity(enseignant.getUniversity()); 
	     return enseignantDTO; */
	     
	     /*return ProduitDTO.builder()
	    .idProduit(produit.getIdProduit())
	    .nomProduit(produit.getNomProduit())
	    .prixProduit(produit.getPrixProduit())
	    .dateCreation(p.getDateCreation())
	    .categorie(produit.getCategorie())
	    .build();*/
	    
	    
	    @Override
	    public Enseignant convertDtoToEntity(EnseignantDTO enseignantDTO) {
	    	Enseignant enseignant = new Enseignant();
	    	enseignant.setIdEnseignant(enseignantDTO.getIdEnseignant());
	    	enseignant.setNomEnseignant(enseignantDTO.getNomEnseignant());
	    	enseignant.setVilleEnseignant(enseignantDTO.getVilleEnseignant());
	    	//enseignant.setSalaire(enseignantDTO.getSalaire());
	    	enseignant.setDateNaissance(enseignantDTO.getDateNaissance());
	    	enseignant.setUniversity(enseignantDTO.getUniversity()); 
	     return enseignant; 
	    }

	    
		
	
	
}
