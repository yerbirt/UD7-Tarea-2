package eus.birt.dam.domain;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class University {
	
	private String id;
	
	private String name;
	
	private String city;
	
	private String addressLine1;
	
	private String addressLine2;
	
	private String zipCode;
	
	public University(String name, String city, String addressLine1, String addressLine2, String zipCode) {
		super();
		this.name = name;
		this.city = city;
		this.addressLine1 = addressLine1;
		this.addressLine2 = addressLine2;
		this.zipCode = zipCode;
	}	
}
