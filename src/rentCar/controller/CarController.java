package rentCar.controller;

import rentCar.model.Dao.CarDao;
import rentCar.model.Dto.CarDto;
import java.util.ArrayList;
import java.util.regex.Pattern;

public class CarController {

    //차량 번호 유효성 검사 메소드
    public boolean validateCarNum(String carNum){
        //boolean result = false;

        //유효성 검사 [정규표현식]
        String patternCarNum = "^\\d{2}[가|나|다|라|마|거|너|더|러|머|버|서|어|저|고|노|도|로|모|보|소|오|조|구|누|두|루|무|부|수|우|주|바|사|아|자|허|배|호|하\\x20] \\d{4}$";

        //차량번호(PK)
        if(Pattern.matches(patternCarNum, carNum) && carNum!=null) {
            return true;
        }
        return false;
    }

    //관리자 메뉴 - 렌탈 차량 등록
    //차량 테이블
    public int registerCar(CarDto car){
        //차량번호 유효성 검사
        boolean result = validateCarNum(car.getCarNum());

        //차량번호(PK) 중복검사
        boolean checkedCarNum = CarDao.getCarDao().checkedCarNum( car.getCarNum() );

        if (result) {               //유효성 검사 true
            if(!checkedCarNum) {    //차량번호(PK) 중복체크 통과
                //* 입력받은 값 Dto에 담아서 Dao로 *//
                //MemberDao.getmemberDao() : 매번 new MemberDao하기 귀찮으니까 MemberDao객체 생성해서 get하는 메소드
                boolean result1 = CarDao.getCarDao().resisterCar(car);
                if (result1)
                    return 1;
                else
                    return 2;
            }else                   //차량번호 중복체크 실패
                return 3;
        }else {                     //유효성 검사 false
            return 4;
        }
    }


    //차량목록 메소드 - 관리자
    public ArrayList<CarDto> getCarList(){
        ArrayList<CarDto> list = CarDao.getCarDao().getCarList();
        if(!list.isEmpty()){
            return list;
        }
        return null;
    }


    //차량 삭제 메소드 - 관리자
    public int deleteCar(String carNum){
        //차량번호 유효성 검사
        boolean validateResult = validateCarNum(carNum);

        //차량번호(PK) 중복검사
        boolean checkedCarNum = CarDao.getCarDao().checkedCarNum(carNum);

        if(validateResult){         //유효성 검사 true
            if(checkedCarNum){      //차량번호가 db에 존재하면
                boolean deleteResult = CarDao.getCarDao().deleteCar(carNum);
                if(deleteResult)
                    return 1;
                else
                    return 0;
            }else return 2;
        }else return 3;
    }
}
