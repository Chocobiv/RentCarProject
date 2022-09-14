package rentCar.controller;

import rentCar.model.Dao.CarDao;
import rentCar.model.Dao.MemberDao;
import rentCar.model.Dto.CarDto;
import rentCar.model.Dto.MemberDto;

import java.util.ArrayList;
import java.util.regex.Pattern;

public class CarController {

    //차량 번호 유효성 검사 메소드
    public boolean validateCarNum(String carNum){
        boolean result = false;

        //유효성 검사 [정규표현식]
        String patternCarNum = "^\\d{2}[가|나|다|라|마|거|너|더|러|머|버|서|어|저|고|노|도|로|모|보|소|오|조|구|누|두|루|무|부|수|우|주|바|사|아|자|허|배|호|하\\x20] \\d{4}$";

        //차량번호(PK)
        if(Pattern.matches(patternCarNum, carNum) && carNum!=null) {
            result = true;
        } else {
            System.out.println("올바른 차량번호가 아닙니다. ");
            result = false;
            return result;
        }
        return result;
    }

    //관리자 메뉴 - 렌탈 차량 등록
    //차량 테이블
    public boolean resisterCar(CarDto car){
        //차량번호 유효성 검사
        boolean result = validateCarNum(car.getCarNum());

        //차량번호(PK) 중복검사
        boolean checkedCarNum = CarDao.getCarDao().checkedCarNum( car.getCarNum() );

        if ( result  && !checkedCarNum) {         //유효성 검사랑 차량번호(PK) 중복체크 true
            //* 입력받은 값 Dto에 담아서 Dao로 *//
            //MemberDao.getmemberDao() : 매번 new MemberDao하기 귀찮으니까 MemberDao객체 생성해서 get하는 메소드
            boolean result1 = CarDao.getCarDao().resisterCar( car );
            if( result1 ) {
                System.out.println("차량 등록에 성공했습니다.");
            }else {
                System.out.println("안내) 차량 등록 실패");
            }
        }else {                     //유효성 검사 false
            System.out.println("예시를 참고하여 다시 입력해주세요.");
        }
        return result;
    }


    //차량목록 메소드 - 관리자
    public ArrayList<CarDto> getCarList(){
        ArrayList<CarDto> list = CarDao.getCarDao().getCarList();
        if(!list.isEmpty()){
            return list;
        }else{
            System.out.println("등록된 차량이 없습니다.\n");
        }
        return null;
    }


    //차량 삭제 메소드 - 관리자
    public void deleteCar(String carNum){
        //차량번호 유효성 검사
        boolean validateResult = validateCarNum(carNum);

        //차량번호(PK) 중복검사
        boolean checkedCarNum = CarDao.getCarDao().checkedCarNum(carNum);

        if(validateResult){         //유효성 검사 true
            if(checkedCarNum){      //차량번호가 db에 존재하면
                boolean deleteResult = CarDao.getCarDao().deleteCar(carNum);
                if(deleteResult){
                    System.out.println("차량 삭제가 완료되었습니다. 감사합니다.\n");
                }
            }else System.out.println("해당 차량번호는 조회되지 않습니다. 다시 확인해주세요.\n");
        }else System.out.println("차량번호 형식이 잘못되었습니다. 예시를 참고하여 다시 입력해주세요.\n");
    }
}
