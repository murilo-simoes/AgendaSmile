package br.com.agendasmile.agenda.services;

import br.com.agendasmile.agenda.exceptions.NotFoundException;
import br.com.agendasmile.agenda.models.Office;
import br.com.agendasmile.agenda.models.User;
import br.com.agendasmile.agenda.repositories.OfficeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class OfficeService {

    @Autowired
    private OfficeRepository repository;

    /**
     * Create an office for a specific user.
     */
    public Office createOffice(Office office) {
        return this.repository.save(office);
    }

    public Office getByUUID(String uuid) throws NotFoundException {
        Optional<Office> result = this.repository.findById(UUID.fromString(uuid));

        if (result.isEmpty()) {
            throw new NotFoundException("Office not found");
        }

        return result.get();
    }
}
