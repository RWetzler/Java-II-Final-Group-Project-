package pet.beans;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;
@NoArgsConstructor
@Data
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
	
	public long getSitterId() {
		return sitterId;
	}
	public void setSitterId(long sitterId) {
		this.sitterId = sitterId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassWord() {
		return passWord;
	}
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMiscContact() {
		return miscContact;
	}
	public void setMiscContact(String miscContact) {
		this.miscContact = miscContact;
	}
	public String getCertifactions() {
		return certifactions ;
	}
	public void setCertifactions(String certifactions) {
		this.certifactions = certifactions;
	}
	public int getMaxPets() {
		return maxPets;
	}
	public void setMaxPets(int maxPets) {
		this.maxPets = maxPets;
	}
	public double getAverageRating() {
		return averageRating;
	}
	public void setAverageRating(double averageRating) {
		this.averageRating = averageRating;
	}

}
