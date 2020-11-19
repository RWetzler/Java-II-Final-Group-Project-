package pet.beans;

import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;
@NoArgsConstructor
@Data
@Embeddable
@Entity
public class Sitter {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long sitterId;
	
	private String firstName;
	private  String lastName;
	private String userName;
	private String passWord;
	/*@Autowired
	private Address AddressId;
	*/
	private String phone;
	private String email;
	private String miscContact;
	private String certifactions;
	private int maxPets;
	private double averageRating;
	
	public Sitter(String firstName, String lastName, String userName, String passWord,String phone, String email, String miscContact, String certifactions, int maxPets, double averageRating) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.userName = userName;
		this.passWord = passWord;
		this.phone = phone;
		this.email = email;
		this.miscContact = miscContact;
		this.certifactions = certifactions;
		this.maxPets = maxPets;
		this.averageRating = averageRating;
		
		
	}
	
	

}
