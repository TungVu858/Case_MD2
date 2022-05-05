package manage;

import file.FileCarCSV;
import file.Path;
import model.Car;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ManageCar {
    List<Car> carList = new ArrayList<>();

    public ManageCar() throws IOException {
        carList = FileCarCSV.readFormFile(Path.PATH_CAR);
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

    public int findByInDexCar(int id) {
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
        boolean check = false;
        for (int i = 0; i < carList.size(); i++) {
            if (carList.get(i).getNameCar().contains(name)) {
                return i;
            }
        }
        return -1;
    }

    public void displayNameCar(String name) {
        boolean check = false;
        for (Car car : carList) {
            if (car.getNameCar().contains(name)) {
                System.out.println(car);
                check = true;
            }
        }
        if (!check) System.out.println("Không tìm thấy tên xe !!!");
    }

    public void displayCompanyCar(String company) {
        boolean check = false;
        for (Car car : carList) {
            if (car.getCompanyCar().equals(company)) {
                System.out.println(car);
                check = true;
            }
        }
        if (!check) System.out.println("Hãng xe này chưa có !!!!");
    }

    public void delete(int id) {
        carList.remove(findByInDexCar(id));
    }

    public void displayByPrice(int price, int price1) {
        boolean check = false;
        for (Car car : carList) {
            if (price < car.getPriceCar() && price1 > car.getPriceCar()) {
                System.out.println(car);
                check = true;
            }
        }
        if (!check) System.out.println("Không tìm thấy xe trong khoảng phù hợp ");
    }
    public void edit(int id,Car car){
        carList.set(findByInDexCar(id),car);
    }
}
