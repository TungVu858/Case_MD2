package file;

import manage.ManageUser;
import model.Car;
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
            str += car.getIdCar() + "," + car.getNameCar() + "," + car.getCompanyCar() + "," + car.getPriceCar() + "," + car.getUser().getUserName() +
                    "\n";
        }
        bufferedWriter.write(str);
        bufferedWriter.close();
    }

    public static List<Car> readFormFile(String path) throws IOException {
        List<Car> carList = new ArrayList<>();
        ManageUser manageUser = new ManageUser();
        FileReader fileReader = new FileReader(path);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String str = bufferedReader.readLine();
        while ((str = bufferedReader.readLine()) != null) {
            String[] value = str.split(",");
            User user = manageUser.findByName(value[4]);
            carList.add(new Car(Integer.parseInt(value[0]), value[1], value[2], Integer.parseInt(value[3]), user));
        }
        return carList;
    }
}
