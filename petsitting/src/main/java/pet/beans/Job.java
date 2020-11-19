package pet.beans;


import javax.persistence.CascadeType;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import org.springframework.beans.factory.annotation.Autowired;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Embeddable
public class Job {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long jobId;
	@OneToOne(cascade=CascadeType.PERSIST)
	@JoinColumn(name="OWNER_ID")
	private Owner ownerId;
	@OneToOne(cascade=CascadeType.PERSIST)
	@JoinColumn(name="SITTER_ID")
	private Sitter sitterId;
	private int rating;
	private String feedbackToSitter;
	private String feedbackToOwner;
	
	public Job(int rating) {
		super();
		this.rating = rating;
	}
	
	public Job(int rating, String feedbackToSitter) {
		super();
		this.rating = rating;
		this.feedbackToSitter = feedbackToSitter;
	}
	
	public Job(int rating, String feedbackToSitter, String feedbackToOwner) {
		super();
		this.rating = rating;
		this.feedbackToSitter = feedbackToSitter;
		this.feedbackToOwner = feedbackToOwner;
	}

}
