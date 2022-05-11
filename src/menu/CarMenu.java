package menu;

import file.FileCarCSV;
import file.FileCarCompany;
import file.Path;
import input.Input;
import manage.ManageCar;
import manage.ManageCarCompany;
import manage.ManageCarName;
import manage.ManageUser;
import model.*;

import java.io.IOException;
import java.util.Scanner;

public class CarMenu {
    public static void menuCar() {
        System.out.println("------Quản lý oto-----");
        System.out.println("1. Hiển thị toàn bộ xe ");
        System.out.println("2. Tìm kiếm theo tên xe ");
        System.out.println("3. Tìm kiếm theo hãng xe ");
        System.out.println("4. Tìm kiếm theo giá xe ");
    }

    public static void menuCarTypeRole() {
        System.out.println("5. Thêm xe ");
        System.out.println("6. Xóa xe ");
        System.out.println("7. Sửa thông tin xe ");
        System.out.println("0. Thoát ");
        System.out.print("Nhập lựa chọn : ");
    }

    public static void menuDefault() {
        System.out.println("0. Thoát ");
        System.out.print("Nhập lựa chọn : ");
    }

    public static void menuCarTypeRoleAdmin() {
        System.out.println("5. Thêm xe ");
        System.out.println("6. Xóa xe ");
        System.out.println("7. Sửa thông tin xe ");
        System.out.println("8. Thêm hãng xe ");
        System.out.println("0. Thoát ");
        System.out.print("Nhập lựa chọn : ");
    }


}
