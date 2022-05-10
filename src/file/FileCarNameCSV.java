package file;

import manage.ManageCarName;
import model.CarName;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileCarNameCSV {
    public static void writeToFile(String path, List<CarName> carNameList) throws IOException {
        FileWriter fileWriter = new FileWriter(path);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        String str = "id,tên \n";
        for (CarName carName : carNameList) {
            str += carName.getId() + "," + carName.getName() + "\n";
        }
        bufferedWriter.write(str);
        bufferedWriter.close();
    }

    public static List<CarName> readFromFile(String path) throws IOException {
        List<CarName> carNameList = new ArrayList<>();
        FileReader fileReader = new FileReader(path);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String str = bufferedReader.readLine();
        while ((str= bufferedReader.readLine())!=null){
            String []value = str.split(",");
            carNameList.add(new CarName(Integer.parseInt(value[0]),value[1]));
        }
        return carNameList;
    }
}
