package br.com.agendasmile.agenda.services;

import br.com.agendasmile.agenda.dto.CreateAppointmentDto;
import br.com.agendasmile.agenda.models.Appointment;
import br.com.agendasmile.agenda.models.Patient;
import br.com.agendasmile.agenda.models.User;
import br.com.agendasmile.agenda.repositories.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class AppointmentService {

    @Autowired
    private AppointmentRepository repository;

    public void create(User doctor, Patient patience, CreateAppointmentDto appointmentDto) {
        Appointment appointment = new Appointment();

        appointment.setPatient(patience);
        appointment.setUser(doctor);
        appointment.setTitle(appointmentDto.getTitle());
        appointment.setDescription(appointmentDto.getDescription());
        appointment.setOffice(
                doctor.getOffice()
        );

        appointment.setAppointment_type(appointmentDto.getType());

        Timestamp startDateTime = Timestamp.valueOf(
                appointmentDto.getStartDateTime()
        );

        Timestamp endDateTime = Timestamp.valueOf(
                appointmentDto.getEndDateTime()
        );

        appointment.setStart_time(startDateTime);
        appointment.setEnd_time(endDateTime);

        this.repository.save(appointment);
    }
    
    public List<Appointment> getAllAppointments(String officeId) {
    	 Iterable<Appointment> iterable = this.repository.findAllByOfficeId(UUID.fromString(officeId));
    	 List<Appointment> appointments = StreamSupport
    	        .stream(iterable.spliterator(), false)
    	        .collect(Collectors.toList());
    	    return appointments;
    }
}
