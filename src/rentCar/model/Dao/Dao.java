package rentCar.model.Dao;

import rentCar.model.Dto.CarDto;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Dao {
    protected Connection con;
    protected ResultSet rs;
    protected PreparedStatement ps;

    // 2. 생성자
    public Dao() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/rent_car2?serverTimezone=UTC" , "root","1234");
        }
        catch (Exception e) {System.out.println("[연동 실패]");}
    }
    public static Dao dao = new Dao() ; 	// 3. Dao 객체 생성
    public static Dao getDao() { return dao; } // 4. Dao 객체 반환

    //1. 차량 등록 테스트 메소드
    public boolean register(CarDto carDto) {
        String sql = "INSERT INTO `차량` VALUES (?,?,'준대형','그레이','LPG','에어백',5,'부산','-',80000)";
        try {
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
            return true;
        }
        catch (Exception e) {System.out.println(e);}
        return false;
    }

}
