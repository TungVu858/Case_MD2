package manage;

import file.FileCarCSV;
import file.Path;
import model.Car;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ManageCar {
    private List<Car> carList = new ArrayList<>();

    public ManageCar(ManageUser manageUser) throws IOException {
        carList = FileCarCSV.readFormFile(Path.PATH_CAR,manageUser,ManageCarCompany.getInstance(),ManageCarName.getInstance());
    }

    public List<Car> getCarList() {
        return carList;
    }

    public void setCarList(List<Car> carList) {
        this.carList = carList;
    }

    public void add(Car car) {
        carList.add(car);
    }

    public int findByIndexCar(int id) {
        for (int i = 0; i < carList.size(); i++) {
            if (id == carList.get(i).getIdCar()) {
                return i;
            }
        }
        return -1;
    }

    public void displayAll() {
        for (Car car : carList) {
            System.out.println(car);
        }
    }

    public int findByNameCar(String name) {
        for (int i = 0; i < carList.size(); i++) {
            if (carList.get(i).getNameCar().getName().contains(name)) {
                return i;
            }
        }
        return -1;
    }

    public void displayNameCar(String name) {
        boolean check = false;
        for (Car car : carList) {
            if (car.getNameCar().getName().contains(name)) {
                System.out.println(car);
                check = true;
            }
        }
        if (!check) System.out.println("\u001B[31m" + "Không tìm thấy tên xe !!!" + "\u001B[0m");
    }

    public void displayCompanyCar(String company) {
        boolean check = false;
        for (Car car : carList) {
            if (car.getCompanyCar().getName().contains(company)) {
                System.out.println(car);
                check = true;
            }
        }
        if (!check) System.out.println("\u001B[31m" + "Hãng xe này chưa có !!!!" + "\u001B[0m");
    }
    public void displayCarFord(){
        for (Car car:carList) {
            if (car.getCompanyCar().getName().contains("Ford")){
                System.out.println(car);
            }
        }
    }
    public void displayCarToyota(){
        for (Car car:carList) {
            if (car.getCompanyCar().getName().contains("Toyota")){
                System.out.println(car);
            }
        }
    }
    public void displayCarFerrari(){
        for (Car car:carList) {
            if (car.getCompanyCar().getName().contains("Ferrari")){
                System.out.println(car);
            }
        }
    }
    public void displayCarHonda(){
        for (Car car:carList) {
            if (car.getCompanyCar().getName().contains("Honda")){
                System.out.println(car);
            }
        }
    }
    public void displayCarKia(){
        for (Car car:carList) {
            if (car.getCompanyCar().getName().contains("Kia")){
                System.out.println(car);
            }
        }
    }
    public void displayCarMazda(){
        for (Car car:carList) {
            if (car.getCompanyCar().getName().contains("Mazda")){
                System.out.println(car);
            }
        }
    }
    public void displayCarBMW(){
        for (Car car:carList) {
            if (car.getCompanyCar().getName().contains("BMW")){
                System.out.println(car);
            }
        }
    }
    public void delete(int id) {
        carList.remove(findByIndexCar(id));
    }

    public void displayByPrice(int price, int price1) {
        boolean check = false;
        for (Car car : carList) {
            if (price <= car.getPriceCar() && price1 >= car.getPriceCar()) {
                System.out.println(car);
                check = true;
            }
        }
        if (!check) System.out.println("\u001B[31m" + "Không tìm thấy xe trong khoảng phù hợp " + "\u001B[0m");
    }

    public void displayById(int id) {
        for (Car car : carList) {
            if (car.getIdCar() == id) {
                System.out.println(car);
            }
        }
    }

    public void edit(int id, Car car) {
        carList.set(findByIndexCar(id), car);
    }
}

