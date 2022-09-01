package rentCar.controller;

import rentCar.model.Dao.MemberDao;
import rentCar.model.Dto.MemberDto;

import java.util.regex.Pattern;

/* 유효성 검사 후 main으로 결과 반환해서 그 다음에 Dto로 값 담아서 Dao로! 그리고 Dao에서 DB로 */
/* equls() 또는 정규표현식 사용 */
public class CarController {

    //public static MemberDto member = new MemberDto();

    //1. 등록 서비스 (고객 회원가입)
    public boolean signup(MemberDto member){
        boolean result = false;         //return 값


        //유효성 검사 [정규표현식]
        String patternDriveNum;
        String patternAge = "^[0-9]*$";
        String patternDate = "^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$";
        String patternPhone = "^\\d{3}-\\d{3,4}-\\d{4}$";
        String patternEmail = "^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$";


        //입력받은 회원정보 값들
        String inputDriveNum = member.getDriveNum();
        String inputDriveDate = member.getDriveDate();
        String inputBirth = member.getBirth();
        String inputName = member.getName();
        int inputAge = member.getAge();
        String inputAddr = member.getAddr();
        String inputPhoneNum = member.getPhoneNum();
        String inputEmail = member.getEmail();





        //취득날짜
        if(Pattern.matches(patternDate, inputDriveDate)&&inputDriveDate!=null) {
            System.out.println("올바른 날짜 형식입니다. ");
            result = true;
        } else {
            System.out.println("올바른 날짜 형식이 아닙니다. ");
            result = false;
            return result;
        }


        //생년월일
        if(Pattern.matches(patternDate, inputBirth)&&inputBirth!=null) {
            System.out.println("올바른 날짜 형식입니다. ");
            result = true;
        } else {
            System.out.println("올바른 날짜 형식이 아닙니다. ");
            result = false;
            return result;
        }


        //이름
        if(inputName==null) {
            System.out.println("이름을 입력해주세요. ");
            result = false;
            return result;
        }


        //주소
        if(inputAddr==null) {
            System.out.println("주소를 입력해주세요. ");
            result = false;
            return result;
        }


        //전화번호
        if(Pattern.matches(patternPhone, inputPhoneNum)&&inputPhoneNum!=null) {
            System.out.println("올바른 휴대전화 형식입니다. ");
            result = true;

        } else {
            System.out.println("올바른 휴대전화 형식이 아닙니다. ");
            result = false;
            return result;
            //throw new IllegalArgumentException("That is an invalid value.");
        }


        //이메일
        if(Pattern.matches(patternEmail, inputEmail)) {
            System.out.println("올바른 이메일 형식입니다. ");
            result = true;
        } else {
            System.out.println("올바른 이메일 형식이 아닙니다. ");
            result = false;
            return result;
            //throw new IllegalArgumentException("That is an invalid value.");
        }

        return result;
        //MemberDao.getmemberDao().signup(member);

    }
    //2. 삭제 서비스
    //3. 수정 서비스 등등등

}
