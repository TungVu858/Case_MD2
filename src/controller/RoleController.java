package controller;

import file.FileRoleCSV;
import file.Path;
import input.Input;
import manage.ManageRole;
import model.DetailValid;

import java.io.IOException;
import java.util.Scanner;

public class RoleController {
    public static void addRole(ManageRole manageRole) throws IOException {
        Scanner scc = new Scanner(System.in);
        int idRole = Input.checkExceptionNumber("Nhập id Role : ");
        if (manageRole.findByIndexId(idRole) == -1) {
            System.out.println("Nhập tên Role : ");
            String nameRole = scc.nextLine();
            if (manageRole.findByNameRole(nameRole) == -1) {
                System.out.println("Nhập mô tả : ");
                String description = scc.nextLine();
                manageRole.add(new model.Role(idRole, nameRole, description));
                System.out.println(Input.ANSI_BLUE + "Bạn đã thêm thành công role " + nameRole + Input.ANSI_RESET);
                FileRoleCSV.writeToFile(Path.PATH_ROLE, manageRole.getRoles());
            } else System.out.println("\u001B[31m" + "Tên Role đã tồn tại !!" + "\u001B[0m");
        } else System.out.println("\u001B[31m" + "Id Role đã tồn tại !!" + "\u001B[0m");
    }
    public static void deleteRole(ManageRole manageRole) throws IOException {
        Scanner scc = new Scanner(System.in);
        int idRole = Input.checkExceptionNumber("Nhập id role cần xóa : ");
        if (manageRole.findByIndexId(idRole) != -1) {
            while (true) {
                System.out.println(Input.ANSI_BLUE + "Thông tin role : " + Input.ANSI_RESET);
                System.out.println(Input.ANSI_BLUE + "id,tên,mô tả" + Input.ANSI_RESET);
                manageRole.displayRole(idRole);
                System.out.println(Input.ANSI_BLUE + "Bạn có xác nhận xóa hay không y/n" + Input.ANSI_RESET);
                String flag = scc.nextLine();
                if (Input.validate(new DetailValid(Input.ANSWER, Input.NOT_VALID_ANSWER), flag)) {
                    if (flag.equals("y") || flag.equals("Y")) {
                        manageRole.delete(idRole);
                        System.out.println(Input.ANSI_BLUE + "Bạn đã xóa thành công !!" + Input.ANSI_RESET);
                        FileRoleCSV.writeToFile(Path.PATH_ROLE, manageRole.getRoles());
                        break;
                    } else System.out.println("\u001B[31m" + "Xóa thất bại !!" + "\u001B[0m");
                    break;
                }
            }
        } else System.out.println("\u001B[31m" + "Không tìm thấy id role này !!!" + "\u001B[0m");
    }
}
