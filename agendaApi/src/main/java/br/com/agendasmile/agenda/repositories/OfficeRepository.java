package br.com.agendasmile.agenda.repositories;

import br.com.agendasmile.agenda.models.Office;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface OfficeRepository extends CrudRepository<Office, UUID> {
    @Query(nativeQuery = true, value= "UPDATE office set admin_id = ?1 where id = ?2")
    @Transactional
    @Modifying
    void setOfficeOwnerUuid(String ownerUuid, String officeUuid);
}
