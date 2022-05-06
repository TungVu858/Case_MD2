package menu;

import file.FileCarCSV;
import file.Path;
import input.Input;
import manage.ManageCar;
import manage.ManageUser;
import model.Car;
import model.DetailValid;
import model.User;

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

    public static void menuCarDisplayAll() throws IOException {
        ManageCar manageCar = new ManageCar();
        System.out.println(Input.ANSI_BLUE + "Toàn bộ xe " + Input.ANSI_RESET);
        manageCar.displayAll();
    }

    public static void menuCarDisplayNameCar() throws IOException {
        Scanner scc = new Scanner(System.in);
        ManageCar manageCar = new ManageCar();
        System.out.println(Input.ANSI_BLUE + "Nhập vào tên xe cần tìm " + Input.ANSI_RESET);
        String carName = scc.nextLine();
        manageCar.displayNameCar(carName);
    }

    public static void menuCarDisplayCompanyCar() throws IOException {
        Scanner scc = new Scanner(System.in);
        ManageCar manageCar = new ManageCar();
        System.out.println(Input.ANSI_BLUE + "Nhập tên hãng xe cần tìm " + Input.ANSI_RESET);
        String carCompany = scc.nextLine();
        manageCar.displayCompanyCar(carCompany);
    }

    public static void menuCarDisplayPriceCar() throws IOException {
        ManageCar manageCar = new ManageCar();
        System.out.println(Input.ANSI_BLUE + "Tìm kiếm theo giá " + Input.ANSI_RESET);
        int priceCar = Input.checkExceptionNumber("Nhập giá tiền từ : ");
        int priceCar1 = Input.checkExceptionNumber("đến");
        manageCar.displayByPrice(priceCar, priceCar1);
    }

    public static void menuCarAdd() throws IOException {
        ManageCar manageCar = new ManageCar();
        ManageUser manageUser = new ManageUser();
        Scanner scc = new Scanner(System.in);
        int idCar = Input.checkExceptionNumber("Nhập id xe : ");
        if (manageCar.findByIndexCar(idCar) == -1) {
            while (true) {
                System.out.println("Nhập tên xe : ");
                String carName = scc.nextLine();
                if (Input.validate(new DetailValid(Input.CAR_NAME, Input.NOT_VALID_CAR_NAME), carName)) {
                    while (true) {
                        System.out.println("Nhập hãng xe : ");
                        String carCompany = scc.nextLine();
                        if (Input.validate(new DetailValid(Input.CAR_COMPANY, Input.NOT_VALID_CAR_NAME), carCompany)) {
                            int priceCar = Input.checkExceptionNumber("Nhập giá tiền xe : ");
                            User user = manageUser.findById(ManageUser.currentUser.getIdUsers());
                            manageCar.add(new Car(idCar, carName, carCompany, priceCar, user));
                            System.out.println(Input.ANSI_BLUE + "Bạn đã thêm thành công " + carName + Input.ANSI_RESET);
                            FileCarCSV.writeToFile(Path.PATH_CAR, manageCar.getCarList());
                            break;
                        }
                    }
                    break;
                }
            }
        } else System.out.println("\u001B[31m" + "Id xe đã có !!!" + "\u001B[0m");
    }

    public static void menuCarDelete() throws IOException {
        ManageCar manageCar = new ManageCar();
        Scanner scc = new Scanner(System.in);
        int idCar = Input.checkExceptionNumber("Nhập id xe cần xóa : ");
        if (manageCar.findByIndexCar(idCar) != -1) {
            while (true) {
                manageCar.displayById(idCar);
                System.out.println(Input.ANSI_BLUE + "Bạn có muốn xóa hay không y/n" + Input.ANSI_RESET);
                String flag = scc.nextLine();
                if (Input.validate(new DetailValid(Input.ANSWER, Input.NOT_VALID_ANSWER), flag)) {
                    if (flag.equals("y") || flag.equals("Y")) {
                        manageCar.delete(idCar);
                        System.out.println(Input.ANSI_BLUE + "Bạn đã xóa thành công!!" + Input.ANSI_RESET);
                        FileCarCSV.writeToFile(Path.PATH_CAR, manageCar.getCarList());
                        break;
                    } else System.out.println("\u001B[31m" + "Xóa thất bại !!!!" + "\u001B[0m");
                    break;
                }
            }
        } else System.out.println("\u001B[31m" + "Không tìm thấy id xe !!" + "\u001B[0m");
    }

    public static void menuCarEdit() throws IOException {
        Scanner scc = new Scanner(System.in);
        ManageCar manageCar = new ManageCar();
        ManageUser manageUser = new ManageUser();
        int idCar = Input.checkExceptionNumber("Nhập id xe cần sửa thông tin : ");
        if (manageCar.findByIndexCar(idCar) != -1) {
            while (true) {
                manageCar.displayById(idCar);
                System.out.println("Nhập tên xe : ");
                String carName = scc.nextLine();
                if (Input.validate(new DetailValid(Input.CAR_NAME, Input.NOT_VALID_CAR_NAME), carName)) {
                    while (true) {
                        System.out.println("Nhập hãng xe : ");
                        String carCompany = scc.nextLine();
                        if (Input.validate(new DetailValid(Input.CAR_COMPANY, Input.NOT_VALID_CAR_NAME), carCompany)) {
                            int priceCar = Input.checkExceptionNumber("Nhập giá xe : ");
                            User user = manageUser.findById(ManageUser.currentUser.getIdUsers());
                            while (true) {
                                System.out.println(Input.ANSI_BLUE + "Bạn có xác nhận sửa hay không y/n" + Input.ANSI_RESET);
                                String flag = scc.nextLine();
                                if (Input.validate(new DetailValid(Input.ANSWER, Input.NOT_VALID_ANSWER), flag)) {
                                    if (flag.equals("y") || flag.equals("Y")) {
                                        manageCar.edit(idCar, new Car(idCar, carName, carCompany, priceCar, user));
                                        System.out.println(Input.ANSI_BLUE + "Bạn đã sửa thành công " + carName + Input.ANSI_RESET);
                                        FileCarCSV.writeToFile(Path.PATH_CAR, manageCar.getCarList());
                                        break;
                                    } else System.out.println("\u001B[31m" + "Xóa thất bại !!" + "\u001B[0m");
                                    break;
                                }
                            }
                            break;
                        }
                    }
                    break;
                }
            }
        } else System.out.println("\u001B[31m" + "Không tìm thấy id xe!!!" + "\u001B[0m");
    }
}
