package manage;

import file.FileUserCSV;
import file.Path;
import model.User;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ManageUser {
    List<User> userList = new ArrayList<>();
    public static User currentUser = new User();

    public ManageUser() throws IOException {
        userList = FileUserCSV.readFromFile(Path.PATH_USER);
    }

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    public int login(String username, String pass) {
        for (User user : userList) {
            if (username.equals(user.getUserName()) && pass.equals(user.getUserPass())) {
                currentUser = user;
                return 1;
            }
        }
        return 0;
    }

    public void register(User user) {
        userList.add(user);
    }

    public User findById(int id) {
        return userList.get(findByIndexId(id));
    }

    public User findByName(String name) {
        return userList.get(findByUserName(name));
    }

    public int findByIndexId(int id) {
        for (int i = 0; i < userList.size(); i++) {
            if (id == userList.get(i).getIdUsers()) {
                return i;
            }
        }
        return -1;
    }

    public void edit(int id, User user) {
        userList.set(findByIndexId(id), user);
    }


    public int findByUserName(String username) {
        for (int i = 0; i < userList.size(); i++) {
            if (username.equals(userList.get(i).getUserName())) {
                return i;
            }
        }
        return -1;
    }

    public void displayAll() {
        for (User user : userList) {
            System.out.println(user);
        }
    }

    public void displayUser(String name, String pass) {
        for (User user : userList) {
            if (name.equals(user.getUserName()) && pass.equals(user.getUserPass())) {
                System.out.println(user);
            }
        }
    }

    public String displayUserName(String name) {
        String str = "Tài khoản : ";
        for (User user : userList) {
            if (name.equals(user.getUserName())) {
                str += user.getUserName();
            }
        }
        return str;
    }
}
