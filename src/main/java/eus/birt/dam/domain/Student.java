package eus.birt.dam.domain;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document ("students")
public class Student {
	
	@Id
	private String id;
	
	private String firstName;
	
	private String lastName;
	
	@DateTimeFormat (pattern="yyyy-MM-dd")
	private LocalDate birthDate;
	
	private String email;
	
	private University university;
	
	public Student(String firstName, String lastName, LocalDate birthDate, String email, University university) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthDate = birthDate;
		this.email = email;
		this.university = university;
	}

	@Override
	public String toString() {
		return String.format(
				"Student[id=%s, firstName='%s', lastName='%s', birthDate='%s', email='%s']",
				id, firstName, lastName, birthDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd")), email);
	}

}
