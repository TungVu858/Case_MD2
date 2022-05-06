package input;

import model.DetailValid;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Input {
    public static final String USER_NAME = "^[a-zA-Z]([._-](?![._-])|[\\w]){3,18}[\\w]$";
    public static final String USER_PASS = "^(?=.*[\\d])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–[{}]:;',?/*~$^+=<>]).{8,20}$";
    public static final String CAR_NAME = "^[A-Z]+[\\w]+$";
    public static final String CAR_COMPANY = "^[A-Z]+[\\w]{2,10}$";
    public static final String ROLE_NAME = "^[Admin|Manage|Custom]+$";
    public static final String ROLE_DESCRIPTION = "^[Chủ|Khách|QuảnLý]+$";
    public static final String ANSWER = "^[y|n|Y|N]{1}$";
    public static final String NOT_VALID_USER_NAME = "\u001B[31m" + "Bạn cần nhập kí tự đầu tiên là chữ và từ 5 đến 18 kí tự " + "\u001B[0m";
    public static final String NOT_VALID_USER_PASS = "\u001B[31m" + "Bạn cần nhập ít nhất 1 số,kí tự đặc biệt,kí tự viết hoa và từ 8 đến 20 kí tự " + "\u001B[0m";
    public static final String NOT_VALID_CAR_NAME = "\u001B[31m" + "Bạn không được nhập kí tự có dấu,đặc biệt và chữ đầu phải viết hoa " + "\u001B[0m";
    public static final String NOT_VALID_ANSWER = "\u001B[31m" + "Bạn chỉ được nhập y/n Y/N" + "\u001B[0m";
    public static final String CHECK_PASS_DUPE = "\u001B[31m" + "Nhập 2 mật khẩu phải trùng nhau !!" + "\u001B[0m";
    public static final String CHECK_USER_NAME_DUPE = "\u001B[31m" + "Tài khoản đã tồn tại !!!" + "\u001B[0m";
    public static final String CHECK_USER_ID_DUPE = "\u001B[31m" + "Id tài khoản đã tồn tại !!!" + "\u001B[0m";
    public static final String NOT_VALID_ROLE_NAME = "\u001B[31m" + "Chỉ có 3 role Admin,Manage,Custom" + "\u001B[0m";
    public static final String NOT_VALID_ROLE_DESCRIPTION = "\u001B[31m" + "Chỉ có 3 mô tả Chủ,Khách,QuảnLý" + "\u001B[0m";

    public static boolean validate(DetailValid detailValid, String string) {
        Pattern pattern = Pattern.compile(detailValid.getRegex());
        Matcher matcher = pattern.matcher(string);
        if (!matcher.matches()) {
            System.out.println(detailValid.getMessage());
        }
        return matcher.matches();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        if (validate(new DetailValid(ROLE_NAME, NOT_VALID_CAR_NAME), name)) {
            System.out.println("abc");
        } else System.out.println("aaa");
    }

    public static int checkMenu2Op(Scanner scs, int choice) {
        try {
            choice = scs.nextInt();
            if (choice > 2 || choice < 0) throw new Exception();
        } catch (InputMismatchException e) {
            System.out.println(ANSI_RED + "Không được nhập chữ !!!" + ANSI_RESET);
            scs.nextLine();
            choice = -1;
        } catch (Exception e) {
            System.out.println(ANSI_RED + "Chỉ được nhập số từ 0 --> 2" + ANSI_RESET);
        }
        return choice;
    }

    public static int checkMenu4Op(Scanner scs, int choice) {
        try {
            choice = scs.nextInt();
            if (choice > 4 || choice < 0) throw new Exception();
        } catch (InputMismatchException e) {
            System.out.println(ANSI_RED + "Không được nhập chữ !!!" + ANSI_RESET);
            scs.nextLine();
            choice = -1;
        } catch (Exception e) {
            System.out.println(ANSI_RED + "Chỉ được nhập số từ 0 --> 4" + ANSI_RESET);
        }
        return choice;
    }

    public static int checkMenu7Op(Scanner scs, int choice) {
        try {
            choice = scs.nextInt();
            if (choice > 7 || choice < 0) throw new Exception();
        } catch (InputMismatchException e) {
            System.out.println(ANSI_RED + "Không được nhập chữ !!!" + ANSI_RESET);
            scs.nextLine();
            choice = -1;
        } catch (Exception e) {
            System.out.println(ANSI_RED + "Chỉ được nhập số từ 0 --> 7" + ANSI_RESET);
        }
        return choice;
    }

    public static int checkExceptionNumber(String message) {
        int choice = -1;
        Scanner scs = new Scanner(System.in);
        boolean check = false;
        while (!check) {
            try {
                System.out.println(message);
                choice = scs.nextInt();
                check = true;
            } catch (Exception e) {
                System.out.println(ANSI_RED + "Chỉ được nhập số !!!!!" + ANSI_RESET);
                scs.nextLine();
            }
        }
        return choice;
    }

    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLUE = "\u001B[34m";
}
