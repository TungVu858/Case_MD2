package model;

import file.FileCarNameCSV;
import manage.ManageCarName;

import java.io.IOException;

public class MainTest {
    public static void main(String[] args) throws IOException {
        ManageCarName manageCarName = new ManageCarName();
        manageCarName.addCarName(new CarName(1,"Ferrari 2022"));
        manageCarName.addCarName(new CarName(2,"Kia Morning"));
        manageCarName.addCarName(new CarName(3,"Toyota Fortune"));
        manageCarName.addCarName(new CarName(4,"Toyota Land Cruiser Prado"));
        manageCarName.addCarName(new CarName(5,"Toyota Camry"));
        FileCarNameCSV.writeToFile("Case_MD2/carname.csv",manageCarName.getCarNameList());

    }
}
