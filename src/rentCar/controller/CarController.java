package rentCar.controller;

import rentCar.model.Dao.CarDao;
import rentCar.model.Dao.MemberDao;
import rentCar.model.Dto.CarDto;

import java.util.regex.Pattern;

public class CarController {

    //관리자 메뉴 - 렌탈 차량 등록
    //차량 테이블
    public boolean resisterCar(CarDto car){
        boolean result = false;         //return 값

        //유효성 검사 [정규표현식]
        String patternCarNum = "^\\d{2}[가|나|다|라|마|거|너|더|러|머|버|서|어|저|고|노|도|로|모|보|소|오|조|구|누|두|루|무|부|수|우|주|바|사|아|자|허|배|호|하\\x20] \\d{4}$";

        //차량번호(PK)
        if(Pattern.matches(patternCarNum, car.getCarNum())&&car.getCarNum()!=null) {
            result = true;
        } else {
            System.out.println("올바른 차량번호가 아닙니다. ");
            result = false;
            return result;
            //throw new IllegalArgumentException("That is an invalid value.");
        }

        //차량번호(PK) 중복검사
        boolean checkedCarNum = CarDao.getCarDao().checkedCarNum( car.getCarNum() );

        if ( result  && !checkedCarNum) {         //유효성 검사랑 차량번호(PK) 중복체크 true
            //* 입력받은 값 Dto에 담아서 Dao로 *//
            //MemberDao.getmemberDao() : 매번 new MemberDao하기 귀찮으니까 MemberDao객체 생성해서 get하는 메소드
            boolean result1 = CarDao.getCarDao().resisterCar( car );
            if( result1 ) {
                System.out.println("차량 등록에 성공했습니다.");
            }else {
                System.out.println("안내) 회원가입 실패");
            }

        }else {                     //유효성 검사 false
            System.out.println("예시를 참고하여 다시 입력해주세요.");
        }

        return result;
    }

}
