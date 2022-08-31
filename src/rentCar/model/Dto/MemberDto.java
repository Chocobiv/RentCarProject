package rentCar.model.Dto;

        /*
        [DTO 용도]
         - 계층 간 데이터 교환을 하기 위해 사용하는 객체
         - getter & setter 만 가진 클래스

        유저가 자신의 브라우저에서 데이터를 입력하여 form에 있는 데이터를 DTO에 넣어서 전송
        -> 해당 DTO를 받은 서버가 DAO를 이용하여 데이터베이스로 데이터를 집어넣습니다.
        */

public class MemberDto {
    //1.고객 필드
    private String driveNum;            //운전면허증번호
    private String driveDate;           //취득날짜
    private String birth;               //생년월일
    private String name;                //고객명
    private int age;                    //나이
    private String addr;                //주소
    private String phoneNum;            //전화번호
    private String email;               //이메일



    //2.생성자
    public MemberDto(){}

    public MemberDto(String driveNum, String driveDate, String birth, String name, int age, String addr, String phoneNum, String email) {
        this.driveNum = driveNum;
        this.driveDate = driveDate;
        this.birth = birth;
        this.name = name;
        this.age = age;
        this.addr = addr;
        this.phoneNum = phoneNum;
        this.email = email;
    }



    //3.메소드
    public String getDriveNum() {
        return driveNum;
    }

    public void setDriveNum(String driveNum) {
        this.driveNum = driveNum;
    }

    public String getDriveDate() {
        return driveDate;
    }

    public void setDriveDate(String driveDate) {
        this.driveDate = driveDate;
    }

    public String getBirth() {
        return birth;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


}
