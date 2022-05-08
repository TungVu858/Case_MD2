package menu;

import file.FileCarCSV;
import file.FileCarCompany;
import file.Path;
import input.Input;
import manage.ManageCar;
import manage.ManageCarCompany;
import manage.ManageUser;
import model.Car;
import model.CarCompany;
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
//        System.out.println("8. Thêm hãng xe ");
        System.out.println("0. Thoát ");
        System.out.print("Nhập lựa chọn : ");
    }

    public static void menuDefault() {
        System.out.println("0. Thoát ");
        System.out.print("Nhập lựa chọn : ");
    }

    public static void menuCarDisplayAll(ManageCar manageCar) {
        System.out.println(Input.ANSI_BLUE + "Toàn bộ xe " + Input.ANSI_RESET);
        manageCar.displayAll();
    }

    public static void menuCarDisplayNameCar(ManageCar manageCar) {
        Scanner scc = new Scanner(System.in);
        System.out.println(Input.ANSI_BLUE + "Nhập vào tên xe cần tìm " + Input.ANSI_RESET);
        String carName = scc.nextLine();
        manageCar.displayNameCar(carName);
    }

    public static void menuCarDisplayCompanyCar(ManageCar manageCar,ManageCarCompany manageCarCompany) throws IOException {
        Scanner scc = new Scanner(System.in);
        System.out.println(Input.ANSI_BLUE + "Các hãng xe hiện có thể có : Ford,Ferrari,Toyota,Honda,Kia,Mazda,BMW" + Input.ANSI_RESET);
        System.out.println(Input.ANSI_BLUE + "Nhập tên hãng xe cần tìm " + Input.ANSI_RESET);
        String carCompany = scc.nextLine();
//        System.out.println("Nhập hãng xe : ");
//        manageCarCompany.displayAllCompany();
//        int carCompany = -1;
//        carCompany = Input.checkMenu7Op(scs, carCompany);
//        CarCompany car = ManageCarCompany.getInstance().findById(carCompany);
        manageCar.displayCompanyCar(carCompany);
    }

    public static void menuCarDisplayPriceCar(ManageCar manageCar) {
        System.out.println(Input.ANSI_BLUE + "Tìm kiếm theo giá " + Input.ANSI_RESET);
        int priceCar = Input.checkExceptionNumber("Nhập giá tiền từ : ");
        int priceCar1 = Input.checkExceptionNumber("đến");
        manageCar.displayByPrice(priceCar, priceCar1);
    }

    public static void menuCarAdd(ManageCar manageCar, ManageUser manageUser, ManageCarCompany manageCarCompany) throws IOException {
        Scanner scc = new Scanner(System.in);
        int idCar = Input.checkExceptionNumber("Nhập id xe : ");
        if (manageCar.findByIndexCar(idCar) == -1) {
            while (true) {
                System.out.println("Nhập tên xe : ");
                String carName = scc.nextLine();
                if (Input.validate(new DetailValid(Input.CAR_NAME, Input.NOT_VALID_CAR_NAME), carName)) {
                    manageCarCompany.displayAllCompany();
                    int carCompany = Input.checkExceptionNumberIdCompany("Nhập id hãng xe : ");
                    int priceCar = Input.checkExceptionNumber("Nhập giá tiền xe : ");
                    User user = manageUser.findById(ManageUser.currentUser.getIdUsers());
                    CarCompany car = ManageCarCompany.getInstance().findById(carCompany);
                    manageCar.add(new Car(idCar, carName, car, priceCar, user));
                    System.out.println(Input.ANSI_BLUE + "Bạn đã thêm thành công " + carName + Input.ANSI_RESET);
                    FileCarCSV.writeToFile(Path.PATH_CAR, manageCar.getCarList());
                    break;
                }
            }
        } else System.out.println("\u001B[31m" + "Id xe đã có !!!" + "\u001B[0m");
    }

    public static void menuCarDelete(ManageCar manageCar) throws IOException {
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

    public static void menuCarEdit(ManageCar manageCar, ManageUser manageUser,ManageCarCompany manageCarCompany) throws IOException {
        Scanner scc = new Scanner(System.in);
        Scanner scs = new Scanner(System.in);
        int idCar = Input.checkExceptionNumber("Nhập id xe cần sửa thông tin : ");
        if (manageCar.findByIndexCar(idCar) != -1) {
            while (true) {
                manageCar.displayById(idCar);
                System.out.println("Nhập tên xe : ");
                String carName = scc.nextLine();
                if (Input.validate(new DetailValid(Input.CAR_NAME, Input.NOT_VALID_CAR_NAME), carName)) {
                    manageCarCompany.displayAllCompany();
                    int carCompany = Input.checkExceptionNumberIdCompany("Nhập id hãng xe : ");
                    int priceCar = Input.checkExceptionNumber("Nhập giá xe : ");
                    User user = manageUser.findById(ManageUser.currentUser.getIdUsers());
                    CarCompany car = ManageCarCompany.getInstance().findById(carCompany);
                    while (true) {
                        System.out.println(Input.ANSI_BLUE + "Bạn có xác nhận sửa hay không y/n" + Input.ANSI_RESET);
                        String flag = scc.nextLine();
                        if (Input.validate(new DetailValid(Input.ANSWER, Input.NOT_VALID_ANSWER), flag)) {
                            if (flag.equals("y") || flag.equals("Y")) {
                                manageCar.edit(idCar, new Car(idCar, carName, car, priceCar, user));
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
        } else System.out.println("\u001B[31m" + "Không tìm thấy id xe!!!" + "\u001B[0m");
    }
//    public static void addCompanyCar(ManageCarCompany manageCarCompany) throws IOException {
//        Scanner scs = new Scanner(System.in);
//        Scanner scc = new Scanner(System.in);
//        int id = Input.checkExceptionNumber("Nhập id hãng xe : ");
//        if (ManageCarCompany.getInstance().findByIndexCompany(id)==-1) {
//            System.out.println("Nhập tên hãng xe : ");
//            String name = scc.nextLine();
//            manageCarCompany.addCompany(new CarCompany(id,name));
//            FileCarCompany.writeToFile(Path.PATH_CAR_COMPANY,manageCarCompany.getCarCompanyList());
//        }
//    }
}
