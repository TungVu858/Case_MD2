package menu;

import file.FileCarCSV;
import file.Path;
import input.Input;
import manage.ManageCar;
import manage.ManageUser;
import model.Car;
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
        System.out.println("Toàn bộ xe ");
        manageCar.displayAll();
    }

    public static void menuCarDisplayNameCar() throws IOException {
        Scanner scc = new Scanner(System.in);
        ManageCar manageCar = new ManageCar();
        System.out.println("Nhập vào tên xe cần tìm ");
        String carName = scc.nextLine();
        manageCar.displayNameCar(carName);
    }

    public static void menuCarDisplayCompanyCar() throws IOException {
        Scanner scc = new Scanner(System.in);
        ManageCar manageCar = new ManageCar();
        System.out.println("Nhập tên hãng xe cần tìm ");
        String carCompany = scc.nextLine();
        manageCar.displayCompanyCar(carCompany);
    }

    public static void menuCarDisplayPriceCar() throws IOException {
        ManageCar manageCar = new ManageCar();
        System.out.println("Tìm kiếm theo giá ");
        int priceCar = Input.checkExceptionNumber("Nhập giá tiền từ : ");
        int priceCar1 = Input.checkExceptionNumber("đến");
        manageCar.displayByPrice(priceCar, priceCar1);
    }

    public static void menuCarAdd() throws IOException {
        ManageCar manageCar = new ManageCar();
        ManageUser manageUser = new ManageUser();
        Scanner scc = new Scanner(System.in);
        int idCar = Input.checkExceptionNumber("Nhập id xe : ");
        if (manageCar.findByInDexCar(idCar) == -1) {
            System.out.println("Nhập tên xe : ");
            String carName = scc.nextLine();
            System.out.println("Nhập hãng xe : ");
            String carCompany = scc.nextLine();
            int priceCar = Input.checkExceptionNumber("Nhập giá tiền xe : ");
            User user = manageUser.findById(ManageUser.currentUser.getIdUsers());
            manageCar.add(new Car(idCar, carName, carCompany, priceCar, user));
            System.out.println("Bạn đã thêm thành công " + carName);
            FileCarCSV.writeToFile(Path.PATH_CAR, manageCar.getCarList());
        } else System.out.println("Id xe đã có !!!");
    }

    public static void menuCarDelete() throws IOException {
        ManageCar manageCar = new ManageCar();
        Scanner scc = new Scanner(System.in);
        int idCar = Input.checkExceptionNumber("Nhập id xe cần xóa : ");
        if (manageCar.findByInDexCar(idCar) != -1) {
            System.out.println("Bạn có muốn xóa hay không y/n");
            String flag = scc.nextLine();
            if (flag.equals("y")) {
                manageCar.delete(idCar);
                System.out.println("Bạn đã xóa thành công!!");
                FileCarCSV.writeToFile(Path.PATH_CAR, manageCar.getCarList());
            } else System.out.println("Xóa thất bại !!!!");
        } else System.out.println("Không tìm thấy id xe !!");
    }

    public static void menuCarEdit() throws IOException {
        Scanner scc = new Scanner(System.in);
        ManageCar manageCar = new ManageCar();
        ManageUser manageUser = new ManageUser();
        int idCar = Input.checkExceptionNumber("Nhập id xe cần sửa thông tin : ");
        if (manageCar.findByInDexCar(idCar) != -1) {
            System.out.println("Nhập tên xe : ");
            String carName = scc.nextLine();
            System.out.println("Nhập hãng xe : ");
            String carCompany = scc.nextLine();
            int priceCar = Input.checkExceptionNumber("Nhập giá xe : ");
            User user = manageUser.findById(ManageUser.currentUser.getIdUsers());
            System.out.println("Bạn có xác nhận sửa hay không y/n");
            String flag = scc.nextLine();
            if (flag.equals("y")) {
                manageCar.edit(idCar, new Car(idCar, carName, carCompany, priceCar, user));
                System.out.println("Bạn đã sửa thành công " + carName);
                FileCarCSV.writeToFile(Path.PATH_CAR, manageCar.getCarList());
            } else System.out.println("Sửa thất bại !!!!");
        } else System.out.println("Không tìm thấy id xe!!!");
    }
}
