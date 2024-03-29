
package menu;

import domain.userEntity.Admin;
import domain.userEntity.Customer;
import domain.userEntity.Expert;
import util.ApplicationContext;

import java.sql.SQLException;
import java.util.Optional;
import java.util.Scanner;

import static menu.AdminMenu.firstMenuOfAdmin;
import static menu.CustomerMenu.signInOrSignUpCustomer;
import static menu.ExpertMenu.signInOrSignUpExpert;

public class BaseMenu {
    public static Optional<Customer> customerOptional;
    public static Optional<Expert> expertOptional;
    public static Optional<Admin> adminOptional;
    public static final Scanner scanner = new Scanner(System.in);

    public static void firstMenu() throws SQLException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n*************************************************************");
        System.out.println("|                  WELCOME TO FINAL-PROJECT                   |");
        System.out.println("*************************************************************\n");
        System.out.println("1- admin");
        System.out.println("2- Customer");
        System.out.println("3- Expert");
        System.out.println("4- Exit\n");
        System.out.println("Enter your select:");

        try {
            int select = scanner.nextInt();
            scanner.nextLine();
            switch (select) {
                case 1 -> signInAdmin();
                case 2 -> signInOrSignUpCustomer();
                case 3 -> signInOrSignUpExpert();
                case 4 -> {
                    System.out.println("exit");
                    break;
                }
                default -> System.out.println("---Eror404---");
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("!!!WRONG!!!");
        }


}



    public static void signInAdmin() throws SQLException {
        boolean isTrue = true;
        while (isTrue) {
            System.out.println("enter username :");
            String username = scanner.next();

            System.out.println("enter password :");
            String password = scanner.next();

            adminOptional = ApplicationContext.getAdminService().login(username, password);


            if (adminOptional.isPresent()) {
                firstMenuOfAdmin();
                isTrue = false;
            } else {
                System.out.println("username and password UnCorrect !!!!\n");
                System.out.println("Please Again ... ");
                firstMenu();

            }

        }
    }













}

