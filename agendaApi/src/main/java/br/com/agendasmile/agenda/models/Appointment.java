package br.com.agendasmile.agenda.models;

import java.sql.Timestamp;
import java.util.UUID;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.annotations.UuidGenerator;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import org.hibernate.type.SqlTypes;

@Entity
@DynamicUpdate(true)
@Table(name = "appointment")
public class Appointment {
	
	@Id
    @GeneratedValue(generator = "UUID")
	@JdbcTypeCode(SqlTypes.VARCHAR)
    @UuidGenerator
    private UUID id;
	
    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "office_id", referencedColumnName = "id")
    private Office office;

    @ManyToOne
    @JoinColumn(name = "patient_id", referencedColumnName = "id")
    private Patient patient;
	
	@Column(nullable = false, length = 50)
	@Size(min = 2, max = 50)
	@NotBlank
	private String title;
	
	@Column(nullable = true, length = 255)
	@Size(min = 2, max = 255)
	private String description;
	
	@Column(nullable = false, length = 50)
	@Size(min = 1, max = 50)
	@NotBlank
	private String appointment_type;
	
	@Column(nullable = false)
	private Timestamp start_time;
	
	@Column(nullable = false)
	private Timestamp end_time;
	
    @CreationTimestamp
    @Column(updatable = false)
    private Timestamp created_at;

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Office getOffice() {
		return office;
	}

	public void setOffice(Office office) {
		this.office = office;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getAppointment_type() {
		return appointment_type;
	}

	public void setAppointment_type(String appointment_type) {
		this.appointment_type = appointment_type;
	}

	public Timestamp getStart_time() {
		return start_time;
	}

	public void setStart_time(Timestamp start_time) {
		this.start_time = start_time;
	}

	public Timestamp getEnd_time() {
		return end_time;
	}

	public void setEnd_time(Timestamp end_time) {
		this.end_time = end_time;
	}

	public Timestamp getCreated_at() {
		return created_at;
	}

	public void setCreated_at(Timestamp created_at) {
		this.created_at = created_at;
	}
}
