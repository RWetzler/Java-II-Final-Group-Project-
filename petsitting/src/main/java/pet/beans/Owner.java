package pet.beans;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CollectionId;
import org.hibernate.annotations.Type;
import org.springframework.beans.factory.annotation.Autowired;

import lombok.Data;
import lombok.NoArgsConstructor;
import pet.repository.OwnerRepository;


@NoArgsConstructor
@Data
@Entity
@Embeddable
@Table(name="OWNERS")
public class Owner {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID")
	private long ownerId;
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
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumns({
		@JoinColumn(name="PET_NAME", referencedColumnName = "PET_NAME"),@JoinColumn(name="PET_TYPE",referencedColumnName="PET_TYPE"),@JoinColumn(name="PET_NEEDS",referencedColumnName="PET_NEEDS")
		})
	private Pet pet;
	@Column(name="NUM_OF_PETS")
	private  String numOfPets;

	public Owner(String firstName, String lastName, String userName, String passWord,String phone, String email, String miscContact, Pet pet, Address address) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.userName = userName;
		this.passWord = passWord;
		this.phone = phone;
		this.email = email;
		this.miscContact = miscContact;
		this.pet = pet;
		this.address = address;
	}
	public Owner(String firstName, String lastName, String userName, String passWord,String phone, String email, String miscContact) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.userName = userName;
		this.passWord = passWord;
		this.phone = phone;
		this.email = email;
		this.miscContact = miscContact;
	}
	public Owner(String userName, String passWord) {
		this.userName = userName;
		this.passWord = passWord;
	}
}
