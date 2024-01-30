package controllers;

import models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;
import services.UserService;

@RestController
@RequestMapping("users")
public class UserController {

    @Autowired
    UserService userService;

    //GET User
    @GetMapping(value= "/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id){
        User foundUser = userService.getUserById(id);
        return new ResponseEntity<>(foundUser, HttpStatus.OK);
    }
    //CREATE user
    @PostMapping
    public ResponseEntity<User> createUser(@RequestParam String forename, @RequestParam String surname){
        User newUser = userService.saveUser(forename,surname);
        return new ResponseEntity<>(newUser, HttpStatus.CREATED);
    }

//  Increase user level
    @PatchMapping
    public ResponseEntity<User> updateLevel(Long id){
        userService.updateLevel(id);
        User userToUpdate = userService.getUserById(id);
        return new ResponseEntity<>(userToUpdate, HttpStatus.OK);
    }
}
