package br.com.agendasmile.agenda.models;
import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;
import java.util.UUID;

import br.com.agendasmile.agenda.dto.CreatePatientDto;
import jakarta.annotation.Nullable;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
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
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import org.hibernate.type.SqlTypes;
import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "patient")
public class Patient implements Serializable {

	private static final long serialUUID = 1L;

	@Id
    @GeneratedValue(generator = "UUID")
	@JdbcTypeCode(SqlTypes.VARCHAR)
    @UuidGenerator
    private UUID id;
	
    @ManyToOne
    @JoinColumn(name = "office_id", referencedColumnName = "id")
    private Office office;

    @OneToMany(mappedBy = "patient")
    private List<Appointment> appointments;
    
    @Column(nullable = false, length = 25)
	@Size(min = 1, max = 25)
	@NotBlank
    private String first_name;
    
    @Column(nullable = false, length = 100)
	@Size(min = 1, max = 100)
	@NotBlank
    private String last_name;
    
    @Column(unique = true, nullable = false, length = 11)
	@Size(min = 11, max = 11)
    private String cpf;
    
    @Column(nullable = true)
	@DateTimeFormat(pattern = "yyyy/mm/dd")
    private Date birth_date;
    
    @Column(unique = true, nullable = false, length = 255)
	@Email
	@NotBlank
    private String email;

	@NotBlank
	@Size(min = 11, max = 11)
    @Column(nullable = false, length = 11)
    private String phone_number;
    
    @Column(nullable = true, length = 10)
	@NotBlank
	@Size(min = 4, max = 10)
    private String gender;

    @Column(nullable = true, length = 255)
	@Size(min = 1, max = 255)
    private String obs;
    
    @CreationTimestamp
    @Column(updatable = false)
    private Timestamp created_at;

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public Office getOffice() {
		return office;
	}

	public void setOffice(Office office) {
		this.office = office;
	}

	public List<Appointment> getAppointments() {
		return appointments;
	}

	public void setAppointments(List<Appointment> appointments) {
		this.appointments = appointments;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public Date getBirth_date() {
		return birth_date;
	}

	public void setBirth_date(Date birth_date) {
		this.birth_date = birth_date;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone_number() {
		return phone_number;
	}

	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getObs() {
		return obs;
	}

	public void setObs(String obs) {
		this.obs = obs;
	}

	public Timestamp getCreated_at() {
		return created_at;
	}

	public void setCreated_at(Timestamp created_at) {
		this.created_at = created_at;
	}
}
