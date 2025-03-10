package br.com.agendasmile.agenda.repositories;

import br.com.agendasmile.agenda.models.Office;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface OfficeRepository extends CrudRepository<Office, UUID> {
}
