package br.com.agendasmile.agenda.repositories;

import br.com.agendasmile.agenda.models.Appointment;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.UUID;

public interface AppointmentRepository extends CrudRepository<Appointment, UUID> {
	List<Appointment> findAllByOfficeId(UUID uuid);
}
