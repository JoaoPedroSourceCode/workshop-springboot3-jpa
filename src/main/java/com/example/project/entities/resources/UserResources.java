package com.example.project.entities.resources;


import com.example.project.entities.User;
import com.example.project.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserResources {

    @Autowired
    private UserServices userServices;

    @GetMapping
    public ResponseEntity<List<User>> findAll() {
        List <User> users = userServices.findAll();

        return ResponseEntity.ok().body(users);
    }

    @GetMapping (value = "/{id}")
    public ResponseEntity<User> findById (@PathVariable long id) {
        User user = userServices.findById(id);

        return ResponseEntity.ok().body(user);
    }
}
