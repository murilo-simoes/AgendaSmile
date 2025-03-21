package br.com.agendasmile.agenda.models;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.annotations.UuidGenerator;

import org.hibernate.type.SqlTypes;

@Entity
@DynamicUpdate(true)
@Table(name = "users")
public class User implements Serializable {
	private static final Long serialVersionUUID = 1L;

    @Id
    @GeneratedValue(generator = "UUID")
	@JdbcTypeCode(SqlTypes.VARCHAR)
    @UuidGenerator
    private UUID id;
    
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "office_id", referencedColumnName = "id", unique = false)
    private Office office;
    
    @OneToMany(mappedBy = "user")
    private List<Appointment> appointments;
    
    @Column(nullable = false, length = 25)
	@NotBlank()
    private String first_name;
    
    @Column(nullable = false, length = 100)
	@NotBlank
    private String last_name;
    
    @Column(unique = true, nullable = false, length = 100)
	@Email()
	@NotBlank()
    private String email;
    
    @Column(nullable = false, length = 32)
	@JsonProperty("password")
	@NotBlank
    private String password;
    
    @CreationTimestamp
    @Column(updatable = false)
	@JsonProperty("created_at")
    private Timestamp created_at;
    
    @Column(nullable = false, length = 20)
	@JsonProperty("user_type")
    private String user_type;

    
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Timestamp getCreated_at() {
		return created_at;
	}

	public void setCreated_at(Timestamp created_at) {
		this.created_at = created_at;
	}

	public String getUser_type() {
		return user_type;
	}

	public void setUser_type(String user_type) {
		this.user_type = user_type;
	}

	@Override
	public int hashCode() {
		return Objects.hash(password);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Objects.equals(password, other.password);
	}
	
}
