package br.com.agendasmile.agenda.services;

import br.com.agendasmile.agenda.dto.CreateDentistDto;
import br.com.agendasmile.agenda.dto.LoginUserDto;
import br.com.agendasmile.agenda.exceptions.NotFoundException;
import br.com.agendasmile.agenda.models.Office;
import br.com.agendasmile.agenda.models.User;
import br.com.agendasmile.agenda.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class UserService {
    @Autowired
    private UserRepository repository;

    public User createAdminUser(User user) {
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
}
