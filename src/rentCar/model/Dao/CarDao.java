package rentCar.model.Dao;

import rentCar.model.Dto.CarDto;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

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





}
