package br.com.agendasmile.agenda.repositories;

import br.com.agendasmile.agenda.models.Patient;
import br.com.agendasmile.agenda.models.User;

import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface PatientRepository extends CrudRepository<Patient, UUID> {
	Patient findByEmail(String email);
}
