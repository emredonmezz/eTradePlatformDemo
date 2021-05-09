package Core.GoogleAdapters;

import Business.abstracts.AuthenticationService;
import Core.utilities.BusinessRules;
import Entities.concretes.User;
import GoogleAccount.RegisterToGoogle;

public class GoogleAccountManager implements AuthenticationService {
    RegisterToGoogle registerToGoogle = new RegisterToGoogle();
    @Override
    public boolean validate(User user) {
        boolean result = false;
        result=registerToGoogle.register(user.getId(),user.getUserFirstName(),user.getUserLastName(),user.getEmail(),user.getPassword());
        if (result != true){
            return false;
        }
        System.out.println("Registered with Google Account");
        return true;
    }

    private boolean isEmailorPasswordMissing(User user) {
        if (user.getEmail()==null || user.getPassword()==null) {
            System.out.println("E-mail or password is missing!");
            return false;
        }
        System.out.println("Logged into the system");
        return true;
    }

    @Override
    public boolean login(User user) {
        boolean result= BusinessRules.Run(isEmailorPasswordMissing(user));
        return result;
    }
}
