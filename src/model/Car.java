package model;

public class Car {
    private int idCar;
    private CarName carName;
    private CarCompany companyCar;
    private int priceCar;
    private User user;
    public Car() {
    }

    public Car(int idCar, CarName nameCar, CarCompany companyCar, int priceCar, User user) {
        this.idCar = idCar;
        this.carName = nameCar;
        this.companyCar = companyCar;
        this.priceCar = priceCar;
        this.user = user;
    }

    public int getIdCar() {
        return idCar;
    }

    public void setIdCar(int idCar) {
        this.idCar = idCar;
    }

    public CarName getNameCar() {
        return carName;
    }

    public void setNameCar(CarName nameCar) {
        this.carName = nameCar;
    }

    public CarCompany getCompanyCar() {
        return companyCar;
    }

    public void setCompanyCar(CarCompany companyCar) {
        this.companyCar = companyCar;
    }

    public int getPriceCar() {
        return priceCar;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setPriceCar(int priceCar) {
        this.priceCar = priceCar;
    }

    @Override
    public String toString() {
        return "Car{" +
                "idCar=" + idCar +
                ", nameCar='" + carName.getName() + '\'' +
                ", companyCar='" + companyCar.getName() + '\'' +
                ", priceCar=" + priceCar +
                ", useradd='" + user.getUserName() + '\'' +
                '}';
    }
}
