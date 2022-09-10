package rentCar.model.Dto;

public class RentalDto {
    //대여 필드
    //고유대여번호(PK) -> AI
    private String rentalStartDay;  //대여시작일
    private String rentalPeriod;    //대여기간
    private String driverNum;       //운전면허증번호 (FOREIGN KEY)
    private String carNum;          //차량번호 (FOREIGN KEY)
    private String paymentNum;      //결제번호 (FOREIGN KEY)
    private String insuranceNum;    //보험등록번호 (FOREIGN KEY)
    private String rentalStatus;    //대여상태

    //생성자
    public RentalDto(){}

    public RentalDto(String rentalStartDay, String rentalPeriod, String driverNum, String carNum, String paymentNum, String insuranceNum) {
        this.rentalStartDay = rentalStartDay;
        this.rentalPeriod = rentalPeriod;
        this.driverNum = driverNum;
        this.carNum = carNum;
        this.paymentNum = paymentNum;
        this.insuranceNum = insuranceNum;
    }

    public RentalDto(String rentalStartDay, String rentalPeriod, String driverNum, String carNum, String paymentNum, String insuranceNum, String rentalStatus) {
        this.rentalStartDay = rentalStartDay;
        this.rentalPeriod = rentalPeriod;
        this.driverNum = driverNum;
        this.carNum = carNum;
        this.paymentNum = paymentNum;
        this.insuranceNum = insuranceNum;
        this.rentalStatus = rentalStatus;
    }

    //메소드
    public String getRentalStartDay() {
        return rentalStartDay;
    }

    public void setRentalStartDay(String rentalStartDay) {
        this.rentalStartDay = rentalStartDay;
    }

    public String getRentalPeriod() {
        return rentalPeriod;
    }

    public void setRentalPeriod(String rentalPeriod) {
        this.rentalPeriod = rentalPeriod;
    }

    public String getDriverNum() {
        return driverNum;
    }

    public void setDriverNum(String driverNum) {
        this.driverNum = driverNum;
    }

    public String getCarNum() {
        return carNum;
    }

    public void setCarNum(String carNum) {
        this.carNum = carNum;
    }

    public String getPaymentNum() {
        return paymentNum;
    }

    public void setPaymentNum(String paymentNum) {
        this.paymentNum = paymentNum;
    }

    public String getInsuranceNum() {
        return insuranceNum;
    }

    public void setInsuranceNum(String insuranceNum) {
        this.insuranceNum = insuranceNum;
    }

    public String getRentalStatus() {
        return rentalStatus;
    }

    public void setRentalStatus(String rentalStatus) {
        this.rentalStatus = rentalStatus;
    }
}
