package file;

import model.Role;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileRoleCSV {
    public static void writeToFile(String path, List<Role> roleList) throws IOException {
        FileWriter fileWriter = new FileWriter(path);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        String str = "id,name,description\n";
        for (Role role : roleList) {
            str += role;
        }
        bufferedWriter.write(str);
        bufferedWriter.close();
    }

    public static List<Role> readFromFile(String path) throws IOException {
        List<Role> roleList = new ArrayList<>();
        FileReader fileReader = new FileReader(path);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String str = bufferedReader.readLine();
        while ((str = bufferedReader.readLine()) != null) {
            if (str.equals("")) {
                break;
            }
            String[] value = str.split(",");
            roleList.add(new Role(Integer.parseInt(value[0]), value[1], value[2]));
        }
        return roleList;
    }
}
