package com.nour.teachers.entities;
import java.util.List;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class University {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idUniversity;
	private String nomUiversity;
	private String villeUniversity;
	private int nbEnseigant;

	
	@JsonIgnore
@OneToMany(mappedBy = "university")
private List<Enseignant> enseignants;


public University(String nomUiversity, String villeUniversity, int nbEnseigant,
		List<com.nour.teachers.entities.Enseignant> enseignants) {
	super();
	this.nomUiversity = nomUiversity;
	this.villeUniversity = villeUniversity;
	this.nbEnseigant = nbEnseigant;
	this.enseignants = enseignants;
}


public Long getIdUniversity() {
	return idUniversity;
}


public void setIdUniversity(Long idUniversity) {
	this.idUniversity = idUniversity;
}


public String getNomUiversity() {
	return nomUiversity;
}


public void setNomUiversity(String nomUiversity) {
	this.nomUiversity = nomUiversity;
}


public String getVilleUniversity() {
	return villeUniversity;
}


public void setVilleUniversity(String villeUniversity) {
	this.villeUniversity = villeUniversity;
}


public int getNbEnseigant() {
	return nbEnseigant;
}


public void setNbEnseigant(int nbEnseigant) {
	this.nbEnseigant = nbEnseigant;
}


public List<Enseignant> getEnseignants() {
	return enseignants;
}


public void setEnseignants(List<Enseignant> enseignants) {
	this.enseignants = enseignants;
}


@Override
public String toString() {
	return "University [idUniversity=" + idUniversity + ", nomUiversity=" + nomUiversity + ", villeUniversity="
			+ villeUniversity + ", nbEnseigant=" + nbEnseigant + ", enseignants=" + enseignants + "]";
}




}
