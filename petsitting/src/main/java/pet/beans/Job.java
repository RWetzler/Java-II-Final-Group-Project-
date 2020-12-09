package pet.beans;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import java.time.LocalDate;
import java.time.LocalTime;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Embeddable
@Table(name="JOBS")
public class Job {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID")
	private long jobId;
	@OneToOne(cascade=CascadeType.PERSIST)
	@JoinColumn(name="OWNER_ID")
	public Owner ownerId;
	@OneToOne(cascade=CascadeType.PERSIST)
	@JoinColumn(name="SITTER_ID")
	public Sitter sitterId;
	@Column(name="RATING")
	private int rating;
	@Column(name="FEEDBACK_TO_SITTER")
	private String feedbackToSitter;
	@Column(name="FEEDBACK_TO_OWNER")
	private String feedbackToOwner;
	@Column(name="STATUS")
	public String status;
	@Column(name="DATE")
	private LocalDate jDate;
	@Column(name="TIME") 
	private LocalTime jTime;
	
	
	public Job(int rating, String feedbackToSitter, String feedbackToOwner, String status, LocalDate jDate, LocalTime jTime) {
		super();
		this.rating = rating;
		this.feedbackToSitter = feedbackToSitter;
		this.feedbackToOwner = feedbackToOwner;
		this.status = status;
		this.jDate = jDate;
		this.jTime = jTime;
		
	}
	

}
