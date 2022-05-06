package menu;

import file.FileUserCSV;
import file.Path;
import input.Input;
import manage.ManageRole;
import manage.ManageUser;
import model.DetailValid;
import model.Role;
import model.User;
import java.io.IOException;
import java.util.Scanner;

public class UserMenu {

    public static void mainLogin() {
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

    public static void information() {
        System.out.println("Thông tin tài khoản của bạn : ");
        System.out.println("id,tên,mật khẩu,status,role");
        System.out.println(ManageUser.currentUser);
    }

    public static void rePass(ManageUser manageUser) throws IOException {
        Scanner scc = new Scanner(System.in);
        while (true) {
            System.out.println("Nhập pass mới : ");
            String newPass = scc.nextLine();
            if (Input.validate(new DetailValid(Input.USER_PASS, Input.NOT_VALID_USER_PASS), newPass)) {
                ManageUser.currentUser.setUserPass(newPass);
                System.out.println("Bạn đã đổi mật khẩu thành công !!");
                FileUserCSV.writeToFile(Path.PATH_USER, manageUser.getUserList());
                break;
            }
        }
    }

    public static void register() throws IOException {
        ManageUser manageUser = new ManageUser();
        ManageRole manageRole = new ManageRole();
        Scanner scc = new Scanner(System.in);
        String status = "1";
        System.out.println("Đăng kí ");
        int id = Input.checkExceptionNumber("Nhập vào id : ");
        if (manageUser.findByIndexId(id) == -1) {
            while (true) {
                System.out.println("Nhập vào tài khoản : ");
                String username = scc.nextLine();
                if (Input.validate(new DetailValid(Input.USER_NAME, Input.NOT_VALID_USER_NAME), username)) {
                    if (manageUser.findByUserName(username) == -1) {
                        while (true){
                            System.out.println("Nhập vào mật khẩu : ");
                            String pass = scc.nextLine();
                            if (Input.validate(new DetailValid(Input.USER_PASS, Input.NOT_VALID_USER_PASS), pass)) {
                                while (true){
                                    System.out.println("Nhập lại mật khẩu : ");
                                    String rePass = scc.nextLine();
                                    if (Input.validate(new DetailValid(Input.USER_PASS, Input.NOT_VALID_USER_PASS), rePass)) {
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
                                        break;
                                    }
                                }
                                break;
                            }
                        }
                    } else System.out.println("Tài khoản đã tồn tại !!!");
                    break;
                }
            }
        } else System.out.println("Id tài khoản đã tồn tại !!!");
    }
}
