package org.example.flightbooking;

public class Customer extends Account {
    public Customer (String firstName, String lastName, String street, String zipCode, String state, String username,
                    String password, String email, long SSN, String secQuestion, String secAnswer, String currentFlight, int secPIN) {
        super(firstName, lastName, street, zipCode, state, username, password, email, SSN, secQuestion, secAnswer, currentFlight, secPIN);
    }

}
