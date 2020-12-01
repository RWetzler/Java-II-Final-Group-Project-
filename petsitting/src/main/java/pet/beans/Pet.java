package pet.beans;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@Entity
@Embeddable

public class Pet {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="PET_ID")
	private long petId;
	@Column(name="PET_NAME")
	private String petName;
	@Column(name="PET_TYPE")
	private String petType;
	@Column(name="PET_NEEDS")
	private String petNeeds;
	
	
	public Pet(String petName, String petType,String petNeeds) {
		this.petName = petName;
		this.petType = petType;
		this.petNeeds = petNeeds;
	}



}
