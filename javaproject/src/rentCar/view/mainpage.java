package rentCar.view;

import rentCar.controller.CarController;

import java.util.Scanner;

public class mainpage {

    public static Scanner scanner = new Scanner(System.in);
    public static CarController carController = new CarController();

    public static void main(String[] args) {
        while ( true ){
            System.out.println("1.등록 2.~~~~~~");
            int ch = scanner.nextInt();
            if( ch == 1 ){
                carController.register();
            }

        }
    }

}
