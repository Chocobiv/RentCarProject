package rentCar.model.Dao;

import rentCar.model.Dto.CarDto;
import rentCar.model.Dto.RentalDto;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class RentalDao {
    protected Connection con;
    protected ResultSet rs;
    protected PreparedStatement ps;

    public RentalDao(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/rent_car2?serverTimezone=UTC" , "root","1234");
        }
        catch (Exception e) {System.out.println("[연동 실패] "+e);}
    }

    //Dao 객체 생성
    public static RentalDao rentalDao = new RentalDao();
    //Dao 객체 반환
    public static RentalDao getRentalDao() { return rentalDao; }

    public ArrayList<RentalDto> rentalStatusList() {
        //값은 그냥 ?로 하고 ps.set으로 하기!
        //안되면 mysql에서 sql문 테스트해보기
        ArrayList<RentalDto> rentalList = new ArrayList<RentalDto>();
        String sql = "select 대여시작일,대여기간,운전면허증번호,차량번호,결제번호,보험등록번호 from 대여 where 대여상태 = ?";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1,"대여중");
            rs = ps.executeQuery();
            // 대여상태가 대여중인게 있으면
            while( rs.next() ) {        //여러개 호출시 while
                RentalDto rental = new RentalDto(
                        rs.getString(1),rs.getString(2),rs.getString(3),
                        rs.getString(4),rs.getString(5),rs.getString(6));

                rentalList.add(rental);
            }
            return rentalList;
        }catch (Exception e) {}
        //대여상태가 대여중인게 없으면
        return null;
    }

    //렌탈 대여 가능 목록 조회 메소드
    public ArrayList<CarDto> selectRentalList() {
        //값은 그냥 ?로 하고 ps.set으로 하기!
        //안되면 mysql에서 sql문 테스트해보기
        ArrayList<CarDto> carList = new ArrayList<CarDto>();
        String sql = "select * from 차량 where 차량반납여부 = ?";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1,"대여가능");
            rs = ps.executeQuery();
            // 차량반납여부가 대여가능인게 있으면
            while( rs.next() ) {        //여러개 호출시 while
                CarDto car = new CarDto(
                        rs.getString(1),rs.getString(2),rs.getString(3),
                        rs.getString(4),rs.getString(5),rs.getString(6),
                        rs.getInt(7),rs.getString(8),rs.getString(9),
                        rs.getInt(10),rs.getString(11));

                carList.add(car);
            }
            return carList;
        }catch (Exception e) {}
        //차량반납여부가 대여가능인게 없으면
        return null;
    }


    //렌탈대여 메소드
    public boolean rentalCar(RentalDto rental){
        String sql = "INSERT INTO `대여`(대여시작일,대여기간,운전면허증번호,차량번호,결제번호,보험등록번호,대여상태) VALUES (?,?,?,?,?,?,?)";
        String sql2 ="UPDATE 차량 SET 차량반납여부=? WHERE 차량번호=?"; //대여하는 차량의 차량반납여부를 대여중으로 변경
        try {
            ps = con.prepareStatement(sql);

            ps.setString( 1 , rental.getRentalStartDay() ); 	ps.setString( 2 , rental.getRentalPeriod() );
            ps.setString( 3 , rental.getDriverNum() );	ps.setString( 4 , rental.getCarNum() );
            ps.setString( 5 , rental.getPaymentNum() ); 	ps.setString( 6 , rental.getInsuranceNum());
            ps.setString( 7 , "대여중");

            ps.executeUpdate();


            ps = con.prepareStatement(sql2);
            ps.setString( 1 , "대여중" );
            ps.setString( 2 , rental.getCarNum() );
            ps.executeUpdate();
            return true;
        }
        catch (Exception e) { System.out.println(e); }
        return false;
    }

    //렌탈 중인 차량번호 조회 메소드
    public ArrayList<String> rentalCarNum(String id){
        String sql = "select 차량번호 from 대여 where 운전면허증번호 = ? AND 대여상태 = ?";
        ArrayList<String> list = new ArrayList<>();
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1,id );
            ps.setString(2,"대여중");
            rs = ps.executeQuery();

            while( rs.next() ) {
                String carNum = rs.getString(1);
                list.add(carNum);
            }
            return list;  //해당 아이디(운전면허증번호)가 빌린 차량번호 list 조회
        }catch (Exception e) { System.out.println( e );}

        return null;
    }


    //렌탈반납 메소드
    public boolean returnCar(String id, String carNum){
        String sql1 ="UPDATE 대여 SET 대여상태=? WHERE 운전면허증번호=?"; //대여테이블의 대여상태를 반납완료로 변경
        String sql2 ="UPDATE 차량 SET 차량반납여부=? WHERE 차량번호=?"; //대여하는 차량의 차량반납여부를 대여가능으로 변경
        try {
            ps = con.prepareStatement(sql1);
            ps.setString(1, "반납완료");
            ps.setString( 2 , id);
            ps.executeUpdate();

            ps = con.prepareStatement(sql2);
            ps.setString(1, "대여가능");
            ps.setString( 2 , carNum);
            ps.executeUpdate();

            return true;
        }catch (Exception e) { System.out.println(e); }
        return false;
    }

    //차량번호가 차량테이블에 존재하는지 여부 체크
    public boolean checkedCarNum( String carNum ) {
        //값은 그냥 ?로 하고 ps.set으로 하기!
        //안되면 mysql에서 sql문 테스트해보기
        String sql = "select * from 차량 where 차량번호 = ?";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1,carNum );
            rs = ps.executeQuery();
            // 동일한 차량번호가 존재하면
            if( rs.next() ) { return true; }
        }catch (Exception e) { System.out.println( e );}
        
        // 동일한 차량번호가 존재하지 않으면
        return false;
    }

    //차량번호를 이용해서 차량테이블에서 차량반납여부 가져오는 메소드
    public String checkedRentalState( String carNum ){
        String sql = "select 차량반납여부 from 차량 where 차량번호 = ?";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1,carNum );
            rs = ps.executeQuery();

            if( rs.next() ) {
                //DB에서 차량번호로 검색된 레코드
                String getRentalState = rs.getString(1);
                return getRentalState;  //해당 차량번호의 차량반납여부 반환
            }
        }catch (Exception e) { System.out.println( e );}

        return null;
    }

    //대여테이블에 대여상태가 반납완료인 것들의 결제번호를 타고 결제테이블로 가서 청구요금와 연장비용을 가져오는 메소드
    public ArrayList<int[]> sales(){
        ArrayList<int[]> list = new ArrayList<>();
        String sql = "select 청구요금,연장비용 from 결제 where 결제번호 = any(select 결제번호 from 대여 where 대여상태 = ?)";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1,"반납완료" );
            rs = ps.executeQuery();

            while( rs.next() ) {
                int[] getSales = new int[2];
                getSales[0] = rs.getInt(1);     //청구요금
                getSales[1] = rs.getInt(2);     //연장비용
                list.add(getSales);
            }
            return list;
        }catch (Exception e) { System.out.println( e );}

        return null;
    }
}
