package rentCar.view;

import rentCar.controller.CarController;

import java.util.Scanner;

public class mainpage {

    public static Scanner scanner = new Scanner(System.in);
    public static CarController carController = new CarController();

    public static void main(String[] args) {

        /*
        DTO 용도
         - 계층 간 데이터 교환을 하기 위해 사용하는 객체
         - getter & setter 만 가진 클래스

        유저가 자신의 브라우저에서 데이터를 입력하여 form에 있는 데이터를 DTO에 넣어서 전송
        -> 해당 DTO를 받은 서버가 DAO를 이용하여 데이터베이스로 데이터를 집어넣습니다.

        */

        while ( true ){
            System.out.println("1.등록 2.~~~~~~");
            int ch = scanner.nextInt();
            if( ch == 1 ){
                carController.register();
            }

        }
    }

}
