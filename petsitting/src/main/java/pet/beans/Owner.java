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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

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
	/*@Autowired
	private Address AddressId;
	*/
	@Column(name="PHONE")
	private String phone;
	@Column(name="EMAIL")
	private String email;
	@Column(name="MISC_CONTACT")
	private String miscContact;
	@OneToOne
	@JoinColumns({
		@JoinColumn(name="PET_NAME", referencedColumnName = "PET_NAME"),@JoinColumn(name="PET_TYPE",referencedColumnName="PET_TYPE"),@JoinColumn(name="PET_NEEDS",referencedColumnName="PET_NEEDS")
		})
	private Pet pet;
	@Column(name="NUM_OF_PETS")
	private  String numOfPets;

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
	
	
	
}
