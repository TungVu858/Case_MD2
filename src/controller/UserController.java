package controller;

import file.FileUserCSV;
import file.Path;
import input.Input;
import manage.ManageRole;
import manage.ManageUser;
import model.DetailValid;
import model.Role;

import java.io.IOException;
import java.util.Scanner;

public class UserController {
    public static void register(ManageUser manageUser, ManageRole manageRole) throws IOException {
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
                        while (true) {
                            System.out.println("Nhập vào mật khẩu : ");
                            String pass = scc.nextLine();
                            if (Input.validate(new DetailValid(Input.USER_PASS, Input.NOT_VALID_USER_PASS), pass)) {
                                while (true) {
                                    System.out.println("Nhập lại mật khẩu : ");
                                    String rePass = scc.nextLine();
                                    if (Input.validate(new DetailValid(Input.USER_PASS, Input.NOT_VALID_USER_PASS), rePass)) {
                                        if (pass.equals(rePass)) {
                                            manageRole.displayAll();
                                            int idRole = Input.checkExceptionNumberIdUser("Nhập vào id Role : ", manageRole);
                                            Role role = manageRole.findById(idRole);
                                            manageUser.register(new model.User(id, username, pass, status, role));
                                            System.out.println(Input.ANSI_BLUE + "Bạn đã tạo tài khoản thành công!!" + Input.ANSI_RESET);
                                            FileUserCSV.writeToFile(Path.PATH_USER, manageUser.getUserList());
                                            break;
                                        } else
                                            System.out.println(Input.CHECK_PASS_DUPE);
                                        break;
                                    }
                                }
                                break;
                            }
                        }
                    } else System.out.println(Input.CHECK_USER_NAME_DUPE);
                    break;
                }
            }
        } else System.out.println(Input.CHECK_USER_ID_DUPE);
    }
    public static void changePass(ManageUser manageUser) throws IOException {
        Scanner scc = new Scanner(System.in);
        while (true) {
            System.out.println("Nhập pass mới : ");
            String newPass = scc.nextLine();
            if (Input.validate(new DetailValid(Input.USER_PASS, Input.NOT_VALID_USER_PASS), newPass)) {
                ManageUser.currentUser.setUserPass(newPass);
                System.out.println(Input.ANSI_BLUE + "Bạn đã đổi mật khẩu thành công !!" + Input.ANSI_RESET);
                FileUserCSV.writeToFile(Path.PATH_USER, manageUser.getUserList());
                break;
            }
        }
    }
}
