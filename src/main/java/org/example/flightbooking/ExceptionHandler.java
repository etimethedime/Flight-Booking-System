package org.example.flightbooking;

public class ExceptionHandler {
    public static String validateRegistrationInput(String Username, String Password, String FirstName, String LastName,
                                                    String Email, String Address, String SSN, String SecurityQuestion,
                                                    String SecurityAnswer) {
        // Check if any field is null or empty
        if (Username == null || Username.trim().isEmpty()) return "Username cannot be empty.";
        if (Password == null || Password.length() < 8) return "Password must be at least 8 characters long.";
        if (FirstName == null || FirstName.trim().isEmpty()) return "First name cannot be empty.";
        if (LastName == null || LastName.trim().isEmpty()) return "Last name cannot be empty.";
        if (Email == null || !Email.matches("^[^@\\s]+@[^@\\s]+\\.[^@\\s]+$")) return "Invalid email format.";
        if (Address == null || Address.trim().isEmpty()) return "Address cannot be empty.";
        if (SSN == null || !SSN.matches("^\\d{3}-\\d{2}-\\d{4}$")) return "Invalid SSN format. Use XXX-XX-XXXX.";
        if (SecurityQuestion == null || SecurityQuestion.trim().isEmpty()) return "Security question cannot be empty.";
        if (SecurityAnswer == null || SecurityAnswer.trim().isEmpty()) return "Security answer cannot be empty.";

        // If all validations pass, return null
        return null;
    }
    public static String AdminValidateRegistrationInput(String employeeId, String username, String password, String firstName, String lastName) {
        // Check if any field is null or empty
        if (employeeId == null || !employeeId.matches("^\\d{3}-\\d{2}-\\d{4}$")) return "Invalid SSN format. Use XXX-XX-XXXX.";
        if (username == null || username.trim().isEmpty()) return "Username cannot be empty.";
        if (password == null || password.length() < 8) return "Password must be at least 8 characters long.";
        if (firstName == null || firstName.trim().isEmpty()) return "First name cannot be empty.";
        if (lastName == null || lastName.trim().isEmpty()) return "Last name cannot be empty.";

        // If all validations pass, return null
        return null;
    }
}
