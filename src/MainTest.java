import file.FileCarCompany;
import file.Path;
import manage.ManageCarCompany;
import model.CarCompany;

import java.io.IOException;

public class MainTest {
    public static void main(String[] args) throws IOException {
        ManageCarCompany manageCarCompany = new ManageCarCompany();
        manageCarCompany.addCompany(new CarCompany(1,"Ford"));
        manageCarCompany.addCompany(new CarCompany(2,"Toyota"));
        manageCarCompany.addCompany(new CarCompany(3,"Ferrari"));
        manageCarCompany.addCompany(new CarCompany(4,"Honda"));
        FileCarCompany.writeToFile(Path.PATH_CAR_COMPANY,manageCarCompany.getCarCompanyList());
    }
}
