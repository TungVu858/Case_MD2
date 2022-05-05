package input;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Input {
    public static final String USER_NAME = "^[a-zA-Z]([._-](?![._-])|[\\w]){3,18}[\\w]$";
    public static final String USER_PASS = "^(?=.*[\\d])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–[{}]:;',?/*~$^+=<>]).{8,20}$";

    public boolean validate(String regex){
        return Pattern.compile(USER_NAME).matcher(regex).matches();
    }

    public static void main(String[] args) {
        Input input = new Input();
        boolean isValid = input.validate("Thanhtung_nd");
        System.out.println(isValid);
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
}
