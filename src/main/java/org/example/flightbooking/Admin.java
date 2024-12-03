package org.example.flightbooking;

public class Admin extends Account{
    public Admin (String firstName, String lastName, String street, String zipCode, String state, String username,
                     String password, String email, long SSN, String secQuestion, String secAnswer, int secPIN) {
        super(firstName, lastName, street, zipCode, state, username, password, email, SSN, secQuestion, secAnswer, secPIN);
    }
}
