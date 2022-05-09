package eus.birt.dam.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import eus.birt.dam.domain.Student;

public interface StudentRepository extends MongoRepository<Student, String>{

	List<Student> findByFirstName(String name);
}
