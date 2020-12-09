package pet.beans;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@Data
@Embeddable
@Entity
@Table(name="SITTERS")
public class Sitter {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID")
	private long sitterId;
	@Column(name="FIRST_NAME")
	private String firstName;
	@Column(name="LAST_NAME")
	private String lastName;
	@Column(name="USERNAME")
	private String userName;
	@Column(name="PASSWORD")
	private String passWord;
	@OneToOne(cascade=CascadeType.PERSIST)
	@JoinColumn(name="ADDRESS_ID")
	private Address address;
	@Column(name="PHONE")
	private String phone;
	@Column(name="EMAIL")
	private String email;
	@Column(name="MISC_CONTACT")
	private String miscContact;
	@Column(name="CERTIFICATIONS")
	private String certifications;
	@Column(name="MAX_PETS")
	private int maxPets;
	@Column(name="BIOGRAPHY")
	private String biography;
	@Column(name="AVG_RATING")
	private double averageRating;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="JOB")
	private Job job;

	public Sitter(String firstName, String lastName, String userName, String passWord, String phone, String email,
			String miscContact, String certifications, int maxPets, String biography, double averageRating) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.userName = userName;
		this.passWord = passWord;
		this.phone = phone;
		this.email = email;
		this.miscContact = miscContact;
		this.certifications = certifications;
		this.maxPets = maxPets;
		this.biography = biography;
		this.averageRating = averageRating;
	}
	
	public Sitter(String firstName, String lastName, String userName, String passWord, String phone, String email,
			String miscContact, String certifications, int maxPets, String biography, double averageRating, Job job, Address address) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.userName = userName;
		this.passWord = passWord;
		this.phone = phone;
		this.email = email;
		this.miscContact = miscContact;
		this.certifications = certifications;
		this.maxPets = maxPets;
		this.biography = biography;
		this.averageRating = averageRating;
		this.job = job;
		this.address = address;
	}
public Sitter(String passWord, String userName) {
	this.passWord = passWord;
	this.userName = userName;
}
}
