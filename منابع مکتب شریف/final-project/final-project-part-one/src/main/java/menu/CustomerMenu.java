
package menu;

import domain.userEntity.Customer;
import util.ApplicationContext;
import validation.RegexValidation;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import static menu.BaseMenu.*;
import static validation.Validation.generateRandomPassword;

public class CustomerMenu {
    public static Customer customerEntity = customerOptional.get();

    public static void signInOrSignUpCustomer() throws SQLException {


        System.out.println("1. sign up :");
        System.out.println("2. sign in :");


        try {
            int select = scanner.nextInt();
            scanner.nextLine();
            switch (select) {
                case 1 -> signUpCustomer();

                case 2 -> signInCustomer();

                default -> System.out.println("---Error404---");
            }
        } catch (
                Exception e) {
            e.printStackTrace();
            System.out.println("!!!WRONG!!!");

        }

    }

    public static void signInCustomer() throws SQLException {
        boolean isTrue = true;
        while (isTrue) {
            System.out.println("enter username :");
            String username = scanner.next();

            System.out.println("enter password :");
            String password = scanner.next();

            customerOptional = ApplicationContext.getCustomerService().login(username, password);


            if (customerOptional.isPresent()) {
                customerAfterSignIn();
                isTrue = false;
            } else {
                System.out.println("username and password UnCorrect !!!!\n");
                System.out.println("Please Again ... ");
                firstMenu();

            }

        }
    }

    public static void signUpCustomer() {

        String FirstName = "abbas";
        String validatedFirstName = String.valueOf(validationNames(FirstName));

        String LastName = "aaaa";
        String validatedLastName = String.valueOf(validationNames(LastName));

        String newEmailOFExpert = "";

        String emailOfExpert = "basjfryan@gmail.com";
        String validatedEmail = String.valueOf(validationEmails(emailOfExpert));

        List<String> list = ApplicationContext.getCustomerService().showEmail();
        if (list.contains(validatedEmail)) {
            System.out.println("i have this email");
        } else {
            newEmailOFExpert = validatedEmail;
        }

        String userName = "alfef526";

        String password = generateRandomPassword();

        LocalDate timeOfSignIn = LocalDate.now();

        Customer customer = new Customer(validatedFirstName, validatedLastName, newEmailOFExpert,
                userName, password, timeOfSignIn);

        ApplicationContext.getCustomerService().save(customer);
        System.out.println("customer added to data base !");
    }



    public static void customerAfterSignIn(){


    }


















    /////////////////////////////////////////////////////////validations////////////////////////////////////////////


    public static String validationNames(String firstName) {
        String firstname = null;
        boolean isTrue = true;
        while (isTrue) {
            firstname = scanner.nextLine();
            if (RegexValidation.validationName(firstname)) {
                isTrue = false;
            } else {
                System.out.println("put write word!!!!");
            }
        }
        return firstname;
    }

    public static String validationEmails(String email) {
        String emails = null;
        boolean isTrue = true;
        while (isTrue) {
            emails = scanner.nextLine();
            if (RegexValidation.validateEmail(emails)) {
                isTrue = false;
            } else {
                System.out.println("put write word!!!!");
            }
        }
        return emails;
    }
}

