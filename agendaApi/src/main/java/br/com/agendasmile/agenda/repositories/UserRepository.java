package br.com.agendasmile.agenda.repositories;

import br.com.agendasmile.agenda.models.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.UUID;

public interface UserRepository extends CrudRepository<User, UUID> {

	User findByEmail(String email);

	@Query(value = "select u from User u inner join u.office o where o.id = ?1")
	List<User> getAllDentistsFromCompany(UUID officeId);
}
