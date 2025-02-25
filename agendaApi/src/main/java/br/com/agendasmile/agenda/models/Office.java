package br.com.agendasmile.agenda.models;

import java.sql.Timestamp;
import java.util.List;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.UuidGenerator;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@DynamicUpdate(true)
@Table(name = "office")
public class Office {
	
    @Id
    @GeneratedValue(generator = "UUID")
    @UuidGenerator
    private UUID id;
    
    @OneToOne
    @JoinColumn(name = "admin_id", referencedColumnName = "id")
    private User admin;
    
    @OneToMany(mappedBy = "office")
    private List<Appointment> appointments;
    
    @OneToMany(mappedBy = "office")
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
