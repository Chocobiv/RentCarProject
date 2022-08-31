package rentCar.view;

import rentCar.controller.CarController;
import rentCar.model.Dao.MemberDao;
import rentCar.model.Dto.MemberDto;

import java.util.Scanner;

public class mainpage {

    public static Scanner scanner = new Scanner(System.in);
    public static CarController carController = new CarController();

    public static void main(String[] args) {



        /*
        while ( true ){
            System.out.println("1.등록 2.~~~~~~");
            int ch = scanner.nextInt();
            if( ch == 1 ){
                carController.register();
            }else{
                return;
            }
        }*/

        while(true){
            System.out.println(" ------------------------------------------------------------------");
            System.out.println("| 렌트카 대여 서비스에 오신걸 환영합니다. 원하시는 서비스 번호를 입력해주세요. |");
            System.out.println(" ------------------------------------------------------------------");
            System.out.println("1. 일반 사용자  2. 관리자");
            int inputServiceNum1 = scanner.nextInt();
            if ( inputServiceNum1 == 1 ){    //일반 사용자 선택 시
                System.out.println("1. 회원가입  2. 로그인  3. 아이디 찾기  4. 비밀번호 찾기");
                int inputServiceNum2 = scanner.nextInt();

                switch (inputServiceNum2) {
                    case 1:
                        System.out.println(" ---------");
                        System.out.println("| 회원가입 |");
                        System.out.println(" ---------");

                        //개행문자 제거 - 운전면허증번호 입력을 안받고 넘어가는 문제 발생 -> 해결ㄴ
                        scanner.nextLine();

                        //입력하라는 말 써야함. 그리고 형식 예시도 필요
                        //비밀번호 확인도 해야함 -> controller에서 (근데 DB에 비밀번호가 없음!)
                        System.out.print("운전면허증번호를 입력하세요 (예시.12-12-123456-12): ");
                        String inputDriveNum = scanner.nextLine();
                        System.out.print("취득날짜를 입력하세요 (예시.2022-01-01): ");
                        String inputDriveDate = scanner.nextLine();
                        System.out.print("생년월일을 입력하세요 (예시.2022-01-01): ");
                        String inputBirth = scanner.nextLine();
                        System.out.print("고객명을 입력하세요 (예시.홍길동): ");
                        String inputName = scanner.nextLine();
                        System.out.print("나이를 입력하세요 (예시.20): ");
                        int inputAge = scanner.nextInt();
                        System.out.print("주소를 입력하세요 (예시.인천): ");
                        String inputAddr = scanner.nextLine();
                        System.out.print("전화번호를 입력하세요 (예시.010-1234-1234): ");
                        String inputPhoneNum = scanner.nextLine();
                        System.out.print("이메일을 입력하세요 (예시.abc@abc.com): ");
                        String inputEmail = scanner.nextLine();

                        MemberDto member = new MemberDto(inputDriveNum,inputDriveDate,inputBirth,inputName,inputAge,inputAddr,inputPhoneNum,inputEmail);
                        System.out.println( member.toString() );

                        //* 유효성 검사 - Controller에서 *//*
                        carController.signup();

                        //* 입력받은 값 Dto에 담아서 Dao로 *//*
                        boolean result = MemberDao.getmemberDao().signup( member );
                        if( result ) {
                            System.out.println("성공");
                        }
                        else { System.out.println("실패"); }


                        break;
                    case 2:
                        System.out.println("로그인");
                        break;
                    case 3:
                        System.out.println("아이디 찾기");
                        break;
                    case 4:
                        System.out.println("비밀번호 찾기");
                        break;
                    default:
                        System.out.println("알맞는 서비스 번호를 입력해주세요.");
                        break;
                }
                
            }else if(inputServiceNum1 ==2){  //관리자 선택 시
                System.out.println("2번 선택");
                return;
            }else{
                System.out.println("알맞는 서비스 번호를 입력해주세요.");
            }
        }


    }
}
