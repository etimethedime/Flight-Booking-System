package org.example.flightbooking;

import java.util.Scanner;

public class Runner {

}
   /* //for laughs and giggles
    public static void main(String[] args) {
        String firstName;
        String lastName;
        String street;
        String zipCode;
        String state;
        String username;
        String password;
        String email;
        String SSN;
        String secQuestion;
        String secAnswer;
        String secPIN;


        Scanner input = new Scanner (System.in);
        System.out.println("Welcome to ECM Flights! Are you an admin or customer? ");
        if (input.nextLine().equals("admin") || input.nextLine().equals("Admin"))  {
            Scanner input1 = new Scanner (System.in);
            System.out.println("Are you a new user? Or are you an existing user? Enter 1 or 2: ");
            switch (input1.nextInt()) {
                case 1:
                    Scanner registerInput = new Scanner(System.in);
                    System.out.println("Enter your First Name");
                    firstName = registerInput.nextLine();

                    System.out.println("Enter your Last Name");
                    lastName = registerInput.nextLine();

                    System.out.println("Enter your Street Address (Without the Zip Code): ");
                    street = registerInput.nextLine();

                    System.out.println("Enter your zip code: ");
                    zipCode = registerInput.nextLine();

                    System.out.println("Enter your State");
                    state = registerInput.nextLine();

                    System.out.println("Enter your username: ");
                    username = registerInput.nextLine();

                    System.out.println("Enter your password");
                    password = registerInput.nextLine();

                    System.out.println("Enter your email");
                    email = registerInput.nextLine();

                    System.out.println("Enter your SSN");
                    //make an if statement where it checks if the input follows the requirements using the string thingy
                    SSN = registerInput.next();

                    System.out.println("Enter your Security Question: ");
                    secQuestion = registerInput.nextLine();

                    System.out.println("Enter the answer to your security question. Make sure to remember it! ");
                    secAnswer = registerInput.nextLine();

                    System.out.println("Enter your security PIN");
                    secPIN = registerInput.next();

                    Admin admin1 = new Admin(firstName, lastName, street,
                            zipCode, state, username,
                            password, email, SSN,
                            secQuestion, secAnswer, secPIN);

                    break;

                case 2:
                    Scanner loginInput = new Scanner(System.in);
                    System.out.println("Enter a Username: ");
                    System.out.println("Enter a password: ");
                    break;
            }
        }

        else if (input.nextLine().equals("customer") || input.nextLine().equals("Customer")) {
            Scanner input1 = new Scanner (System.in);
            System.out.println("Are you a new user? Or are you an existing user? Enter 1 or 2: ");
            switch (input1.nextInt()) {
                case 1:
                    Scanner registerInput = new Scanner(System.in);
                    System.out.println("Enter your First Name");
                    firstName = registerInput.nextLine();

                    System.out.println("Enter your Last Name");
                    lastName = registerInput.nextLine();

                    System.out.println("Enter your Street Address (Without the Zip Code): ");
                    street = registerInput.nextLine();

                    System.out.println("Enter your zip code: ");
                    zipCode = registerInput.nextLine();

                    System.out.println("Enter your State");
                    state = registerInput.nextLine();

                    System.out.println("Enter your username: ");
                    username = registerInput.nextLine();

                    System.out.println("Enter your password");
                    password = registerInput.nextLine();

                    System.out.println("Enter your email");
                    email = registerInput.nextLine();

                    System.out.println("Enter your SSN");
                    //make an if statement where it checks if the input follows the requirements using the string thingy
                    SSN = registerInput.next();

                    System.out.println("Enter your Security Question: ");
                    secQuestion = registerInput.nextLine();

                    System.out.println("Enter the answer to your security question. Make sure to remember it! ");
                    secAnswer = registerInput.nextLine();

                    System.out.println("Enter your security PIN");
                    secPIN = registerInput.next();

                    Customer customer1 = new Customer(firstName, lastName, street,
                            zipCode, state, username,
                            password, email, SSN,
                            secQuestion, secAnswer, secPIN);

                case 2:
                    Scanner loginInput = new Scanner(System.in);
                    System.out.println("Enter a Username: ");
                    System.out.println("Enter a password: ");
                    break;
            }
        }
            //trying to merge
    }

}

 */
