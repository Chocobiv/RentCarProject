package rentCar.model.Dao;

import rentCar.model.Dto.RentalDto;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class RentalDao {
    protected Connection con;
    protected ResultSet rs;
    protected PreparedStatement ps;

    public RentalDao(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/rent_car2?serverTimezone=UTC" , "root","1234");
        }
        catch (Exception e) {System.out.println("[연동 실패]");}
    }

    //Dao 객체 생성
    public static RentalDao rentalDao = new RentalDao();
    //Dao 객체 반환
    public static RentalDao getRentalDao() { return rentalDao; }


    //렌탈대여 메소드
    public boolean rentalCar(RentalDto rental){
        String sql = "INSERT INTO `대여`(대여시작일,대여기간,운전면허증번호,차량번호,결제번호,보험등록번호,대여상태) VALUES (?,?,?,?,?,?,?)";
        try {
            ps = con.prepareStatement(sql);

            ps.setString( 1 , rental.getRentalStartDay() ); 	ps.setString( 2 , rental.getRentalPeriod() );
            ps.setString( 3 , rental.getDriverNum() );	ps.setString( 4 , rental.getCarNum() );
            ps.setString( 5 , rental.getPaymentNum() ); 	ps.setString( 6 , rental.getInsuranceNum());
            ps.setString( 6 , "대여중");

            ps.executeUpdate();
            return true;
        }
        catch (Exception e) { System.out.println(e); }
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
}
