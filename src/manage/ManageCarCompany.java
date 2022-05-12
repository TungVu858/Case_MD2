package manage;

import file.FileCarCompany;
import file.Path;
import model.CarCompany;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ManageCarCompany {
    private List<CarCompany> carCompanyList = new ArrayList<>();
    private static ManageCarCompany instance = null;
    public ManageCarCompany() throws IOException {
        carCompanyList = FileCarCompany.readFromFile(Path.PATH_CAR_COMPANY);
    }
    public static ManageCarCompany getInstance() throws IOException {
        if (instance == null){
            instance = new ManageCarCompany();
        }
        return instance;
    }
    public List<CarCompany> getCarCompanyList() {
        return carCompanyList;
    }

    public void setCarCompanyList(List<CarCompany> carCompanyList) {
        this.carCompanyList = carCompanyList;
    }

    public void addCompany(CarCompany carCompany) {
        carCompanyList.add(carCompany);
    }

    public int findByIndexCompany(int id) {
        for (int i = 0; i < carCompanyList.size(); i++) {
            if (id == carCompanyList.get(i).getId()){
                return i;
            }
        }
        return -1;
    }
    public int findByNameCompany(String name){
        for (int i = 0; i < carCompanyList.size(); i++) {
            if (carCompanyList.get(i).getName().equals(name)){
                return i;
            }
        }
        return -1;
    }
    public CarCompany findById(int id) {
        return carCompanyList.get(findByIndexCompany(id));
    }
    public CarCompany findByName(String name){
        return carCompanyList.get(findByNameCompany(name));
    }
    public void displayAllCompany() {
        for (CarCompany carCompany : carCompanyList) {
            System.out.println(carCompany);
        }
    }

    public void editCompany(int id, CarCompany carCompany) {
        carCompanyList.set(findByIndexCompany(id), carCompany);
    }

    public void deleteCompany(int id) {
        carCompanyList.remove(findByIndexCompany(id));
    }
}
