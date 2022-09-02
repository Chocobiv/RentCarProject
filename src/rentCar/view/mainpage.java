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
                    case 1:         //회원가입(데이터 저장)
                        System.out.println(" ---------");
                        System.out.println("| 회원가입 |");
                        System.out.println(" ---------");

                        //개행문자 제거 - 운전면허증번호 입력을 안받고 넘어가는 문제 발생 -> 해결
                        scanner.nextLine();

                        //비밀번호 확인도 해야함 -> controller에서 (근데 DB에 비밀번호가 없음!)
                        System.out.print("운전면허증번호를 입력하세요 (예시.12-12-123456-12): ");
                        String inputDriveNum = scanner.next();
                        System.out.print("취득날짜를 입력하세요 (예시.2022-01-01): ");
                        String inputDriveDate = scanner.next();
                        System.out.print("생년월일을 입력하세요 (예시.2022-01-01): ");
                        String inputBirth = scanner.next();
                        System.out.print("고객명을 입력하세요 (예시.홍길동): ");
                        String inputName = scanner.next();
                        System.out.print("나이를 입력하세요 (예시.20): ");
                        int inputAge = scanner.nextInt();
                        System.out.print("주소를 입력하세요 (예시.인천): ");
                        String inputAddr = scanner.next();
                        System.out.print("전화번호를 입력하세요 (예시.010-1234-1234): ");
                        String inputPhoneNum = scanner.next();
                        System.out.print("이메일을 입력하세요 (예시.abc@abc.com): ");
                        String inputEmail = scanner.next();
                        //비밀번호 확인
                        System.out.print("비밀번호 확인 (전화번호 뒷자리): ");
                        String checkPW = scanner.next();

                        MemberDto member = new MemberDto(inputDriveNum,inputDriveDate,inputBirth,inputName,inputAge,inputAddr,inputPhoneNum,inputEmail);

                        //* 유효성 검사 - Controller에서 *//
                        carController.signup(member,checkPW);

                        break;
                    case 2:         //로그인
                        System.out.println(" -------");
                        System.out.println("| 로그인 |");
                        System.out.println(" -------");

                        System.out.print("회원님의 운전면허증번호를 입력하세요 (예시.12-12-123456-12): ");
                        String inputID = scanner.next();
                        System.out.print("비밀번호를 입력하세요 (핸드폰번호 뒷자리): ");
                        String inputPW = scanner.next();

                        String getName = carController.signin(inputID,inputPW);
                        if(getName!=null)   //정상 로그인
                            System.out.println(getName+"님 환영합니다.");     //로그인한 고객의 이름
                        else{               //운전면허증번호는 있지만 비밀번호가 틀린 경우
                            System.out.println("비밀번호가 틀렸습니다. 다시 확인해주세요.\n");
                        }
                        break;
                    case 3:         //운전면허증번호(PK) 찾기
                        System.out.println(" -----------");
                        System.out.println("| 아이디 찾기 |");
                        System.out.println(" -----------");

                        //고객명, 전화번호 이용
                        System.out.print("성함을 입력하세요 : ");
                        inputName = scanner.next();
                        System.out.print("가입시 입력한 전화번호를 입력하세요 (예시.010-1234-1234): ");
                        inputPhoneNum = scanner.next();
                        
                        //정상적으로 아이디(운전면허증번호)를 찾았을 경우 운전면허증번호를 반환
                        String getDriveNum = carController.findDriveNum(inputName,inputPhoneNum);
                        if(getDriveNum!=null)   //정상적으로 아이디 찾음
                            System.out.println(inputName+"님의 운전면허증번호는 "+getDriveNum+" 입니다.");
                        else{                   //사용자가 입력한 고객명과 전화번호와 동일한 아이디 못 찾음
                            System.out.println("고객 정보가 잘못되었습니다. 다시 확인해주세요.\n");
                        }

                        break;
                    case 4:
                        System.out.println(" -------------");
                        System.out.println("| 비밀번호 찾기 |");
                        System.out.println(" -------------");

                        //아이디(운전면허증번호), 이메일 이용
                        System.out.print("ID(운전면허증번호)를 입력하세요 : ");
                        inputName = scanner.next();
                        System.out.print("가입시 입력한 이메일을 입력하세요 (예시.abc@abc.com): ");
                        inputEmail = scanner.next();

                        //정상적으로 비밀번호(전화번호 뒷자리)를 찾았을 경우 비밀번호를 반환
                        String getPW = carController.findPassword(inputName,inputEmail);
                        if(getPW!=null)         //정상적으로 비밀번호 찾음
                            System.out.println("비밀번호는 "+getPW+" 입니다.");
                        else{                   //사용자가 입력한 아이디과 전화번호와 동일한 비밀번호 못 찾음
                            System.out.println("고객 정보가 잘못되었습니다. 다시 확인해주세요.\n");
                        }

                        break;
                    default:
                        System.out.println("선택할 수 없는 서비스 번호입니다.");
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
