package file;

import manage.ManageRole;
import model.Role;
import model.User;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileUserCSV {
    public static void writeToFile(String path, List<User> userList) throws IOException {
        FileWriter fileWriter = new FileWriter(path);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        String str = "id,name,pass,status,role \n";
        for (User user : userList) {
            str += user;
        }
        bufferedWriter.write(str);
        bufferedWriter.close();
    }

    public static List<User> readFromFile(String path) throws IOException {
        List<User> userList = new ArrayList<>();
        ManageRole manageRole = new ManageRole();
        FileReader fileReader = new FileReader(path);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String str = bufferedReader.readLine();
        while ((str = bufferedReader.readLine()) != null) {
            if (str.equals("")) {
                break;
            }
            String[] value = str.split(",");
            Role role = manageRole.findById(Integer.parseInt(value[4]));
            userList.add(new User(Integer.parseInt(value[0]), value[1], value[2], value[3], role));
        }
        return userList;
    }
}
