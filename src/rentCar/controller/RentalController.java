package rentCar.controller;

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

        if(carList!=null)
            return carList;
        return null;
    }

    //렌탈대여 중인 차량 목록 조회 메소드
    public ArrayList<String> rentalCarList(String id){
        //대여 중인 차량 리스트를 가져옴
        ArrayList<String> carNumList = RentalDao.getRentalDao().rentalCarNum(id);

        if(!carNumList.isEmpty())
            return carNumList;
        return null;
    }

    //렌탈대여 메소드
    public int rental(RentalDto rental){

        //대여시작일 - 유효성 검사
        try{
            SimpleDateFormat dateFormat = new  SimpleDateFormat("yyyy-MM-dd");
            dateFormat.setLenient(false);
            dateFormat.parse(rental.getRentalStartDay());
        }catch (ParseException e){ return 1; }

        //차량 번호 - 유효성 검사
        //유효성 검사 [정규표현식]
        String patternCarNum = "^\\d{2}[가|나|다|라|마|거|너|더|러|머|버|서|어|저|고|노|도|로|모|보|소|오|조|구|누|두|루|무|부|수|우|주|바|사|아|자|허|배|호|하\\x20] \\d{4}$";

        //차량번호(PK)
        if(!Pattern.matches(patternCarNum, rental.getCarNum()) || rental.getCarNum()==null) {
            return 2;
            //throw new IllegalArgumentException("That is an invalid value.");
        }

        //차량번호가 차량 테이블에 존재하는지 체크
        boolean checkedCarNum = RentalDao.getRentalDao().checkedCarNum(rental.getCarNum());
        //차량테이블에서 차량반납여부가 대여가능인지 체크
        String checkedRentalState = RentalDao.getRentalDao().checkedRentalState(rental.getCarNum());    //차량반납여부 리턴

        if(checkedCarNum && checkedRentalState.equals("대여가능")){     //차량번호 존재 여부 체크 true / 차량반납여부가 대여가능
            //* 입력받은 값 Dto에 담아서 Dao로 *//
            boolean result1 = RentalDao.getRentalDao().rentalCar(rental);
            if( result1 )
                return 6;
            else
                return 7;
        }
        else if (!checkedCarNum)    //차량번호 존재 false
            return 3;
        else if (checkedRentalState.equals("대여중"))   //차량반납여부가 대여중
            return 4;
        else
            return 5;

    }

    //렌탈반납 메소드
    public boolean returnCar(String id, String carNum){
        boolean result = RentalDao.getRentalDao().returnCar(id,carNum);
        if(result)
            return true;
        else
            return false;
    }

    //렌탈현황 조회 메소드
    public ArrayList<RentalDto> rentalStatus(){
        ArrayList<RentalDto> rentalList = RentalDao.getRentalDao().rentalStatusList();
        if(rentalList!=null)
            return rentalList;
        return null;
    }

    //매출현황 조회 메소드
    public ArrayList<int[]> sales(){
        ArrayList<int[]> costs = RentalDao.getRentalDao().sales();
        if(costs!=null)
            return costs;
        return null;
    }
}
