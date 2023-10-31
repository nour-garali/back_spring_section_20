package com.nour.teachers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

import com.nour.teachers.entities.Enseignant;
import com.nour.teachers.entities.University;

@SpringBootApplication
public class TeachersApplication implements CommandLineRunner {

	@Autowired
	private RepositoryRestConfiguration repositoryRestConfiguration;

	public static void main(String[] args) {
		SpringApplication.run(TeachersApplication.class, args);
	}

	public void run(String... args) throws Exception {
		repositoryRestConfiguration.exposeIdsFor(Enseignant.class,University.class);
	}
	@Bean
	public ModelMapper modelMapper()
	{
	return new ModelMapper();
	}

}
