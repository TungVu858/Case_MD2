package menu;

import file.FileRoleCSV;
import file.Path;
import input.Input;
import manage.ManageRole;
import model.DetailValid;
import model.Role;

import java.io.IOException;
import java.util.Scanner;

public class RoleMenu {
    public static void manageRole() {
        System.out.println("Quản lý Role ");
        System.out.println("1. Thêm role");
        System.out.println("2. Xóa role");
        System.out.println("0. Quay lại ");
        System.out.print("Nhập lựa chọn : ");
    }
}
