package com.demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.servlet.Registration;

public class RegistrationResponse {

	 @JsonProperty("registration")
	    private Registration registration;

	    public Registration getRegistration() {
	        return registration;
	    }

	    public void setRegistration(Registration registration) {
	        this.registration = registration;
	    }
}
