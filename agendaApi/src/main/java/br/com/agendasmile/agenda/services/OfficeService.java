package br.com.agendasmile.agenda.services;

import br.com.agendasmile.agenda.dto.CreateOfficeDto;
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

    public Office createOffice(CreateOfficeDto officeDto) {
        Office office = new Office();

        office.setName(officeDto.getName());
        return this.repository.save(office);
    }

    public void setOfficeOwner(String ownerUuid, String officeUuid) {
        this.repository.setOfficeOwnerUuid(
                ownerUuid,
                officeUuid
        );
    }

    public Office getByUUID(String uuid) throws NotFoundException {
        Optional<Office> result = this.repository.findById(UUID.fromString(uuid));

        if (result.isEmpty()) {
            throw new NotFoundException("Office not found");
        }

        return result.get();
    }
}
