package rentCar.view;

import rentCar.controller.CarController;
import rentCar.controller.MemberController;
import rentCar.controller.RentalController;
import rentCar.model.Dto.CarDto;
import rentCar.model.Dto.LoginDto;
import rentCar.model.Dto.MemberDto;
import rentCar.model.Dto.RentalDto;

import java.util.ArrayList;
import java.util.Scanner;

public class mainpage {

    public static Scanner scanner = new Scanner(System.in);
    public static MemberController memberController = new MemberController();
    public static CarController carController = new CarController();
    public static RentalController rentalController = new RentalController();
    public static LoginDto logindto = new LoginDto();

    //렌탈 대여 가능한 차량 목록 메소드 - 일반사용자 메뉴
    public static void rentalList(){
        System.out.println(" --------------");
        System.out.println("| 렌탈 가능 목록 |");
        System.out.println(" --------------");

        //대여 가능한 차량 리스트
        ArrayList<CarDto> carList = rentalController.rentalList();

        System.out.println(" ===============================================================================");
        System.out.println("|  차량번호  | 이름 | 차종류 | 색상 | 연료 | 차 옵션 | 승차인원수 | 상세정보 | 일일대여비용 |");
        System.out.println(" ===============================================================================");
        for(CarDto car : carList){
            System.out.printf("| %s |%s| %s | %s | %s | %s | %d명\t|\t%s\t|\t%d\t|\n",
                    car.getCarNum(),car.getCarName(),car.getCarType(),car.getCarColor(),
                    car.getCarFuel(),car.getCarOption(),car.getCarPersonnel(),car.getCarDetail(),car.getCost());
        }


    }

    //렌탈 중인 차량 목록 - 일반 사용자 메뉴
    public static boolean rentalCarList(){
        System.out.println(" --------------");
        System.out.println("| 렌탈 중인 차량 |");
        System.out.println(" --------------");

        ArrayList<String> carList = rentalController.rentalCarList(logindto.getId());

        if(carList!=null) {
            System.out.println(" ===========");
            System.out.println("|  차량번호  |");
            System.out.println(" ===========");
            for (String car : carList)
                System.out.printf("| %s |\n", car);
            System.out.println();
            return true;
        }
        return false;
    }

    //해당 아이디가 렌트한 차량번호를 입력했는지 여부 확인 메소드 - 일반 사용자 메뉴
    public static boolean isRentedCar(String inputCarNum){
        ArrayList<String> carList = rentalController.rentalCarList(logindto.getId());
        boolean result=false;                //해당 아이디가 렌트한 차량번호를 입력했는지 여부를 확인하는 변수
        for (String car : carList){
            if(car.equals(inputCarNum)){     //해당 아이디가 렌트한 차량번호를 입력했으면
                result = true;
                return result;
            }
        }
        System.out.println("대여 중인 차량번호를 입력해주세요.\n");
        return result;
    }

    //렌탈대여 메소드 - 일반사용자 메뉴
    public static void rentalService(){
        System.out.println(" --------");
        System.out.println("| 렌탈대여 |");
        System.out.println(" --------");

        System.out.print("대여 시작일을 입력하세요 (예시.2022-01-01): ");
        String inputStartDay = scanner.next();
        System.out.print("대여 기간을 입력하세요 (예시.7): ");
        String inputPeriod = scanner.next();
        String inputCarNum = scanner.nextLine();        //Scanner 씹힘 방지를 위함
        System.out.print("차량 번호를 입력하세요 (예시.00아 2222): ");
        inputCarNum = scanner.nextLine();
        //일단 결제와 보험은 임의의 값으로 입력
        //System.out.print("결제 번호를 입력하세요 (예시.LPG): ");      //결제번호 구현시, 결제테이블에 있는지 여부 체크와 중복체크해야함!
        //String inputPaymentNum = scanner.next();
        //System.out.print("보험 번호를 입력하세요 (예시.에어백): ");
        //String inputInsuranceNum = scanner.next();
        RentalDto rental = new RentalDto(inputStartDay,inputPeriod, LoginDto.getId(),inputCarNum,"00001","00000004");

        rentalController.rental(rental);
    }

    //렌탈 차량 등록 - 관리자 메뉴
    public static void registerCar(){
        System.out.println(" --------------");
        System.out.println("| 렌탈 차량 등록 |");
        System.out.println(" --------------");

        String inputCarNum = scanner.nextLine();        //scanner 씹힘 방지
        System.out.print("차량 번호를 입력하세요 (예시.00아 2222): ");
        inputCarNum = scanner.nextLine();
        System.out.print("렌트카 이름을 입력하세요 (예시.k7): ");
        String inputCarName = scanner.next();
        System.out.print("차 종류를 입력하세요 (예시.대형): ");
        String inputCarType = scanner.next();
        System.out.print("색상을 입력하세요 (예시.그레이): ");
        String inputCarColor = scanner.next();
        System.out.print("연료를 입력하세요 (예시.LPG): ");
        String inputcarFuel = scanner.next();
        System.out.print("차량 옵션을 입력하세요 (예시.에어백): ");
        String inputCarOption = scanner.next();
        System.out.print("승차 인원수를 입력하세요 (예시.5): ");
        int inputCarPersonnel = scanner.nextInt();
        System.out.print("지역을 입력하세요 (예시.서울): ");
        String inputCarRegion = scanner.next();
        System.out.print("상세정보를 입력하세요 : ");
        String inputCarDetail = scanner.next();
        System.out.print("일일 대여 비용을 입력하세요 (예시.80000): ");
        int inputCost = scanner.nextInt();

        CarDto car = new CarDto(inputCarNum, inputCarName, inputCarType, inputCarColor, inputcarFuel, inputCarOption, inputCarPersonnel, inputCarRegion, inputCarDetail, inputCost, "대여가능");
        carController.resisterCar(car);
    }

    //렌탈 현황 - 관리자 메뉴
    public static void rentalStatus(){
        System.out.println(" ----------");
        System.out.println("| 대여 현황 |");
        System.out.println(" ----------");

        ArrayList<RentalDto> rentalList = rentalController.rentalStatus();
        if(rentalList!=null) {
            System.out.println(" ==========================================================================");
            System.out.println("|\t운전면허증번호\t|  차량번호  | 대여 시작일 | 대여기간 | 결제번호 | 보험등록번호 |");
            System.out.println(" ==========================================================================");
            for (RentalDto rental : rentalList)
                System.out.printf("| %s | %s | %s | %s | %s | %s |\n", rental.getDriverNum(),rental.getCarNum(),rental.getRentalStartDay(),rental.getRentalPeriod(),rental.getPaymentNum(),rental.getInsuranceNum());
            System.out.println();
        }
    }

    //로그인한 일반사용자
    public static void logindedMember(){
        System.out.println("\n메뉴 : 1.렌탈대여  2.렌탈반납  3.내 정보  4.로그아웃");
        System.out.print("선택 : ");
        int menu = scanner.nextInt();
        switch (menu){
            case 1:         //렌탈대여
                //렌탈 가능한 목록 보여주기
                rentalList();
                rentalService();
                break;
            case 2:         //렌탈반납
                try {
                    boolean existRentCar = rentalCarList();

                    if (existRentCar) {         //해당 아이디로 렌트한 차량이 있으면
                        String inputCarNum = scanner.nextLine();        //Scanner 씹힘 방지를 위함
                        System.out.print("차량 번호를 입력하세요 (예시.00아 2222): ");
                        inputCarNum = scanner.nextLine();

                        boolean isExistCar = isRentedCar(inputCarNum);
                        if(isExistCar){         //반납할 차량번호가 렌트한 차량이면
                            System.out.print("렌탈 반납하시겠습니까? [Y][N] ");
                            String answer = scanner.next();
                            if (answer.equals("Y") || answer.equals("y"))
                                rentalController.returnCar(logindto.getId(),inputCarNum);
                             else if (answer.equals("N") || answer.equals("n"))
                                System.out.println("렌탈 반납을 취소합니다.\n");
                             else
                                System.out.println("알맞지 않은 입력입니다.\n");
                        }
                    }
                }catch (Exception e){ System.out.println(e); }

                break;
            case 3:         //내 정보
                System.out.print("3. 선택");
                break;
            case 4:         //로그아웃
                System.out.println("정상적으로 로그아웃되었습니다. 안녕히가십시오.");
                LoginDto.setId(null);   //로그인 정보 담고 있는 logindto를 null로 만듦
                break;
            default:
                System.out.print("선택할 수 없는 번호입니다.");
        }
    }

    //로그인한 관리자 계정
    public static void logindedMaster(){
        LoginDto.setId("admin");        //로그인 유지를 위한 set
        System.out.println("\n관리자님 환영합니다.");
        System.out.println("1. 차량등록  2. 대여현황  3. 매출현황");
        int inputServiceNum1 = scanner.nextInt();

        switch (inputServiceNum1) {
            case 1:         //차량등록
                registerCar();
                break;
            case 2:         //대여현황
                rentalStatus();
                break;
            case 3:         //매출현황
                break;
        }
    }

    //로그아웃 메소드
    public static int logout(){
        int result = 0;
        System.out.println("현재 로그인한 계정이 있습니다.");
        System.out.print("로그아웃하시겠습니까? [Y][N] ");
        String answer = scanner.next();
        if(answer.equals("Y") || answer.equals("y")) {
            System.out.println("정상적으로 로그아웃되었습니다. 안녕히가십시오.\n");
            LoginDto.setId(null);       //로그인 정보 담고 있는 logindto를 null로 만듦
        } else if (answer.equals("N") || answer.equals("n")) {
            System.out.println("로그아웃을 취소했습니다. 현재 계정의 로그인 상태를 유지합니다.");
            if(logindto.getId().equals("admin"))
                result = 2;             //로그인 상태 유지 - 관리자 계정
            else
                result = 1;                 //로그인 상태 유지 - 일반사용자 계정
        }else{
            System.out.println("알맞지 않은 입력입니다.");
        }
        return result;
    }
    public static void main(String[] args) {

        try {       //입력 오류 예외처리
            while(true){
                System.out.println(" ------------------------------------------------------------------");
                System.out.println("| 렌트카 대여 서비스에 오신걸 환영합니다. 원하시는 서비스 번호를 입력해주세요. |");
                System.out.println(" ------------------------------------------------------------------");
                System.out.println("1. 일반 사용자  2. 관리자");
                int inputServiceNum1 = scanner.nextInt();
                if (inputServiceNum1 == 1) {    //일반 사용자 선택 시
                    System.out.println("1. 회원가입  2. 로그인  3. 아이디 찾기  4. 비밀번호 찾기");
                    int inputServiceNum2 = scanner.nextInt();

                    switch (inputServiceNum2) {
                        case 1:         //회원가입(데이터 저장)
                            if(logindto.getId()==null) {        //로그인한 사람이 없으면
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

                                MemberDto member = new MemberDto(inputDriveNum, inputDriveDate, inputBirth, inputName, inputAge, inputAddr, inputPhoneNum, inputEmail);

                                //* 유효성 검사 - Controller에서 *//
                                memberController.signup(member, checkPW);
                            }else {                         //로그인한 사람이 있으면
                                int session = logout();
                                if(session==1)              //일반사용자 계정
                                    logindedMember();
                                else if (session==2) {      //관리자 계정
                                    logindedMaster();
                                }
                            }
                            break;
                        case 2:         //로그인
                            if(logindto.getId()==null) {        //로그인한 사람이 없으면
                                System.out.println(" -------");
                                System.out.println("| 로그인 |");
                                System.out.println(" -------");

                                System.out.print("회원님의 운전면허증번호를 입력하세요 (예시.12-12-123456-12): ");
                                String inputID = scanner.next();
                                System.out.print("비밀번호를 입력하세요 (핸드폰번호 뒷자리): ");
                                String inputPW = scanner.next();

                                String getName = memberController.signin(inputID, inputPW);
                                if (getName != null && getName != "1" && getName != "2") {  //정상 로그인
                                    LoginDto.setId(inputID);        //로그인한 고객의 ID(운전면허증번호) loginDto로 set
                                    System.out.println(getName + "님 환영합니다.");     //로그인한 고객의 이름

                                    logindedMember();
                                } else if (getName == "1") {      //운전면허번호 유효성 검사까지 통과했지만 고객 테이블에 해당 아이디가 없을 경우
                                    System.out.println("해당 운전면허번호 정보가 없습니다. 다시 확인해주세요.\n");
                                } else if (getName == null) {               //운전면허증번호는 있지만 비밀번호가 틀린 경우
                                    System.out.println("비밀번호가 틀렸습니다. 다시 확인해주세요.\n");
                                }
                            }else {                         //로그인한 사람이 있으면
                                int session = logout();
                                if(session==1)              //일반사용자 계정
                                    logindedMember();
                                else if (session==2) {      //관리자 계정
                                    logindedMaster();
                                }
                            }
                            break;

                        case 3:         //운전면허증번호(PK) 찾기
                            System.out.println(" -----------");
                            System.out.println("| 아이디 찾기 |");
                            System.out.println(" -----------");

                            //고객명, 전화번호 이용
                            System.out.print("성함을 입력하세요 : ");
                            String inputName = scanner.next();
                            System.out.print("가입시 입력한 전화번호를 입력하세요 (예시.010-1234-1234): ");
                            String inputPhoneNum = scanner.next();

                            //정상적으로 아이디(운전면허증번호)를 찾았을 경우 운전면허증번호를 반환
                            String getDriveNum = memberController.findDriveNum(inputName, inputPhoneNum);
                            if (getDriveNum != null)   //정상적으로 아이디 찾음
                                System.out.println(inputName + "님의 운전면허증번호는 " + getDriveNum + " 입니다.");
                            else {                   //사용자가 입력한 고객명과 전화번호와 동일한 아이디 못 찾음
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
                            String inputEmail = scanner.next();

                            //정상적으로 비밀번호(전화번호 뒷자리)를 찾았을 경우 비밀번호를 반환
                            String getPW = memberController.findPassword(inputName, inputEmail);
                            if (getPW != null)         //정상적으로 비밀번호 찾음
                                System.out.println("비밀번호는 " + getPW + " 입니다.");
                            else {                   //사용자가 입력한 아이디과 전화번호와 동일한 비밀번호 못 찾음
                                System.out.println("고객 정보가 잘못되었습니다. 다시 확인해주세요.\n");
                            }

                            break;
                        default:
                            System.out.println("선택할 수 없는 서비스 번호입니다.");
                            break;
                    }

                } else if (inputServiceNum1 == 2) {  //관리자 선택 시
                    //로그인한 아이디가 있을 경우
                    if( LoginDto.getId()!=null ){   //null은 equals가 안됨!!!!!!!!!
                        logout();
                    }else {             //로그인한 아이디가 없을 경우
                        System.out.print("관리자 아이디를 입력하세요: ");
                        String masterID = scanner.next();
                        System.out.print("비밀번호를 입력하세요: ");
                        String masterPW = scanner.next();
                        //관리자 계정 로그인 성공
                        if (masterID.equals("admin") && masterPW.equals("1234")) {
                            logindedMaster();
                        } else {
                            System.out.println("관리자 계정 정보가 잘못되었습니다.");
                        }
                    }
                } else {
                    System.out.println("알맞는 서비스 번호를 입력해주세요.");
                }
            }
        }catch (Exception e){
            //System.out.println(e);
            System.out.println("알맞지 않은 입력입니다."); }
    }
}
