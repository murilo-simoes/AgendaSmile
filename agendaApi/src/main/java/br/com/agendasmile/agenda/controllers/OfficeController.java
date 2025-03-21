package br.com.agendasmile.agenda.controllers;

import br.com.agendasmile.agenda.dto.CreateAdminDto;
import br.com.agendasmile.agenda.dto.CreateOfficeDto;
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
    public void store(@Valid @RequestBody CreateOfficeDto officeDto) {
        Office officeCreated = this.officeService.createOffice(officeDto);
        User adminUserCreated = this.userService.createAdminUser(officeDto.getAdmin(), officeCreated);

        this.officeService.setOfficeOwner(adminUserCreated.getId().toString(), officeCreated.getId().toString());
    }
}
