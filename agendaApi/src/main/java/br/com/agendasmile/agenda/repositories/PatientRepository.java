package br.com.agendasmile.agenda.repositories;

import br.com.agendasmile.agenda.models.Patient;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface PatientRepository extends CrudRepository<Patient, UUID> {
}
