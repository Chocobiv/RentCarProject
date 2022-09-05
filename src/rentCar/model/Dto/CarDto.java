package rentCar.model.Dto;

public class CarDto {
    //1. 차량 필드
    private String carNum;          //차량번호 (PK)
    private String carName;         //렌트카이름
    private String carType;         //차종류
    private String carColor;        //색상
    private String carFuel;         //연료
    private String carOption;       //차량옵션
    private int carPersonnel;       //승차인원수
    private String carRegion;       //지역
    private String carDetail;       //상세정보
    private int cost;               //일일대여비용

    //2. 생성자
    public CarDto() {}

    public CarDto(String carNum, String carName, String carType, String carColor, String carFuel, String carOption, int carPersonnel, String carRegion, String carDetail, int cost) {
        this.carNum = carNum;
        this.carName = carName;
        this.carType = carType;
        this.carColor = carColor;
        this.carFuel = carFuel;
        this.carOption = carOption;
        this.carPersonnel = carPersonnel;
        this.carRegion = carRegion;
        this.carDetail = carDetail;
        this.cost = cost;
    }

//3. 메소드

    public String getCarNum() {
        return carNum;
    }

    public void setCarNum(String carNum) {
        this.carNum = carNum;
    }

    public String getCarName() {
        return carName;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }

    public String getCarType() {
        return carType;
    }

    public void setCarType(String carType) {
        this.carType = carType;
    }

    public String getCarColor() {
        return carColor;
    }

    public void setCarColor(String carColor) {
        this.carColor = carColor;
    }

    public String getCarFuel() {
        return carFuel;
    }

    public void setCarFuel(String carFuel) {
        this.carFuel = carFuel;
    }

    public String getCarOption() {
        return carOption;
    }

    public void setCarOption(String carOption) {
        this.carOption = carOption;
    }

    public int getCarPersonnel() {
        return carPersonnel;
    }

    public void setCarPersonnel(int carPersonnel) {
        this.carPersonnel = carPersonnel;
    }

    public String getCarRegion() {
        return carRegion;
    }

    public void setCarRegion(String carRegion) {
        this.carRegion = carRegion;
    }

    public String getCarDetail() {
        return carDetail;
    }

    public void setCarDetail(String carDetail) {
        this.carDetail = carDetail;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }
}
