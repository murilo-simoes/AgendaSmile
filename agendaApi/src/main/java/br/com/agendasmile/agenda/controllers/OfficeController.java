package br.com.agendasmile.agenda.controllers;

import br.com.agendasmile.agenda.models.Office;
import br.com.agendasmile.agenda.models.User;
import br.com.agendasmile.agenda.services.OfficeService;
import br.com.agendasmile.agenda.services.UserService;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OfficeController {

    @Autowired
    private OfficeService officeService;

    @Autowired
    private UserService userService;

    @PostMapping(path = "/api/office")
    public void store(@Valid @RequestBody Office office, HttpServletResponse response) {
        User officeOwner = this.userService.createAdminUser(office.getAdmin());
        Office officeCreated = this.officeService.createOffice(office);
    }
}
