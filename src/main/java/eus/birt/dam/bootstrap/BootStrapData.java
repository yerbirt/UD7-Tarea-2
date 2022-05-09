package eus.birt.dam.bootstrap;

import java.time.LocalDate;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import eus.birt.dam.domain.Student;
import eus.birt.dam.domain.University;
import eus.birt.dam.repository.StudentRepository;

@Component
public class BootStrapData implements CommandLineRunner{

	@Autowired
	StudentRepository studentRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		studentRepository.deleteAll();
		
		University university1 = new University(new ObjectId().toString(),"Oxford", "London","Calle1", "Calle2", "01013");
		University university2 = new University(new ObjectId().toString(),"Pittsburg", "Usa","Calle1", "Calle2", "01018");
		
		studentRepository.save(new Student("Pedro", "Perez", LocalDate.parse("1990-05-02"), "pedro@gmail.com", university1));
		studentRepository.save(new Student("Paco", "Jimenez", LocalDate.parse("1990-05-02"), "paco@gmail.com", university2));
		
		System.out.println("Students found with findAll():");
		System.out.println("-------------------------------");
		for(Student student : studentRepository.findAll()) {
			System.out.println(student);
		}
	}
}
