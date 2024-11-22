package org.example.flightbooking;

public class Customer extends Account {
    public Customer (String firstName, String lastName, String street,
                     String zipCode, String state, String username,
                    String password, String email, long SSN,
                     String secQuestion, String secAnswer, int secPIN) {

        super(firstName, lastName, street,
                zipCode, state, username,
                password, email, SSN,
                secQuestion, secAnswer, secPIN);

        System.out.println("Account Created!");
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
