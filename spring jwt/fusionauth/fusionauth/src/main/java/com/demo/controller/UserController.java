package com.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.model.AuthenticationRequest;
import com.demo.model.RegistrationRequest;
import com.inversoft.error.Errors;
import com.inversoft.rest.ClientResponse;

import io.fusionauth.client.FusionAuthClient;
import io.fusionauth.domain.api.LoginResponse;

import io.fusionauth.domain.api.user.RegistrationResponse;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private FusionAuthClient fusionAuthClient;
    
    public UserController(FusionAuthClient fusionAuthClient) {
        this.fusionAuthClient = fusionAuthClient;
    }

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody RegistrationRequest registrationRequest) {
        // Set your FusionAuth Application ID
       registrationRequest.setLoginId("<Mamatha>");
       
        // Make FusionAuth API call to register the user
       ClientResponse<RegistrationResponse, Errors> response = fusionAuthClient.register(null,null);

        if (response.wasSuccessful()) {
            return ResponseEntity.ok("User registered successfully");
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Registration failed");
        }
    }

    @PostMapping("/authenticate")
    public ResponseEntity<String> authenticateUser(@RequestBody AuthenticationRequest authenticationRequest) {
        // Set your FusionAuth Application ID
        authenticationRequest.setApplicationId("<Mamatha>");

        // Make FusionAuth API call to authenticate the user
      ClientResponse<LoginResponse, Errors> response = fusionAuthClient.login(null);

        if (response.wasSuccessful()) {
            return ResponseEntity.ok("User authenticated successfully");
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Authentication failed");
        }
    }
}

