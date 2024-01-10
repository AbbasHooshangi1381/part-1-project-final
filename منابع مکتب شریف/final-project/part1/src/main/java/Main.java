import domain.userEntity.Customer;
import domain.userEntity.Expert;
import util.ApplicationContext;
import util.EntityManagerFactoryProvider;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
import static validation.Validation.generateRandomPassword;

public class Main {
    public static void main(String[] args) throws SQLException {
         EntityManagerFactoryProvider.getEntityManagerFactory().createEntityManager();
        //  new Menu().firstMenu();


        // EXPERT//

/*        String FirstName = "abbas";
        String validatedFirstName = String.valueOf(validationFirstname(FirstName));

        String LastName = "aaaa";
        String validatedLastName = String.valueOf(validationFirstname(LastName));

        String emailOfExpert = "basjfryan@gmail.com";

        final List<Expert> experts = ApplicationContext.getExpertService().showEmail();
        if (experts.contains(emailOfExpert)) {
            System.out.println("i have this email");
        } else {
            String newEmailOFExpert = emailOfExpert;
        }

        String userName = "alfef526";

        String password = generateRandomPassword();

        LocalDate timeOfSignIn = LocalDate.now();*/

/*
        String imagePath = " D:\\عکس\\مکتب\\IMG_9979.JPG";
        try {
            BufferedImage image = ImageIO.read(new File(imagePath));
            byte[] imageBytes = (byte[]) image.getData().getDataElements(0, 0, image.getWidth(), image.getHeight(), null);
            saveImageToFile(imageBytes,imagePath);

        } catch (IOException e) {
            e.printStackTrace();
        }
*/






        //Customer//

      /*  String FirstNameOfCustomer="abbas";
        String validatedFirstNameOfCustomer= String.valueOf(validationFirstname(FirstNameOfCustomer));

        String LastNameOfCustomer="aaaa";
        String validatedLastNameOfCustomer= String.valueOf(validationFirstname(LastNameOfCustomer));

        String emailOfCustomer="basjfryan@gmail.com";

        List<Customer> customers = ApplicationContext.getCustomerService().showGmails();
        if (customers.contains(emailOfCustomer)){
            System.out.println("i have this email");
        }else {
            String newEmailOfCustomer=emailOfCustomer;
        }

        String userNameOfCustomer="alfef526";

        String passwordOfCustomer=generateRandomPassword();

        LocalDate timeOfSignInOfCustomer=LocalDate.now();
*/


        //workOfPrinciple
        //

    }

   /* public static void saveImageToFile(byte[] imageBytes, String filePath) {
        try (FileOutputStream fileOutputStream = new FileOutputStream(filePath)) {
            fileOutputStream.write(imageBytes);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }*/

}
