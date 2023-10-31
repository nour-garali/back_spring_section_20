package com.nour.teachers;
import java.util.Date;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.nour.teachers.entities.Enseignant;
import com.nour.teachers.repos.EnseignantRepository;

@SpringBootTest
class TeachersApplicationTests {

	@Autowired
	private EnseignantRepository enseignantRepository;
	@Test
	public void testCreateEnseignant() { 
	Enseignant Ens = new Enseignant("nour","nabeul",new Date(),1500);
	enseignantRepository.save(Ens);
}

}
