package br.com.agendasmile.agenda.services;

import br.com.agendasmile.agenda.exceptions.NotFoundException;
import br.com.agendasmile.agenda.models.User;
import br.com.agendasmile.agenda.repositories.UserRepository;
import org.aspectj.weaver.ast.Not;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import javax.swing.text.html.Option;
import java.net.http.HttpConnectTimeoutException;
import java.util.Optional;
import java.util.UUID;

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

    public User findByUUID(String uuid) throws NotFoundException {
        Optional<User> result = this.repository.findById(UUID.fromString(uuid));

        if (result.isEmpty()) {
            throw new NotFoundException("User not found");
        }

        return result.get();
    }
}
