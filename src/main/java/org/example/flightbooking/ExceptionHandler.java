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
    public static String adminValidateRegistrationInput(String Employee_Id, String Username, String Password, String confirmPassword,
                                                        String FirstName, String LastName) {
        // Check if any field is null or empty
        if (Employee_Id == null || Employee_Id.length() < 9) return "Employee ID must be at least 9 characters long";
        if (Username == null || Username.trim().isEmpty()) return "Username cannot be empty.";
        if (Password == null || Password.length() < 8) return "Password must be at least 8 characters long.";
        if (confirmPassword == null || !confirmPassword.equals(Password)) return "Match the previously entered password to confirm password";
        if (FirstName == null || FirstName.trim().isEmpty()) return "First name cannot be empty.";
        if (LastName == null || LastName.trim().isEmpty()) return "Last name cannot be empty.";

        // If all validations pass, return null
        return null;
    }


}