package eus.birt.dam.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import eus.birt.dam.domain.Student;
import eus.birt.dam.repository.StudentRepository;

@RestController
@RequestMapping ("api/students")
public class StudentController {
	
	@Autowired
	StudentRepository studentRepository;
	
	@GetMapping({"/", ""})
	public List <Student> index() {
		return studentRepository.findAll();
	}
	
	@GetMapping("/")
	public Student show(@PathVariable("id") String id) {
		return studentRepository.findById(id).orElse(null);
	}
	
	@GetMapping("/{name}")
	public List <Student> showByname(@PathVariable("name") String name) {
		return studentRepository.findByFirstName(name);
	}
	
	@PostMapping("/")
	@ResponseStatus (HttpStatus.CREATED)
	public Student create(@RequestBody Student student) {
		return studentRepository.save(student);
	}
	
	@PutMapping("/{id}")
	@ResponseStatus (HttpStatus.CREATED)
	public Student update(@RequestBody Student student, @PathVariable("id") String id) {
		Student tempStudent = studentRepository.findById(id).orElse(null);
		
		tempStudent.setFirstName(student.getFirstName());
		tempStudent.setLastName(student.getLastName());
		tempStudent.setBirthDate(student.getBirthDate());
		tempStudent.setEmail(student.getEmail());
		tempStudent.setUniversity(student.getUniversity());
		
		return studentRepository.save(tempStudent);
				
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus (HttpStatus.NO_CONTENT)
	public void delete(@PathVariable("id") String id) {
		studentRepository.deleteById(id);
	}

}
