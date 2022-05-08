package file;

import manage.ManageCarCompany;
import manage.ManageUser;
import model.Car;
import model.CarCompany;
import model.User;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileCarCSV {
    public static void writeToFile(String path, List<Car> carList) throws IOException {
        FileWriter fileWriter = new FileWriter(path);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        String str = "id,tên,hãng,giá,người thêm\n";
        for (Car car : carList) {
            str += car.getIdCar() + "," + car.getNameCar() + "," + car.getCompanyCar().getName() + "," + car.getPriceCar() + "," + car.getUser().getUserName() +
                    "\n";
        }
        bufferedWriter.write(str);
        bufferedWriter.close();
    }

    public static List<Car> readFormFile(String path,ManageUser manageUser,ManageCarCompany manageCarCompany) throws IOException {
        List<Car> carList = new ArrayList<>();
        FileReader fileReader = new FileReader(path);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String str = bufferedReader.readLine();
        while ((str = bufferedReader.readLine()) != null) {
            String[] value = str.split(",");
            User user = manageUser.findByName(value[4]);
            CarCompany carCompany = manageCarCompany.findByName(value[2]);
            carList.add(new Car(Integer.parseInt(value[0]), value[1], carCompany, Integer.parseInt(value[3]), user));
        }
        return carList;
    }
}
