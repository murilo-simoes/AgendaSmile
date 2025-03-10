package br.com.agendasmile.agenda.services;

import br.com.agendasmile.agenda.models.User;
import br.com.agendasmile.agenda.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository repository;

    /**
     * Create an admin user. An admin user will manage a specific Office.
     */
    public User createAdminUser(User user) {
        user.setUser_type("admin");
        return this.repository.save(user);
    }
}
