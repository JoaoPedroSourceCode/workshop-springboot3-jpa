package com.example.project.entities.resources;


import com.example.project.entities.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/users")
public class UserResources {

    @GetMapping
    public ResponseEntity<User> findAll() {
        User u = new User(1, "Arthur", "arthur@gmail.com", "password");
        return ResponseEntity.ok().body(u);
    }
}
