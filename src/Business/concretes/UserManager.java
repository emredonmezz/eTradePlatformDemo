package Business.concretes;

import Business.abstracts.AuthenticationService;
import Business.abstracts.EmailService;
import Business.abstracts.UserService;
import DataAccess.abstracts.UserDao;
import Entities.concretes.User;

import java.util.ArrayList;
import java.util.List;

public class UserManager implements UserService {
    private AuthenticationService authenticationService;
    private EmailService emailService;
    private UserDao userDao;

    public UserManager(AuthenticationService authenticationService, EmailService emailService, UserDao userDao) {
        this.authenticationService = authenticationService;
        this.emailService = emailService;
        this.userDao = userDao;
    }

    List<User> users=new ArrayList<User>();
    public UserManager() {
        users.add((User) this.getAll());
    }

    public boolean userCheck(String mail){
        if (userDao.getEmail(mail) != null){
            System.out.println("Existing User!");
            return false;
        }
        return true;
    }





    @Override
    public void add(User user) {
        if (userCheck(user.getEmail()) && authenticationService.validate(user)){
            userDao.add(user);
            System.out.println("Authentication Code has been sent to your E-mail! Authentication Code is : " + emailService.mailSend());
            System.out.println("Please enter the Authentication Code  : ");
            return;
        }
        System.out.println(" Incorrect !  Please check the information . >");
    }

    @Override
    public void delete(User user) {
        this.userDao.delete(user);
    }

    @Override
    public void update(User user) {
        this.userDao.update(user);
    }

    @Override
    public User get(int id) {
        User result = this.userDao.get(id);
        return result;
    }

    @Override
    public List<User> getAll() {
        List<User> result = this.userDao.getAll();
        return result;
    }

    @Override
    public void userVerify(User user, int verificationCode) {
        int result = emailService.mailSend();
        if (result == emailService.mailSend()){
            System.out.println("User Confirmed. Your membership process has been completed.");
        } else {
            System.out.println("Authentication Code is not correct.");
        }
    }
}
