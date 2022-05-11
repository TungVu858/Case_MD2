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
        System.out.println("0. Logout");
        System.out.print("Nhập lựa chọn : ");
    }

    public static void mainLoginAdmin() {
        System.out.println("------Menu Login-------");
        System.out.println("1. Vào trang quản lý  ");
        System.out.println("2. Xem thông tin tài khoản  ");
        System.out.println("3. Đổi mật khẩu ");
        System.out.println("4. Thêm , xóa role");
        System.out.println("0. Logout");
        System.out.print("Nhập lựa chọn : ");
    }

    public static void information() {
        System.out.println(Input.ANSI_BLUE + "Thông tin tài khoản của bạn : " + Input.ANSI_RESET);
        System.out.println("id,tên,mật khẩu,status,role");
        System.out.println(ManageUser.currentUser);
    }
}
