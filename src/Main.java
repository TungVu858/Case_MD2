
import input.Input;
import manage.ManageUser;
import menu.CarMenu;
import menu.Menu;
import menu.RoleMenu;
import menu.UserMenu;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        ManageUser manageUser = new ManageUser();
        Scanner scc = new Scanner(System.in);
        Scanner scs = new Scanner(System.in);
        String username;
        String pass;
        int choice = -1;
        while (choice != 0) {
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
                            UserMenu.mainLogin();
                            choice_1 = Input.checkMenu4Op(scs, choice_1);
                            switch (choice_1) {
                                case 1:
                                    int choice_3 = -1;
                                    while (choice_3 != 0) {
                                        CarMenu.menuCar();
                                        if (ManageUser.currentUser.getRole().getNameRole().equals("Admin") || ManageUser.currentUser.getRole().getNameRole().equals("Manage")) {
                                            CarMenu.menuCarTypeRole();
                                            choice_3 = Input.checkMenu7Op(scs, choice_3);
                                        } else {
                                            CarMenu.menuDefault();
                                            choice_3 = Input.checkMenu4Op(scs, choice_3);
                                        }
                                        switch (choice_3) {
                                            case 1:
                                                CarMenu.menuCarDisplayAll();
                                                break;
                                            case 2:
                                                CarMenu.menuCarDisplayNameCar();
                                                break;
                                            case 3:
                                                CarMenu.menuCarDisplayCompanyCar();
                                                break;
                                            case 4:
                                                CarMenu.menuCarDisplayPriceCar();
                                                break;
                                            case 5:
                                                CarMenu.menuCarAdd();
                                                break;
                                            case 6:
                                                CarMenu.menuCarDelete();
                                                break;
                                            case 7:
                                                CarMenu.menuCarEdit();
                                                break;
                                        }
                                    }
                                    break;
                                case 2:
                                    UserMenu.information();
                                    break;
                                case 3:
                                   UserMenu.rePass(manageUser);
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
