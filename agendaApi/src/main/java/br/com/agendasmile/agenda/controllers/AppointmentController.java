package br.com.agendasmile.agenda.controllers;

import br.com.agendasmile.agenda.dto.CreateAppointmentDto;
import br.com.agendasmile.agenda.exceptions.NotFoundException;
import br.com.agendasmile.agenda.models.Appointment;
import br.com.agendasmile.agenda.models.Patient;
import br.com.agendasmile.agenda.models.User;
import br.com.agendasmile.agenda.services.AppointmentService;
import br.com.agendasmile.agenda.services.PatientService;
import br.com.agendasmile.agenda.services.UserService;
import jakarta.servlet.http.HttpServletResponse;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class AppointmentController {

    @Autowired
    private AppointmentService appointmentService;

    @Autowired
    private UserService userService;

    @Autowired
    private PatientService patientService;

    @PostMapping("/api/appointment/doctor/{doctorId}/patient/{patientEmail}")
    public void create(
            @RequestBody CreateAppointmentDto appointmentDto,
            @PathVariable String doctorId,
            @PathVariable String patientEmail,
            HttpServletResponse response
    ) {
        try {
            Patient patient = this.patientService.findByEmail(patientEmail);
            User doctor = this.userService.findByUUID(doctorId);

            this.appointmentService.create(doctor, patient, appointmentDto);
        } catch (NotFoundException e) {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
        }
    }
    
    @GetMapping("/api/appointment/office/{officeId}")
    public List<Appointment> list(@PathVariable String officeId){
    	return this.appointmentService.getAllAppointments(officeId);
    }
    

}
