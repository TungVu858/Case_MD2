package menu;

import file.FileUserCSV;
import file.Path;
import input.Input;
import manage.ManageRole;
import manage.ManageUser;
import model.Role;
import model.User;

import java.io.IOException;
import java.util.Scanner;

public class UserMenu {
    public static void login() throws IOException {
        ManageUser manageUser = new ManageUser();
        Scanner scc = new Scanner(System.in);
        System.out.println("Đăng nhập ");
        System.out.println("Nhập tài khoản : ");
        String username = scc.nextLine();
        System.out.println("Nhập mật khẩu : ");
        String pass = scc.nextLine();
        if (manageUser.login(username, pass) == 1) {
            System.out.println("Đăng nhập thành công !!!");
            System.out.println(manageUser.displayUserName(username));
        }else System.out.println("Bạn nhập sai tên đ");
    }
    public static void mainLogin(){
        System.out.println("------Menu Login-------");
        System.out.println("1. Vào trang quản lý  ");
        System.out.println("2. Xem thông tin tài khoản  ");
        System.out.println("3. Đổi mật khẩu ");
        if (ManageUser.currentUser.getRole().getNameRole().equals("Admin")) {
            System.out.println("4. Thêm , xóa role");
        }
        System.out.println("0. Logout");
        System.out.print("Nhập lựa chọn : ");
    }
    public static void information(){
        System.out.println("Thông tin tài khoản của bạn : ");
        System.out.println("id,tên,mật khẩu,status,role");
        System.out.println(ManageUser.currentUser);
    }
    public static void rePass() throws IOException {
        Scanner scc = new Scanner(System.in);
        ManageUser manageUser = new ManageUser();
        System.out.println("Nhập pass mới : ");
        String newPass = scc.nextLine();
        ManageUser.currentUser.setUserPass(newPass);
        System.out.println("Bạn đã đổi mật khẩu thành công !!");
        FileUserCSV.writeToFile(Path.PATH_USER, manageUser.getUserList());
    }
    public static void register() throws IOException {
        ManageUser manageUser = new ManageUser();
        ManageRole manageRole = new ManageRole();
        Scanner scc = new Scanner(System.in);
        String status = "1";
        System.out.println("Đăng kí ");
        int id = Input.checkExceptionNumber("Nhập vào id : ");
        if (manageUser.findByIndexId(id) == -1) {
            System.out.println("Nhập vào tài khoản : ");
            String username = scc.nextLine();
            if (manageUser.findByUserName(username) == -1) {
                System.out.println("Nhập vào mật khẩu : ");
                String pass = scc.nextLine();
                System.out.println("Nhập lại mật khẩu : ");
                String rePass = scc.nextLine();
                if (pass.equals(rePass)) {
                    manageRole.displayAll();
                    int idRole = Input.checkExceptionNumber("Nhập vào id Role : ");
                    Role role = manageRole.findById(idRole);
                    manageUser.register(new User(id, username, pass, status, role));
                    System.out.println("Bạn đã tạo tài khoản thành công!!");
                    FileUserCSV.writeToFile(Path.PATH_USER, manageUser.getUserList());
                } else {
                    System.out.println("Nhập 2 mật khẩu phải trùng nhau !!");
                }
            } else System.out.println("Tài khoản đã tồn tại !!!");
        } else System.out.println("Id tài khoản đã tồn tại !!!");
    }
}
