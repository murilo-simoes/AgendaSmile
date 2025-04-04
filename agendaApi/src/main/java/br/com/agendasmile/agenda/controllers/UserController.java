package br.com.agendasmile.agenda.controllers;

import br.com.agendasmile.agenda.dto.CreateDentistDto;
import br.com.agendasmile.agenda.dto.ListDentistDto;
import br.com.agendasmile.agenda.dto.LoginUserDto;
import br.com.agendasmile.agenda.exceptions.NotFoundException;
import br.com.agendasmile.agenda.models.Office;
import br.com.agendasmile.agenda.models.User;
import br.com.agendasmile.agenda.services.OfficeService;
import br.com.agendasmile.agenda.services.UserService;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private OfficeService officeService;

    @PostMapping("/api/office/{officeUuid}/dentist")
    public void createDentist(
            @Valid @RequestBody CreateDentistDto dentistDto,
            @PathVariable String officeUuid,
            HttpServletResponse response
    ) {
        try {
            Office office = this.officeService.getByUUID(officeUuid);
            this.userService.createDentist(dentistDto, office);
            response.setStatus(HttpServletResponse.SC_CREATED);
        } catch (NotFoundException e) {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
        }
    }

    @GetMapping("/api/office/{officeUuid}/dentist")
    public ResponseEntity<ArrayList<ListDentistDto>> listAllDentists(@PathVariable String officeUuid) {
        try {
            this.officeService.getByUUID(officeUuid);
            ArrayList<ListDentistDto> dentists = this.userService.getAllDentistsFromCompany(officeUuid);
            return ResponseEntity.ok(dentists);
        } catch (NotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }
    
    @PostMapping("/api/user/login")
    public User loginUser(@Valid @RequestBody LoginUserDto user, HttpServletResponse response) throws Exception {
    	try {
    		User login_user = this.userService.loginUser(user);
    		
    		return login_user;
    	}catch(NotFoundException e) {
    		response.setStatus(HttpServletResponse.SC_NOT_FOUND);
    	}
		return null;
    }
    
    @PostMapping("/api/user/{email}")
    public boolean existUser(@PathVariable String email, HttpServletResponse response) throws Exception {
    	boolean email_founded = this.userService.findByEmail(email);
    		
    	return email_founded;

    }
}
