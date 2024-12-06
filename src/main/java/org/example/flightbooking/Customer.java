package org.example.flightbooking;

public class Customer extends Account {
    public Customer (String firstName, String lastName, String street,
                     String zipCode, String state, String username,
                    String password, String email, String SSN,
                     String secQuestion, String secAnswer, String secPIN) {

        super(firstName, lastName, street,
                zipCode, state, username,
                password, email, SSN,
                secQuestion, secAnswer, secPIN);
    }

    void logIn (String username, String password) {
        if (getUsername().equals(username)){
            System.out.println("Login Successful!");
        }
        else {
            System.out.println("Incorrect password. Try again.");
        }
    }

}
