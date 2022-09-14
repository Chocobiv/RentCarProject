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
        catch (Exception e) {System.out.println("[연동 실패] "+e);}
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
        catch (Exception e) { System.out.println(e); }
        return false;
    }

    //로그인 메소드
    public String[] signin(String id){
        String sql = "select 고객명,전화번호 from 고객 where 운전면허증번호 = ?";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1,id );
            rs = ps.executeQuery();
            // 동일한 아이디가 존재하면
            if( rs.next() ) {
                //DB에서 운전면허증번호로 검색된 레코드
                String getName = rs.getString(1);
                String getPhoneNum = rs.getString(2);
                String[] results = {getName,getPhoneNum};
                return results; // 검색된 전화번호 반환
            }
        }catch (Exception e) { System.out.println( e );}
        // 동일한 아이디가 존재하지 않으면
        return null;
    }
    
    //아이디(운전면허증번호) 찾기 메소드
    //고객명, 전화번호 이용 -> 둘이 일치하는 고객 정보가 있는 경우 운전면허증번호를 반환
    public String findDriveNum(String name,String phoneNum){
        String sql = "select 운전면허증번호 from 고객 where 고객명 = ? and 전화번호 = ?";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1,name );
            ps.setString(2,phoneNum );
            rs = ps.executeQuery();
            // 동일한 아이디가 존재하면
            if( rs.next() ) {       //동일한 값이 있으면 = 성공
                //운전면허증번호 가져와서 return
                String getDriveNum = rs.getString(1);
                return getDriveNum; // 검색된 운전면허증번호 반환
            }
            return null;        //동일한 값이 없으면 = 실패

        }catch (Exception e) { System.out.println( e );}    //DB error
        return null;
    }

    //비밀번호(전화번호 뒷자리) 찾기 메소드
    //아이디(운전면허증번호), 이메일 이용 -> 둘이 일치하는 고객 정보가 있는 경우 비밀번호(전화번호 뒷자리)를 반환
    public String findPassword(String name,String email){
        String sql = "select 전화번호 from 고객 where 운전면허증번호 = ? and 이메일 = ?";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1,name );
            ps.setString(2,email );
            rs = ps.executeQuery();
            // 동일한 정보가 존재하면
            if( rs.next() ) {       //동일한 값이 있으면 = 성공
                //운전면허증번호 가져와서 return
                String getDriveNum = rs.getString(1);
                return getDriveNum;     // 검색된 전화번호(전체) 반환
            }
            return null;        //동일한 값이 없으면 = 실패

        }catch (Exception e) { System.out.println( e );}    //DB error
        // 동일한 정보가 존재하지 않으면
        return null;
    }

    //내 정보 메소드 - 일반사용자
    public MemberDto getMyInfo(String id){
        String sql = "select * from 고객 where 운전면허증번호 = ?";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1,id );
            rs = ps.executeQuery();
            // 동일한 정보가 존재하면
            if( rs.next() ) {       //동일한 값이 있으면 = 성공
                //운전면허증번호 가져와서 return
                MemberDto member = new MemberDto(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getInt(5),rs.getString(6),rs.getString(7),rs.getString(8));
                return member;     // 검색된 회원정보 반환
            }
            return null;        //동일한 값이 없으면 = 실패

        }catch (Exception e) { System.out.println( e );}    //DB error
        // 동일한 정보가 존재하지 않으면
        return null;
    }

}
