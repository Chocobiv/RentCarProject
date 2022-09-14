package rentCar.controller;

import rentCar.model.Dao.MemberDao;
import rentCar.model.Dto.MemberDto;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.regex.Pattern;

//view가 바뀌어도 실행될 수 있다 -> print랑 scanner 모두 다 빼기!!!! [다양한 경우의 수는 int값 return 해서!]
/* 유효성 검사 후 main으로 결과 반환해서 그 다음에 Dto로 값 담아서 Dao로! 그리고 Dao에서 DB로 */
/* equls() 또는 정규표현식 사용 */
public class MemberController {


    //public static MemberDto member = new MemberDto();

    //1. 등록 서비스 (고객 회원가입)
    public int signup(MemberDto member,String checkPW){

        //유효성 검사 [정규표현식]
        String patternDriveNum = "^\\d{2}-\\d{2}-\\d{6}-\\d{2}$";
        //String patternAge = "^[0-9]*$";  숫자만
        String patternPhone = "^\\d{3}-\\d{4}-\\d{4}$";
        String patternEmail = "^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$";


        //비밀번호 확인 먼저 실행
        String phoneSlice = member.getPhoneNum().substring(9, 13);
        if (!checkPW.equals(phoneSlice))    //비밀번호 확인이 다를 경우
            return 1;                       //아래 코드 실행x


        //운전면허번호
        if(!Pattern.matches(patternDriveNum, member.getDriveNum()) || member.getDriveNum()==null)
            return 2;

        //취득날짜
        try{
            SimpleDateFormat dateFormat = new  SimpleDateFormat("yyyy-MM-dd");
            dateFormat.setLenient(false);
            dateFormat.parse(member.getDriveDate());
        }catch (ParseException e){
            return 3;
        }

        //생년월일
        try{
            SimpleDateFormat dateFormat = new  SimpleDateFormat("yyyy-MM-dd");
            dateFormat.setLenient(false);
            dateFormat.parse(member.getBirth());
        }catch (ParseException e){
            return 4;
        }

        //이름
        if(member.getName()==null)
            return 5;

        //생년월일
        if(member.getAge()<20)
            return 6;

        //주소
        if(member.getAddr()==null)
            return 7;

        //전화번호
        if(!Pattern.matches(patternPhone, member.getPhoneNum()) || member.getPhoneNum()==null)
            return 8;

        //이메일
        if(!Pattern.matches(patternEmail, member.getEmail())) {
            return 9;
            //throw new IllegalArgumentException("That is an invalid value.");
        }


        //운전면허증번호(PK) 중복검사
        boolean checkedDriveId = MemberDao.getmemberDao().checkedId( member.getDriveNum() );

        if (!checkedDriveId) {         //운전면허증번호(PK) 중복체크 true
            //* 입력받은 값 Dto에 담아서 Dao로 *//
            //MemberDao.getmemberDao() : 매번 new MemberDao하기 귀찮으니까 MemberDao객체 생성해서 get하는 메소드
            boolean result1 = MemberDao.getmemberDao().signup( member );
            if( result1 ) 
                return 10;              //회원가입 성공
            else 
                return 11;              //회원가입 실패
        }
        return 0;
    }

    //로그인
    public String signin(String id, String pw){
        boolean result;
        String patternDriveNum = "^\\d{2}-\\d{2}-\\d{6}-\\d{2}$";
        //운전면허번호 - 유효성 검사
        if(Pattern.matches(patternDriveNum, id) && id!=null) {
            result = true;
        } else {
            result = false;
            return "2";
        }

        String[] checkPhoneNum = new String[2];
        if (result){
            checkPhoneNum = MemberDao.getmemberDao().signin(id);

            if (checkPhoneNum!=null) {         //DB에서 가져온 전화번호가 있으면
                //사용자가 입력한 비밀번호와 가져온 전화번호의 뒷자리가 일치하는지 확인
                String slice = checkPhoneNum[1].substring(9, 13);
                if (slice.equals(pw)){      //로그인 성공
                    return checkPhoneNum[0];
                }
            }else{      //DB에서 가져온 회원정보가 없으면
                return "1";
            }
        }
        return null;
    }


    //아이디(운전면허증번호) 찾기
    public String findDriveNum(String name, String phoneNum){
        String findId = MemberDao.getmemberDao().findDriveNum(name,phoneNum);
        if(findId==null) {
            // 동일한 아이디가 존재하지 않으면
            System.out.println("해당 회원 정보가 없습니다.");
            return null;
        }else
            //DB에서 가져온 운전면허증번호가 있으면
            return findId;
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


    //내 정보
    public MemberDto getMyInfo(String id){
        MemberDto member = MemberDao.getmemberDao().getMyInfo(id);
        if(member!=null){
            return member;
        }
        return null;
    }

    //2. 삭제 서비스
    //3. 수정 서비스 등등등

}
