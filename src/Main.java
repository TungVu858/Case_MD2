import file.FileCarCSV;
import file.FileRoleCSV;
import file.FileUserCSV;
import file.Path;
import input.Input;
import manage.ManageCar;
import manage.ManageRole;
import manage.ManageUser;
import menu.Menu;
import menu.RoleMenu;
import menu.UserMenu;
import model.Car;
import model.Role;
import model.User;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        ManageUser manageUser = new ManageUser();
        ManageRole manageRole = new ManageRole();
        ManageCar manageCar = new ManageCar();
        Scanner scc = new Scanner(System.in);
        Scanner scs = new Scanner(System.in);
        int id;
        String username;
        String pass;
        String status = "1";
        int idRole;
        String nameRole;
        String description;
        String carName;
        String carCompany;
        int idCar;
        int priceCar;
        int choice = -1;
        while (choice != 0) {
            manageUser.setUserList(FileUserCSV.readFromFile(Path.PATH_USER));
            Menu.mainMenu();
            choice = Input.checkMenu2Op(scs, choice);
            switch (choice) {
                case 1:
                    System.out.println("Đăng nhập ");
                    System.out.println("Nhập tài khoản : ");
                    username = scc.nextLine();
                    System.out.println("Nhập mật khẩu : ");
                    pass = scc.nextLine();
                    if (manageUser.login(username, pass) == 1) {
                        System.out.println("Đăng nhập thành công !!!");
                        System.out.println(manageUser.displayUserName(username));
                        int choice_1 = -1;
                        while (choice_1 != 0) {
                            System.out.println("-------Menu Login-------");
                            System.out.println("1. Vào trang quản lý ");
                            System.out.println("2. Xem thông tin tài khoản ");
                            System.out.println("3. Đổi mật khẩu ");
                            if (ManageUser.currentUser.getRole().getNameRole().equals("Admin")) {
                                System.out.println("4. Thêm , xóa role");
                            }
                            System.out.println("0. Logout");
                            System.out.print("Nhập lựa chọn : ");
                            choice_1 = Input.checkMenu4Op(scs, choice_1);
                            switch (choice_1) {
                                case 1:
                                    int choice_3 = -1;
                                    while (choice_3 != 0) {
                                        System.out.println("------Quản lý oto-----");
                                        System.out.println("1. Hiển thị toàn bộ xe ");
                                        System.out.println("2. Tìm kiếm theo tên xe ");
                                        System.out.println("3. Tìm kiếm theo hãng xe ");
                                        System.out.println("4. Tìm kiếm theo giá xe ");
                                        if (ManageUser.currentUser.getRole().getNameRole().equals("Admin") || ManageUser.currentUser.getRole().getNameRole().equals("Manage")) {
                                            System.out.println("5. Thêm xe ");
                                            System.out.println("6. Xóa xe ");
                                            System.out.println("7. Sửa thông tin xe ");
                                            System.out.println("0. Thoát ");
                                            System.out.print("Nhập lựa chọn : ");
                                            choice_3 = Input.checkMenu7Op(scs, choice_3);
                                        } else {
                                            System.out.println("0. Thoát ");
                                            System.out.print("Nhập lựa chọn : ");
                                            choice_3 = Input.checkMenu4Op(scs, choice_3);
                                        }
                                        switch (choice_3) {
                                            case 1:
                                                System.out.println("Toàn bộ xe ");
                                                manageCar.displayAll();
                                                break;
                                            case 2:
                                                System.out.println("Nhập vào tên xe cần tìm ");
                                                carName = scc.nextLine();
                                                manageCar.displayNameCar(carName);
                                                break;
                                            case 3:
                                                System.out.println("Nhập tên hãng xe cần tìm ");
                                                carCompany = scc.nextLine();
                                                manageCar.displayCompanyCar(carCompany);
                                                break;
                                            case 4:
                                                System.out.println("Tìm kiếm theo giá ");
                                                priceCar = Input.checkExceptionNumber("Nhập giá tiền từ : ");
                                                int priceCar1 = Input.checkExceptionNumber("đến");
                                                manageCar.displayByPrice(priceCar, priceCar1);
                                                break;
                                            case 5:
                                                idCar = Input.checkExceptionNumber("Nhập id xe : ");
                                                if (manageCar.findByInDexCar(idCar) == -1) {
                                                    System.out.println("Nhập tên xe : ");
                                                    carName = scc.nextLine();
                                                    System.out.println("Nhập hãng xe : ");
                                                    carCompany = scc.nextLine();
                                                    priceCar = Input.checkExceptionNumber("Nhập giá tiền xe : ");
                                                    User user = manageUser.findById(ManageUser.currentUser.getIdUsers());
                                                    manageCar.add(new Car(idCar, carName, carCompany, priceCar, user));
                                                    System.out.println("Bạn đã thêm thành công " + carName);
                                                    FileCarCSV.writeToFile(Path.PATH_CAR, manageCar.getCarList());
                                                } else System.out.println("Id xe đã có !!!");
                                                break;
                                            case 6:
                                                idCar = Input.checkExceptionNumber("Nhập id xe cần xóa : ");
                                                if (manageCar.findByInDexCar(idCar) != -1) {
                                                    manageCar.delete(idCar);
                                                    System.out.println("Bạn đã xóa thành công!!");
                                                    FileCarCSV.writeToFile(Path.PATH_CAR, manageCar.getCarList());
                                                } else System.out.println("Không tìm thấy id xe !!");
                                                break;
                                            case 7:
                                                idCar = Input.checkExceptionNumber("Nhập id xe cần sửa thông tin : ");
                                                if (manageCar.findByInDexCar(idCar) != -1) {
                                                    System.out.println("Nhập tên xe : ");
                                                    carName = scc.nextLine();
                                                    System.out.println("Nhập hãng xe : ");
                                                    carCompany = scc.nextLine();
                                                    priceCar = Input.checkExceptionNumber("Nhập giá xe : ");
                                                    User user = manageUser.findById(ManageUser.currentUser.getIdUsers());
                                                    manageCar.edit(idCar, new Car(idCar, carName, carCompany, priceCar, user));
                                                    System.out.println("Bạn đã sửa thành công " + carName);
                                                    FileCarCSV.writeToFile(Path.PATH_CAR, manageCar.getCarList());
                                                } else System.out.println("Không tìm thấy id xe!!!");
                                                break;
                                        }
                                    }
                                    break;
                                case 2:
                                    System.out.println("Thông tin tài khoản của bạn : ");
                                    System.out.println("id,tên,mật khẩu,status,role");
                                    System.out.println(ManageUser.currentUser);
                                    break;
                                case 3:
                                    System.out.println("Nhập pass mới : ");
                                    String newPass = scc.nextLine();
                                    ManageUser.currentUser.setUserPass(newPass);
                                    System.out.println("Bạn đã đổi mật khẩu thành công !!");
                                    FileUserCSV.writeToFile(Path.PATH_USER, manageUser.getUserList());
                                    break;
                                case 4:
                                    int choice_2 = -1;
                                    while (choice_2 != 0) {
                                        RoleMenu.manageRole();
                                        choice_2 = Input.checkMenu2Op(scs, choice_2);
                                        switch (choice_2) {
                                            case 1:
                                                RoleMenu.addRole();
                                                break;
                                            case 2:
                                                RoleMenu.deleteRole();
                                                break;
                                        }
                                    }
                                    break;
                                case 0:
                                    ManageUser.currentUser = null;
                                    break;
                            }
                        }
                    } else System.out.println("Bạn nhập sai tên đăng nhập hoặc mật khẩu!!");
                    break;
                case 2:
                    UserMenu.register();
                    break;
            }

        }

    }
}
