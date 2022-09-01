package rentCar.model.Dao;

import rentCar.model.Dto.MemberDto;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class MemberDao {
    protected Connection con;
    protected ResultSet rs;
    protected PreparedStatement ps;

    // 2. 생성자
    public MemberDao() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/rent_car2?serverTimezone=UTC" , "root","1234");
        }
        catch (Exception e) {System.out.println("[연동 실패]");}
    }
    public static MemberDao memberDao = new MemberDao() ; 	// 3. Dao 객체 생성
    public static MemberDao getmemberDao() { return memberDao; } // 4. Dao 객체 반환

    //1. 고객 회원가입 메소드
    public boolean signup(MemberDto member) {
        String sql = "INSERT INTO '고객' VALUES (?,?,?,?,?,?,?,?)";
        try {
            ps = con.prepareStatement(sql);

            ps.setString( 1 , member.getDriveNum() ); 	ps.setString( 2 , member.getDriveDate() );
            ps.setString( 3 , member.getBirth() );	ps.setString( 4 , member.getName() );
            ps.setInt( 5 , member.getAge() ); 	ps.setString( 6 , member.getAddr());
            ps.setString( 7 , member.getPhoneNum() ); 	ps.setString( 8 , member.getEmail());

            ps.executeUpdate();
            return true;
        }
        catch (Exception e) { System.out.println(e); }
        return false;
    }

    public void signup() {
    }
}
