package com.example.project.entities.resources;


import com.example.project.dtos.UserDTO;
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
    public ResponseEntity<List<UserDTO>> findAll() {
        List <UserDTO> usersDTO = userServices.findAll();
        return ResponseEntity.ok().body(usersDTO);
    }

    @GetMapping (value = "/{id}")
    public ResponseEntity<UserDTO> findById (@PathVariable long id) {
        UserDTO userDTO = userServices.findById(id);
        return ResponseEntity.ok().body(userDTO);
    }
}
