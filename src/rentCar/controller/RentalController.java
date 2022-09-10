package rentCar.controller;

import rentCar.model.Dao.CarDao;
import rentCar.model.Dao.MemberDao;
import rentCar.model.Dao.RentalDao;
import rentCar.model.Dto.CarDto;
import rentCar.model.Dto.RentalDto;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.regex.Pattern;

public class RentalController {

    //렌탈 가능한 차량 목록 조회 메소드
    public ArrayList<CarDto> rentalList(){
        //대여가능인 차량 리스트를 가져옴
        ArrayList<CarDto> carList = RentalDao.getRentalDao().selectRentalList();

        if(carList!=null){
            return carList;
        }else{
            System.out.printf("렌탈 대여 가능한 차량이 없습니다.\n");
        }
        return null;
    }


    public boolean rental(RentalDto rental){
        boolean result = false;

        //대여시작일 - 유효성 검사
        try{
            SimpleDateFormat dateFormat = new  SimpleDateFormat("yyyy-MM-dd");
            dateFormat.setLenient(false);
            dateFormat.parse(rental.getRentalStartDay());
            result = true;
        }catch (ParseException e){
            System.out.println("올바른 날짜 형식이 아닙니다.");
            result = false;
            return result;
        }

        //차량 번호 - 유효성 검사
        //유효성 검사 [정규표현식]
        String patternCarNum = "^\\d{2}[가|나|다|라|마|거|너|더|러|머|버|서|어|저|고|노|도|로|모|보|소|오|조|구|누|두|루|무|부|수|우|주|바|사|아|자|허|배|호|하\\x20] \\d{4}$";

        //차량번호(PK)
        if(Pattern.matches(patternCarNum, rental.getCarNum())&&rental.getCarNum()!=null) {
            result = true;
        } else {
            System.out.println("올바른 차량번호가 아닙니다. ");
            result = false;
            return result;
            //throw new IllegalArgumentException("That is an invalid value.");
        }

        //차량번호가 차량 테이블에 존재하는지 체크
        boolean checkedCarNum = RentalDao.getRentalDao().checkedCarNum(rental.getCarNum());
        //차량테이블에서 차량반납여부가 대여가능인지 체크
        String checkedRentalState = RentalDao.getRentalDao().checkedRentalState(rental.getCarNum());    //차량반납여부 리턴

        if(result && checkedCarNum && checkedRentalState.equals("대여가능")){     //유효성 검사랑 차량번호 존재 여부 체크 true / 차량반납여부가 대여가능
            //* 입력받은 값 Dto에 담아서 Dao로 *//
            boolean result1 = RentalDao.getRentalDao().rentalCar(rental);
            if( result1 ) {
                System.out.println("렌탈대여에 성공했습니다.\n");
            }else {
                System.out.println("안내) 렌탈대여 실패\n");
            }
        } else if(!result){          //유효성 검사 false
            System.out.println("예시를 참고하여 다시 입력해주세요.\n");
        } else if (!checkedCarNum) {    //차량번호 존재 false
            System.out.println("해당 차량번호가 조회되지 않습니다. 다른 차량번호를 입력하세요.\n");
        } else if (checkedRentalState.equals("대여중")) {  //차량반납여부가 대여중
            System.out.println("해당 차량은 현재 대여중입니다. 다른 차량번호를 입력하세요.\n");
        } else{
            System.out.println("예시를 참고하여 다시 입력해주세요.");
            System.out.println("해당 차량번호가 조회되지 않습니다. 다른 차량번호를 입력하세요.\n");
        }

        return result;
    }

}
