package rentCar.model.Dao;

import rentCar.model.Dto.CarDto;
import rentCar.model.Dto.MemberDto;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class CarDao {
    protected Connection con;
    protected ResultSet rs;
    protected PreparedStatement ps;

    //2. 생성자
    public CarDao() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/rent_car2?serverTimezone=UTC" , "root","1234");
        }
        catch (Exception e) {System.out.println("[연동 실패]");}
    }

    //매번 new CarDao 귀찮으니까 CarDao객체 생성해서 get하는 메소드 아예 만들어놓기
    //3. Dao 객체 생성
    public static CarDao carDao = new CarDao();
    //4. Dao 객체 반환
    public static CarDao getCarDao() { return carDao; }


    //차량번호(PK) 중복 체크
    //SQL문은 무조건 Dao에서 하기!
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

    //1. 차량 등록 메소드
    public boolean resisterCar(CarDto car) {
        String sql = "INSERT INTO `차량` VALUES (?,?,?,?,?,?,?,?,?,?,?)";
        try {
            ps = con.prepareStatement(sql);

            ps.setString( 1 , car.getCarNum() ); 	ps.setString( 2 , car.getCarName() );
            ps.setString( 3 , car.getCarType() );	ps.setString( 4 , car.getCarColor() );
            ps.setString( 5 , car.getCarFuel() ); 	ps.setString( 6 , car.getCarOption());
            ps.setInt( 7 , car.getCarPersonnel() ); 	ps.setString( 8 , car.getCarRegion());
            ps.setString( 9 , car.getCarDetail() ); 	ps.setInt( 10 , car.getCost());
            ps.setString( 11 , car.getCarReturn());

            ps.executeUpdate();
            return true;
        }
        catch (Exception e) { System.out.println(e); }
        return false;
    }

    //차량 목록 메소드 - 관리자
    public ArrayList<CarDto> getCarList(){
        String sql = "select * from 차량";
        ArrayList<CarDto> list = new ArrayList<CarDto>();
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            // 동일한 정보가 존재하면
            while( rs.next() ) {       //동일한 값이 있으면 = 성공
                //차량목록 가져와서 return
                CarDto car = new CarDto(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getInt(7),rs.getString(8),rs.getString(9),rs.getInt(10),rs.getString(11));
                list.add(car);
            }
            return list;     // 검색된 회원정보 list 반환
        }catch (Exception e) { System.out.println( e );}    //DB error
        // 동일한 정보가 존재하지 않으면
        return null;
    }

    public boolean deleteCar( String carNum ) {
        //값은 그냥 ?로 하고 ps.set으로 하기!
        //안되면 mysql에서 sql문 테스트해보기
        String sql = "delete from 차량 where 차량번호 = ?";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1,carNum );
            ps.executeUpdate();
            return true;
        }catch (Exception e) { System.out.println( e );}
        // 동일한 차량번호가 존재하지 않으면
        return false;
    }
}
