package iitu.kz.demo.service;

import java.util.Scanner;

public class CoursePriceCalculatorService {
    Scanner in = new Scanner(System.in);

    public void calculateGeneralStudCourse(){
        int price = 40000;
        System.out.println("Do you want to study more than 6 month(Yes/No): ");
        String answer = in.next();
        System.out.println("Please enter the duration that you want to study: ");
        int duration = in.nextInt();
        if (answer == "Yes" && duration > 5){
            double total = (price * duration) * 0.15;
            System.out.println("Total Price = " + total);
            System.out.println("You won bonus to study!");
        }else{
            double total = price * duration;
            System.out.println("Total Price = " + total);
        }
    }

    public void calculateHigherStudCourse(){
        int price = 60000;
        System.out.println("Do you want to study more than 3 month(Yes/No): ");
        String answer = in.next();
        System.out.println("Please enter the duration that you want to study: ");
        int duration = in.nextInt();
        if (answer == "Yes" && duration > 3){
            double total = (price * duration) * 0.15;
            System.out.println("Total Price = " + total);
            System.out.println("You won bonus to study!");
        }else{
            double total = price * duration;
            System.out.println("Total Price = " + total);
        }
    }
}
