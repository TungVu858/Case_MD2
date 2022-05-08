package model;

public class Car {
    private int idCar;
    private String nameCar;
    private CarCompany companyCar;
    private int priceCar;
    private User user;
    public Car() {
    }

    public Car(int idCar, String nameCar, CarCompany companyCar, int priceCar, User user) {
        this.idCar = idCar;
        this.nameCar = nameCar;
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

    public String getNameCar() {
        return nameCar;
    }

    public void setNameCar(String nameCar) {
        this.nameCar = nameCar;
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
                ", nameCar='" + nameCar + '\'' +
                ", companyCar='" + companyCar.getName() + '\'' +
                ", priceCar=" + priceCar +
                ", useradd='" + user.getUserName() + '\'' +
                '}';
    }
}
