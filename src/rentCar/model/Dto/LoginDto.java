package rentCar.model.Dto;

import rentCar.model.Dao.CarDao;

public class LoginDto {
    public static String id;        //static : 보안 처리 필요

    //로그인 유지를 위한 LoginDto
    //3. 객체 생성
    public static LoginDto loginDto = new LoginDto();
    //4. 객체 반환
    public static LoginDto getLoginDto() { return loginDto; }

    public LoginDto() {
    }

    public static String getId() {
        return id;
    }

    public static void setId(String id) {
        LoginDto.id = id;
    }
}
