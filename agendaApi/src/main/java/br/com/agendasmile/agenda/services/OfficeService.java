package br.com.agendasmile.agenda.services;

import br.com.agendasmile.agenda.models.Office;
import br.com.agendasmile.agenda.models.User;
import br.com.agendasmile.agenda.repositories.OfficeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
