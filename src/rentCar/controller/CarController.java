package rentCar.controller;

import rentCar.model.Dao.MemberDao;

/* 유효성 검사 후 main으로 결과 반환해서 그 다음에 Dto로 값 담아서 Dao로! 그리고 Dao에서 DB로 */
/* equls() 또는 정규표현식 사용 */
public class CarController {

    //1. 등록 서비스 (고객 회원가입)
    public void signup(){
        MemberDao.getmemberDao().signup();
    }
    //2. 삭제 서비스
    //3. 수정 서비스 등등등

}
