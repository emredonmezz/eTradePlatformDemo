import Business.abstracts.AuthenticationService;
import Business.abstracts.UserService;
import Business.concretes.AuthenticationManager;
import Business.concretes.EmailManager;
import Business.concretes.UserManager;
import Core.GoogleAdapters.GoogleAccountManager;
import DataAccess.concretes.InMemoryUserDao;
import Entities.concretes.User;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        AuthenticationService googleAccountManager = new GoogleAccountManager();

        User user1 = new User(1,"Ali","Babiş","alibabis@gmail.com","ali1234");
        User user2 = new User(2,"Ali","Babiş","alibabis@gmail.com","ali1234");
        User user3 = new User(3,"Emre","Babiş","emrebabis@gmail.com","ali1234");
        User user4 = new User(4,"Ali","Babiş","alibabis@gmail.com","ali1234");
        User user5 = new User(5,"Ali","Babiş","alibabis@gmail.com","ali1234");
        User user6 = new User(6,"Ali","Babiş","alibabis@gmail.com","ali1234");
        User user7 = new User(7,"Ali","Babiş","alibabis@gmail.com","ali1234");
        User user8 = new User(8,"Ali","Babiş","alibabis@gmail.com","ali1234");




        UserService userService=new UserManager(new AuthenticationManager(), new EmailManager(), new InMemoryUserDao());
        userService.getAll();
        userService.add(user1);

        int verificationCode = scan.nextInt();
        userService.userVerify(user1,verificationCode);
        userService.add(user3);
    }
}
