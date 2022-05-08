package file;

import model.Car;
import model.CarCompany;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileCarCompany {
    public static void writeToFile(String path, List<CarCompany> carCompanyList) throws IOException {
        FileWriter fileWriter = new FileWriter(path);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        String str = "id,tên hãng\n";
        for (CarCompany carCompany : carCompanyList) {
            str += carCompany.getId() + "," + carCompany.getName()+ "\n";
        }
        bufferedWriter.write(str);
        bufferedWriter.close();
    }
    public static List<CarCompany> readFromFile(String path) throws IOException {
        List<CarCompany> carCompanyList = new ArrayList<>();
        FileReader fileReader = new FileReader(path);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String str = bufferedReader.readLine();
        while ((str = bufferedReader.readLine())!=null){
            String[] value = str.split(",");
            carCompanyList.add(new CarCompany(Integer.parseInt(value[0]),value[1]));
        }
        return carCompanyList;
    }

}
