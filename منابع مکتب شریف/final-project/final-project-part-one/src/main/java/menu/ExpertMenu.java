package menu;

import util.ApplicationContext;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import static menu.BaseMenu.*;
import static menu.CustomerMenu.validationEmails;
import static menu.CustomerMenu.validationNames;
import static validation.Validation.generateRandomPassword;

public class ExpertMenu {

    public static void signInOrSignUpExpert(){
        System.out.println("1.sign In");
        System.out.println("2.sign up");


        try {
            int select = scanner.nextInt();
            scanner.nextLine();
            switch (select) {
                case 1 -> signInExpert();

                case 2 ->signUpExpert();

                default -> System.out.println("---Error404---");
            }
        } catch (
                Exception e) {
            e.printStackTrace();
            System.out.println("!!!WRONG!!!");

        }

    }

    public static void signInExpert() throws SQLException {
        boolean isTrue = true;
        while (isTrue) {
            System.out.println("enter username :");
            String username = scanner.next();

            System.out.println("enter password :");
            String password = scanner.next();

            expertOptional = ApplicationContext.getExpertService().login(username, password);


            if (expertOptional.isPresent()) {
             //   registerOrRefund();
                isTrue = false;
            } else {
                System.out.println("username and password UnCorrect !!!!\n");
                System.out.println("Please Again ... ");
                firstMenu();

            }

        }
    }

    public static void signUpExpert(){

        String FirstName = "ali";
        String validatedFirstName = String.valueOf(validationNames(FirstName));

        String LastName = "joe";
        String validatedLastName = String.valueOf(validationNames(LastName));

        String newEmailOFExpert = "";

        String emailOfExpert = "asadf@gmail.com";
        String validatedEmail = String.valueOf(validationEmails(emailOfExpert));

        List<String> list = ApplicationContext.getExpertService().showEmail();
        if (list.contains(validatedEmail)) {
            System.out.println("i have this email in data base ");
        } else {
            newEmailOFExpert = validatedEmail;
        }

        String userName = "htrhrth23";

        String password = generateRandomPassword();

        LocalDate timeOfSignIn = LocalDate.now();

        String imagePath = " D:\\عکس\\مکتب\\IMG_9979.JPG";
        try {
            BufferedImage image = ImageIO.read(new File(imagePath));
            byte[] imageBytes = (byte[]) image.getData().getDataElements
                    (0, 0, image.getWidth(), image.getHeight(), null);
            saveImageToFile(imageBytes,imagePath);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void saveImageToFile(byte[] imageBytes, String filePath) {
        try (FileOutputStream fileOutputStream = new FileOutputStream(filePath)) {
            fileOutputStream.write(imageBytes);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
