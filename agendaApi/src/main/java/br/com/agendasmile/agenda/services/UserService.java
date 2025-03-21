package br.com.agendasmile.agenda.services;

import br.com.agendasmile.agenda.dto.CreateAdminDto;
import br.com.agendasmile.agenda.dto.CreateDentistDto;
import br.com.agendasmile.agenda.dto.ListDentistDto;
import br.com.agendasmile.agenda.dto.LoginUserDto;
import br.com.agendasmile.agenda.exceptions.NotFoundException;
import br.com.agendasmile.agenda.models.Office;
import br.com.agendasmile.agenda.models.User;
import br.com.agendasmile.agenda.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class UserService {
    @Autowired
    private UserRepository repository;

    public User createAdminUser(CreateAdminDto adminDto, Office office) {
        User user = new User();

        user.setFirst_name(adminDto.getFirstName());
        user.setLast_name(adminDto.getLastName());
        user.setEmail(adminDto.getEmail());
        user.setPassword(adminDto.getPassword());
        user.setOffice(office);
        user.setUser_type("admin");

        return this.repository.save(user);
    }
    
    public User loginUser(LoginUserDto user) throws Exception{

    	if(user.getEmail() == null || user.getPassword() == null) {
			throw new Exception("Preencha todos os campos corretamente!");
		}
    	
    	User result = this.repository.findByEmail(user.getEmail());
    	
    	if (result == null) {
            throw new NotFoundException("User not found");
        }
    	
    	if(!result.getPassword().equals(user.getPassword())) {
    		  throw new Exception("Password incorrect.");
    	}
    	
    	return result;
    }
    
    public boolean findByEmail(String email) throws Exception {
    	
    	if(email == null) {
    		throw new Exception("Preencha o email corretamente!");
    	}
    	
    	User result = this.repository.findByEmail(email);
    	System.out.println(email);
    	if(result != null) {
    		return true;
    	}else {

    		return false;
    	}
    }

    public User findByUUID(String uuid) throws NotFoundException {
        Optional<User> result = this.repository.findById(UUID.fromString(uuid));

        if (result.isEmpty()) {
            throw new NotFoundException("User not found");
        }

        return result.get();
    }

    public void createDentist(CreateDentistDto dentistDto, Office office) {
        User user = new User();

        user.setFirst_name(dentistDto.getFirstName());
        user.setLast_name(dentistDto.getLastName());
        user.setUser_type("dentist");
        user.setEmail(dentistDto.getEmail());
        user.setPassword(dentistDto.getPassword());
        user.setOffice(office);

        this.repository.save(user);
    }

    public ArrayList<ListDentistDto> getAllDentistsFromCompany(String companyUUID) {
        List<User> allDentists = this.repository.getAllDentistsFromCompany(UUID.fromString(companyUUID));

        ArrayList<ListDentistDto> dentistsDtos = new ArrayList<>();

        allDentists.forEach(dentist -> {
            dentistsDtos.add(new ListDentistDto(dentist));
        });

        return dentistsDtos;
    }
}
