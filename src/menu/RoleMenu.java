package menu;

import file.FileRoleCSV;
import file.Path;
import input.Input;
import manage.ManageRole;
import model.Role;

import java.io.IOException;
import java.util.Scanner;

public class RoleMenu {
    public static void manageRole(){
        System.out.println("Quản lý Role ");
        System.out.println("1. Thêm role");
        System.out.println("2. Xóa role");
        System.out.println("0. Quay lại ");
        System.out.print("Nhập lựa chọn : ");
    }
    public static void addRole() throws IOException {
        ManageRole manageRole = new ManageRole();
        Scanner scc = new Scanner(System.in);
        int idRole = Input.checkExceptionNumber("Nhập id Role : ");
        if (manageRole.findByIndexId(idRole) == -1) {
            System.out.println("Nhập tên Role : ");
           String  nameRole = scc.nextLine();
            if (manageRole.findByNameRole(nameRole) == -1) {
                System.out.println("Nhập mô tả : ");
                String description = scc.nextLine();
                manageRole.add(new Role(idRole, nameRole, description));
                System.out.println("Bạn đã thêm thành công role " + nameRole);
                FileRoleCSV.writeToFile(Path.PATH_ROLE, manageRole.getRoles());
            } else System.out.println("Tên Role đã tồn tại !!");
        } else System.out.println("Id Role đã tồn tại !!");
    }
    public static void deleteRole() throws IOException {
        ManageRole manageRole = new ManageRole();
        Scanner scc = new Scanner(System.in);
        int idRole = Input.checkExceptionNumber("Nhập id role cần xóa : ");
        if (manageRole.findByIndexId(idRole) != -1) {
            System.out.println("Thông tin role : ");
            System.out.println("id,tên,mô tả");
            manageRole.displayRole(idRole);
            System.out.println("Bạn có xác nhận xóa hay không y/n");
            String flag = scc.nextLine();
            if (flag.equals("y")) {
                manageRole.delete(idRole);
                System.out.println("Bạn đã xóa thành công !!");
            } else System.out.println("Xóa thất bại !!");
        } else System.out.println("Không tìm thấy id role này !!!");
    }
}
