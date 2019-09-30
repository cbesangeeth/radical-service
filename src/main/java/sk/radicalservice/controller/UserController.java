package sk.radicalservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import sk.radicalservice.domain.User;
import sk.radicalservice.repository.UserRepository;

import java.util.Optional;

@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping(value = "users/{id}")
    public User getUser(@PathVariable(value = "id") String id){
        Optional<User> user = userRepository.findById(id);
        return user.orElse(new User());
    }
}
