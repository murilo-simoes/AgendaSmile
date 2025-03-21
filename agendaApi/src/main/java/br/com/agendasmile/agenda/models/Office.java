package br.com.agendasmile.agenda.models;

import java.sql.SQLType;
import java.sql.Timestamp;
import java.util.List;
import java.util.UUID;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Size;
import org.hibernate.annotations.*;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import org.hibernate.type.SqlTypes;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@DynamicUpdate(true)
@Table(name = "office")
public class Office {
	
    @Id
    @GeneratedValue(generator = "UUID")
	@JdbcTypeCode(SqlTypes.VARCHAR)
    @UuidGenerator
    private UUID id;
    
    @OneToOne
    @JoinColumn(name = "admin_id", referencedColumnName = "id")
	@Valid
	@JsonIgnore // Impede a serialização recursiva
    private User admin;
    
    @OneToMany(mappedBy = "office")
    private List<Appointment> appointments;
    
    
    @OneToMany(mappedBy = "office")
	@Size(max = 50, min = 2)
    private List<Patient> patients;
    
    @Column(nullable = false, length = 100)
    private String name;
    
    @CreationTimestamp
    @Column(updatable = false)
    private Timestamp created_at;

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public User getAdmin() {
		return admin;
	}

	public void setAdmin(User admin) {
		this.admin = admin;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Timestamp getCreated_at() {
		return created_at;
	}

	public void setCreated_at(Timestamp created_at) {
		this.created_at = created_at;
	}
    
    
}
