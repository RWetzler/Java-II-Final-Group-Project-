package pet.beans;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
	private String certifacctions;
	private int maxPets;
	private double averageRating;
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
	public String getCertifacctions() {
		return certifacctions;
	}
	public void setCertifacctions(String certifacctions) {
		this.certifacctions = certifacctions;
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
