package br.com.agendasmile.agenda.controllers;

import br.com.agendasmile.agenda.dto.CreatePatientDto;
import br.com.agendasmile.agenda.exceptions.NotFoundException;
import br.com.agendasmile.agenda.models.Office;
import br.com.agendasmile.agenda.models.Patient;
import br.com.agendasmile.agenda.services.OfficeService;
import br.com.agendasmile.agenda.services.PatientService;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class PatientController {

    @Autowired
    private PatientService patientService;

    @Autowired
    private OfficeService officeService;

    @PostMapping("/api/office/{officeUuid}/patient")
    public void create(
            @Valid @RequestBody CreatePatientDto patientDto,
            @PathVariable String officeUuid,
            HttpServletResponse response
    ) {

        try {
            Office office = this.officeService.getByUUID(officeUuid);
            this.patientService.create(patientDto, office);
            response.setStatus(HttpServletResponse.SC_CREATED);
        } catch (NotFoundException e) {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
        }
    }

    @DeleteMapping("/api/office/{officeUuid}/patient/{uuid}")
    public void delete(@RequestParam String uuid, HttpServletResponse response) {
        try {
            this.patientService.delete(uuid);
        } catch (NotFoundException e) {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            return;
        }

        response.setStatus(HttpServletResponse.SC_CREATED);
    }
    
    @PostMapping("/api/patient/cpf/{cpf}")
    public boolean findPatientCpf(@RequestParam String cpf) {
    	Patient patient = this.patientService.findByCpf(cpf);
    	
    	if(patient != null) {
    		return true;
    	}else {
    		return false;
    	}
    }
    
    @PostMapping("/api/patient/email/{email}")
    public boolean findPatientEmail(@RequestParam String email) {
    	Patient patient = this.patientService.findByEmailNoException(email);
    	
    	if(patient != null) {
    		return true;
    	}else {
    		return false;
    	}
    }
}