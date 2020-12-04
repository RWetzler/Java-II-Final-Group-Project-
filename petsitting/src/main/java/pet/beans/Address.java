package pet.beans;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@Embeddable
@Entity
@Table(name="ADDRESSES")
public class Address {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID")
	private long addressId;
	@Column(name="STREET1")
	private String street1;
	@Column(name="STREET2")
	private String street2;
	@Column(name="CITY")
	private String city;
	@Column(name="STATE")
	private String state;
	@Column(name="ZIP_CODE")
	private String zipCode;
	@Column(name="NEIGHBORHOOD")
	private String neighborhood;
	
	public Address(String street1, String street2, String city, String state, 
			String zipCode, String neighborhood) {
			this.street1 = street1;
			this.street2 = street2;
			this.city = city;
			this.state = state;
			this.zipCode = zipCode;
			this.neighborhood = neighborhood;
	}
	
}
