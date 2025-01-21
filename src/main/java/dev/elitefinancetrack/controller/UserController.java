package dev.elitefinancetrack.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @GetMapping("/")
    public String doWelcome(){
        return "Welcome Back!";
    }

    @PostMapping("/userName")
    public ResponseEntity<String> getUserName(@RequestBody String userName){
        String responseMessage = "Hello "+ userName;
        return new ResponseEntity<>(responseMessage, HttpStatus.OK);
    }
}
