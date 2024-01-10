package menu;

import domain.serviceEntity.Service;
import domain.serviceEntity.SubService;
import util.ApplicationContext;

import java.util.Optional;

import static menu.BaseMenu.scanner;

public class AdminMenu {

    public static void firstMenuOfAdmin() {
        System.out.println("1. register service or sub service :");
        System.out.println("2. see all service that we have !");
        System.out.println("3. edit description of subService :");
        System.out.println("4. edit price of subService :");


        try {
            int select = scanner.nextInt();
            scanner.nextLine();
            switch (select) {
                case 1 -> registerServiceOrSubService();

                case 2 -> allService();

                case 3 ->changeDescription();

                case 4->

                default -> System.out.println("---Error404---");
            }
        } catch (
                Exception e) {
            e.printStackTrace();
            System.out.println("!!!WRONG!!!");

        }

    }

    public static void registerServiceOrSubService() {

        System.out.println("1. register service :");
        System.out.println("2. register sub service :");


        try {
            int select = scanner.nextInt();
            scanner.nextLine();
            switch (select) {
                case 1 -> registerService();

                case 2 -> registerSubService();

                default -> System.out.println("---Error404---");
            }
        } catch (
                Exception e) {
            e.printStackTrace();
            System.out.println("!!!WRONG!!!");

        }


    }

    public static void registerService() {
        Service service = new Service("electric");
        ApplicationContext.getServiceService().save(service);
        System.out.println("service added to data base ! ");
    }

    public static void registerSubService() {
        SubService subService = new SubService();

        System.out.println("enter the id of service you want to add subService for it :");
        Integer id = scanner.nextInt();

        Service service = ApplicationContext.getServiceService().findById(id).orElse(null);

        if (service == null) {
            System.out.println("you dont have this service");
        } else {


            subService.setSubServiceName("bargh");
            subService.setDescription("frfffffffffffff");
            subService.setPrice(5256.00);
            subService.setService(service);

            ApplicationContext.getSubServiceService().save(subService);
            System.out.println("sub service added to data base ! ");

        }
    }
    public static void allService(){
        System.out.println("all service is : ");
        ApplicationContext.getSubServiceService().findAll().forEach(System.out::println);

        System.out.println("all sub service is : ");
        ApplicationContext.getSubServiceService().findAll().forEach(System.out::println);
    }

    public static void changeDescription(){
        System.out.println("enter the id of subService that you want to change : ");
        Integer id =scanner.nextInt();

        System.out.println("write your new description ");
        String newDescription=scanner.nextLine();

        ApplicationContext.getSubServiceService().updateDescriptionField(id,newDescription);
        System.out.println("you change the description successfully !");
    }

    public static void changePrice(){
        System.out.println("enter the id of subService that you want to change : ");
        Integer id =scanner.nextInt();

        System.out.println("write your new price ");
        Double newPrice=scanner.nextDouble();

        ApplicationContext.getSubServiceService().updatePriceField(id,newPrice);
        System.out.println("you change the price successfully !");
    }
}