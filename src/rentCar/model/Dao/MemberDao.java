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
    //MemberDao.getmemberDao() : 매번 new MemberDao하기 귀찮으니까 MemberDao객체 생성해서 get하는 메소드
    public static MemberDao getmemberDao() { return memberDao; } // 4. Dao 객체 반환


    //운전면허증번호(PK) 중복 체크
    //SQL문은 무조건 Dao에서 하기!
    public boolean checkedId( String driveId ) {
        //값은 그냥 ?로 하고 ps.set으로 하기!
        //안되면 mysql에서 sql문 테스트해보기
        String sql = "select * from 고객 where 운전면허증번호 = ?";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1,driveId );
            rs = ps.executeQuery();
            // 동일한 아이디가 존재하면
            if( rs.next() ) { return true; }
        }catch (Exception e) { System.out.println( e );}
        // 동일한 아이디가 존재하지 않으면
        return false;
    }

    //1. 고객 회원가입 메소드
    public boolean signup(MemberDto member) {
        String sql = "INSERT INTO `고객` VALUES (?,?,?,?,?,?,?,?)";
        try {
            ps = con.prepareStatement(sql);

            ps.setString( 1 , member.getDriveNum() ); 	ps.setString( 2 , member.getDriveDate() );
            ps.setString( 3 , member.getBirth() );	ps.setString( 4 , member.getName() );
            ps.setInt( 5 , member.getAge() ); 	ps.setString( 6 , member.getAddr());
            ps.setString( 7 , member.getPhoneNum() ); 	ps.setString( 8 , member.getEmail());

            ps.executeUpdate();
            return true;
        }
        catch (Exception e) {
            //test
            /*System.out.println(member.getDriveNum());
            System.out.println(member.getDriveDate());
            System.out.println(member.getBirth());
            System.out.println(member.getName());
            System.out.println(member.getAge());
            System.out.println(member.getAddr());
            System.out.println(member.getPhoneNum());
            System.out.println(member.getEmail());*/

            System.out.println(e); }
        return false;
    }


}
