package controllers;

import models.Login;
import models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import services.LoginService;

@RestController
public class LoginController {

    @Autowired
    LoginService loginService;

    //valid date new login details for user
    @GetMapping
    public ResponseEntity<String> checkUser(@RequestParam String email, @RequestParam String password){
//        check email
        if(loginService.containsAt(email)){
            if(loginService.checkIsNewEmail(email)){
    //          check password
                if(loginService.checkContainsNumber(password)  && loginService.checkPasswordLength(password) && loginService.checkContainsCapital(password)){
                    return new ResponseEntity<>("ok", HttpStatus.OK);
                }else{
                    return new ResponseEntity<>("password", HttpStatus.BAD_REQUEST);
                }
            }else{
                return new ResponseEntity<>("email in use", HttpStatus.BAD_REQUEST);
            }

        }else{
            return new ResponseEntity<>("@", HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping
    public void createUserLogin(@RequestParam String email, @RequestParam String password,@RequestParam Long id){
        loginService.saveUserLogin(email,password,id);
    }
}
