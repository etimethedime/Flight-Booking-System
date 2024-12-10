package org.example.flightbooking;

public class Account {
    private String firstName;
    private String lastName;
    private String street;
    private String zipCode;
    private String state;
    private String username;
    private String password;
    private String email;
    private String  SSN;
    private String secQuestion;
    private String secAnswer;
    private String currentFlight;
    private String secPIN;

    public Account(){
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPasswords() {
        // input will ask secQuestion and ask for secAnswer
        // if input is correct (matches) it'll return password.
        return "PASSWORD: " + this.password + "\nSecurity PIN: " + this.secPIN + "\nSECURITY QUESTION: " + this.secQuestion +
                "\nSECURITY ANSWER: " + this.secAnswer;
    }

    public void setPassword(String password) {
        // input will ask secQuestion and ask for secAnswer
        // if input is correct (matches) it'll return password.
        this.password = password;
    }

    public String getAccountInfo() {
        //ask for secPIN
        return "ADDRESS: \nSTREET NAME: " + this.street + "\nSTATE: " + this.state + "\nZIPCODE: " + this.zipCode
                + "\nFULL NAME: " + this.firstName + " " + this.lastName + "\nUSERNAME: " + this.username +
                "\nEMAIL: " + this.email;
    }

    public String getSSN() {
        //ask for secPIN
        return SSN;
    }

    public String getCurrentFlight() {
        return currentFlight;
    }

    public void setCurrentFlight(String currentFlight) {
        this.currentFlight = currentFlight;
    }
}
