import ptbs.Facade;

import java.util.Scanner;

public class PtbsMain {
    static Scanner sc= new Scanner(System.in);
    static Facade facade = new Facade();

    public static void main(String[] args) throws Exception {
        System.out.println("Enter User Name:");
        String userName = sc.nextLine();
        System.out.println("Enter Password:");
        String password = sc.nextLine();
        facade.login(userName, password);

    }
}
