package br.com.agendasmile.agenda.repositories;

import br.com.agendasmile.agenda.models.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.UUID;

public interface UserRepository extends CrudRepository<User, UUID> {

	User findByEmail(String email);
	
}
