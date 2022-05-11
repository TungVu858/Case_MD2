package manage;

import file.FileCarNameCSV;
import model.CarName;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ManageCarName {
    List<CarName> carNameList = new ArrayList<>();
    private static ManageCarName instance = null;

    public static ManageCarName getInstance() throws IOException {
        if (instance == null) {
            instance = new ManageCarName();
        }
        return instance;
    }

    public ManageCarName() throws IOException {
        carNameList = FileCarNameCSV.readFromFile("carname.csv");
    }

    public List<CarName> getCarNameList() {
        return carNameList;
    }

    public void setCarNameList(List<CarName> carNameList) {
        this.carNameList = carNameList;
    }

    public void addCarName(CarName carName) {
        carNameList.add(carName);
    }

    public int findByIndexCarName(int id) {
        for (int i = 0; i < carNameList.size(); i++) {
            if (id == carNameList.get(i).getId()) {
                return i;
            }
        }
        return -1;
    }

    public int findByNameCar(String name) {
        for (int i = 0; i < carNameList.size(); i++) {
            if (carNameList.get(i).getName().equals(name)) {
                return i;
            }
        }
        return -1;
    }

    public CarName findById(int id) {
        return carNameList.get(findByIndexCarName(id));
    }

    public CarName findByName(String name) {
        return carNameList.get(findByNameCar(name));
    }

    public void displayAllCompany() {
        for (CarName carName : carNameList) {
            System.out.println(carName);
        }
    }
    public void displayCarToyota(){
        for (CarName carName : carNameList){
            if (carName.getName().contains("Toyota")){
                System.out.println(carName);
            }
        }
    }
    public void displayCarFerrari(){
        for (CarName carName : carNameList){
            if (carName.getName().contains("Ferrari")){
                System.out.println(carName);
            }
        }
    }
    public void displayCarFord(){
        for (CarName carName : carNameList){
            if (carName.getName().contains("Ford")){
                System.out.println(carName);
            }
        }
    }
    public void displayCarBMW(){
        for (CarName carName : carNameList){
            if (carName.getName().contains("BMW")){
                System.out.println(carName);
            }
        }
    }
    public void displayCarMazda(){
        for (CarName carName : carNameList){
            if (carName.getName().contains("Mazda")){
                System.out.println(carName);
            }
        }
    }
    public void displayCarKia(){
        for (CarName carName : carNameList){
            if (carName.getName().contains("Kia")){
                System.out.println(carName);
            }
        }
    }
    public void displayCarHonda(){
        for (CarName carName : carNameList){
            if (carName.getName().contains("Honda")){
                System.out.println(carName);
            }
        }
    }
}
