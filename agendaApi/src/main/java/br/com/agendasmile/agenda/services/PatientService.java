package br.com.agendasmile.agenda.services;

import br.com.agendasmile.agenda.dto.CreatePatientDto;
import br.com.agendasmile.agenda.exceptions.NotFoundException;
import br.com.agendasmile.agenda.models.Office;
import br.com.agendasmile.agenda.models.Patient;
import br.com.agendasmile.agenda.repositories.PatientRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.Optional;
import java.util.UUID;

@Service
public class PatientService {

    @Autowired
    private PatientRepository repository;

    public Patient create(CreatePatientDto patientDto, Office office) {
        Patient patient = new Patient();
        patient.setFirst_name(patientDto.getFirstName());
        patient.setLast_name(patientDto.getLastName());
        patient.setCpf(patientDto.getCpf());
        patient.setEmail(patientDto.getEmail());
        patient.setPhone_number(patientDto.getPhoneNumber());
        patient.setGender(patientDto.getGender());

        Date birthDate = Date.valueOf(patientDto.getBirthDate());
        patient.setBirth_date(birthDate);

        patient.setObs(patientDto.getObs());
        patient.setOffice(office);

        return this.repository.save(patient);
    }

    public void delete(String uuid) throws NotFoundException {
         Patient patient = this.findByUUID(uuid);
         this.repository.delete(patient);
    }

    public Patient findByUUID(String uuid) throws NotFoundException {
         Optional<Patient> result = this.repository.findById(UUID.fromString(uuid));

         if (result.isEmpty()) {
             throw new NotFoundException("User not found");
         }

         return result.get();
    }
    
    public Patient findByEmail(String email) throws NotFoundException {
        Patient result = this.repository.findByEmail(email);

        if (result == null) {
            throw new NotFoundException("User not found");
        }

        return result;
   }
    
    public Patient findByEmailNoException(String email) {
        Patient result = this.repository.findByEmail(email);

        return result;
   }
    
    public Patient findByCpf(String cpf) {
        Patient result = this.repository.findByCpf(cpf);

        return result;
   }
}
