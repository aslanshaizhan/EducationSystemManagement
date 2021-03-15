package iitu.kz.demo;

import iitu.kz.demo.config.SpringConfiguration;
import iitu.kz.demo.controller.UserController;
import iitu.kz.demo.dao.UserDao;
import iitu.kz.demo.entities.User;
import iitu.kz.demo.service.CoursePriceCalculatorService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;
import java.util.Scanner;

public class EducationManagement {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        while (true) {
            System.out.println("-------Main Menu-------");
            System.out.println("-------Select following options-------");
            System.out.println("1. Admin Manager");
            System.out.println("2. User or Student");
            System.out.println("0. Exit");

            int choice = in.nextInt();
            switch (choice) {
                case 1:
                    adminManager();
                    break;
                case 2:
                    userManage();
                    break;
                case 0:
                    System.out.println("Log Out");
                    break;
                default:
                    System.out.println("Incorrect choice");
                    break;
            }
        }
    }

    private static void adminManager(){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfiguration.class);
        CoursePriceCalculatorService coursePriceCalculatorService = new CoursePriceCalculatorService();
        User user = new User();
        UserDao userDao = new UserDao();
        Scanner in = new Scanner(System.in);
        while (true) {
            System.out.println("-------Admin Menu-------");
            System.out.println("-------Select following options-------");
            System.out.println("1. Add or Create User");
            System.out.println("2. Edit User");
            System.out.println("3. Delete User");
            System.out.println("4. List of registered users");
            System.out.println("0. Log Out");

            int choice = in.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Enter the first name:");
                    String firstname = in.next();
                    System.out.println("Enter the last name:");
                    String lastname = in.next();
                    System.out.println("Enter the email:");
                    String email = in.next();
                    user.setFirstname(firstname);
                    user.setLastname(lastname);
                    user.setEmail(email);
                    userDao.create(user);
                    System.out.println("You are registered successfully");
                    break;
                case 2:
                    System.out.println("Enter the new first name:");
                    String firstname1 = in.next();
                    System.out.println("Enter the new last name:");
                    String lastname1 = in.next();
                    System.out.println("Enter the new email:");
                    String email1 = in.next();
                    user.update(user.getId(), user);
                    userDao.update(user.getId(), user);
                    break;
                case 3:
                    System.out.println("Enter the first name:");
                    String firstname2 = in.next();
                    System.out.println("Enter the last name:");
                    String lastname2 = in.next();
                    System.out.println("Enter the email:");
                    String email2 = in.next();
                    user.delete(user.getId());
                    userDao.delete(user.getId());
                    break;
                case 4:
                    UserController userController = context.getBean("userController", UserController.class);
                    List<User> userList = userController.getUserByName("Aslan");
                    System.out.println(userController.getAll().getContent());
                    break;
                case 0:
                    System.out.println("Log Out");
                    break;
                default:
                    System.out.println("Incorrect choice");
                    break;
            }
        }
    }

    private static void userManage(){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfiguration.class);
        CoursePriceCalculatorService coursePriceCalculatorService = new CoursePriceCalculatorService();
        User user = new User();
        UserDao userDao = new UserDao();
        Scanner in = new Scanner(System.in);
        while (true) {
            System.out.println("-------User Menu-------");
            System.out.println("-------Select following options-------");
            System.out.println("1. Registration");
            System.out.println("2. Calculate course price");
            System.out.println("0. Log Out");

            int choice = in.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Enter the first name:");
                    String firstname = in.next();
                    System.out.println("Enter the last name:");
                    String lastname = in.next();
                    System.out.println("Enter the email:");
                    String email = in.next();
                    user.setFirstname(firstname);
                    user.setLastname(lastname);
                    user.setEmail(email);
                    userDao.create(user);
                    System.out.println("You are registered successfully");
                    break;
                case 2:
                    System.out.println("In which course you are studied(general/higher): ");
                    String ans = in.next();
                    if (ans == "general"){
                        System.out.println("Your price is: ");
                        coursePriceCalculatorService.calculateGeneralStudCourse();
                    }else {
                        System.out.println("Your price is: ");
                        coursePriceCalculatorService.calculateHigherStudCourse();
                    }
                    break;
                case 0:
                    System.out.println("Log Out");
                    break;
                default:
                    System.out.println("Incorrect choice");
                    break;
            }
        }
    }
}
