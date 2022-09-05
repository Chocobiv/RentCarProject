package rentCar.controller;

import rentCar.model.Dao.MemberDao;
import rentCar.model.Dto.MemberDto;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.regex.Pattern;

/* 유효성 검사 후 main으로 결과 반환해서 그 다음에 Dto로 값 담아서 Dao로! 그리고 Dao에서 DB로 */
/* equls() 또는 정규표현식 사용 */
public class CarController {


    //public static MemberDto member = new MemberDto();

    //1. 등록 서비스 (고객 회원가입)
    public boolean signup(MemberDto member,String checkPW){
        boolean result = false;         //return 값

        //유효성 검사 [정규표현식]
        String patternDriveNum = "^\\d{2}-\\d{2}-\\d{6}-\\d{2}$";
        //String patternAge = "^[0-9]*$";  숫자만
        String patternPhone = "^\\d{3}-\\d{4}-\\d{4}$";
        String patternEmail = "^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$";



        //비밀번호 확인 먼저 실행
        String phoneSlice = member.getPhoneNum().substring(9, 13);
        if (!checkPW.equals(phoneSlice)) {  //비밀번호 확인이 다를 경우
            System.out.println("비밀번호 확인이 올바르지 않습니다. [다시 입력]");
            return result;                  //아래 코드 실행x
        }

        //운전면허번호
        if(Pattern.matches(patternDriveNum, member.getDriveNum())&&member.getDriveNum()!=null) {
            result = true;
        } else {
            System.out.println("올바른 운전면허번호가 아닙니다. ");
            result = false;
            return result;
            //throw new IllegalArgumentException("That is an invalid value.");
        }

        //취득날짜
        try{
            SimpleDateFormat dateFormat = new  SimpleDateFormat("yyyy-MM-dd");
            dateFormat.setLenient(false);
            dateFormat.parse(member.getDriveDate());
            result = true;
        }catch (ParseException e){
            System.out.println("올바른 날짜 형식이 아닙니다.");
            result = false;
            return result;
        }

        //생년월일
        try{
            SimpleDateFormat dateFormat = new  SimpleDateFormat("yyyy-MM-dd");
            dateFormat.setLenient(false);
            dateFormat.parse(member.getBirth());
            result = true;
        }catch (ParseException e){
            System.out.println("올바른 날짜 형식이 아닙니다.");
            result = false;
            return result;
        }

        //이름
        if(member.getName()==null) {
            System.out.println("이름을 입력해주세요. ");
            result = false;
            return result;
        }

        //생년월일
        if(member.getAge()>=20){
            //System.out.println("올바른 나이입니다. ");
            result = true;
        } else {
            System.out.println("올바르지 않은 나이입니다. ");
            result = false;
            return result;
        }

        //주소
        if(member.getAddr()==null) {
            System.out.println("주소를 입력해주세요. ");
            result = false;
            return result;
        }

        //전화번호
        if(Pattern.matches(patternPhone, member.getPhoneNum())&&member.getPhoneNum()!=null) {
            //System.out.println("올바른 휴대전화 형식입니다. ");
            result = true;

        } else {
            System.out.println("올바른 휴대전화 형식이 아닙니다. ");
            result = false;
            return result;
            //throw new IllegalArgumentException("That is an invalid value.");
        }

        //이메일
        if(Pattern.matches(patternEmail, member.getEmail())) {
            result = true;
        } else {
            System.out.println("올바른 이메일 형식이 아닙니다. ");
            result = false;
            return result;
            //throw new IllegalArgumentException("That is an invalid value.");
        }



        //운전면허증번호(PK) 중복검사
        boolean checkedDriveId = MemberDao.getmemberDao().checkedId( member.getDriveNum() );

        if ( result  && !checkedDriveId) {         //유효성 검사랑 운전면허증번호(PK) 중복체크 true

            //* 입력받은 값 Dto에 담아서 Dao로 *//
            //MemberDao.getmemberDao() : 매번 new MemberDao하기 귀찮으니까 MemberDao객체 생성해서 get하는 메소드
            boolean result1 = MemberDao.getmemberDao().signup( member );
            if( result1 ) {
                System.out.println("회원가입에 성공했습니다. 로그인해주세요.");
            }else {
                System.out.println("안내) 회원가입 실패");
            }

        }else {                     //유효성 검사 false
            System.out.println("예시를 참고하여 다시 입력해주세요.");
        }
        return result;
        //MemberDao.getmemberDao().signup(member);
    }

    //로그인
    public String signin(String id, String pw){
        String[] checkPhoneNum = MemberDao.getmemberDao().signin(id);

        if (checkPhoneNum!=null) {         //DB에서 가져온 전화번호가 있으면
            //사용자가 입력한 비밀번호와 가져온 전화번호의 뒷자리가 일치하는지 확인
            String slice = checkPhoneNum[1].substring(9, 13);
            if (slice.equals(pw)){      //로그인 성공
                return checkPhoneNum[0];
            }
        }

        return null;
    }


    //아이디(운전면허증번호) 찾기
    public String findDriveNum(String name, String phoneNum){
        String findId = MemberDao.getmemberDao().findDriveNum(name,phoneNum);

        if (findId!=null) {         //DB에서 가져온 운전면허증번호가 있으면
            return findId;
        }
        return null;
    }


    //비밀번호(전화번호 뒷자리) 찾기
    public String findPassword(String id, String email){
        String findPw = MemberDao.getmemberDao().findPassword(id,email);

        if (findPw!=null) {         //DB에서 가져온 운전면허증번호가 있으면
            // 검색된 전화번호를 잘라서 비밀번호만 반환
            String pw = findPw.substring(9, 13);
            return pw;
        }
        return null;
    }

    //2. 삭제 서비스
    //3. 수정 서비스 등등등

}
