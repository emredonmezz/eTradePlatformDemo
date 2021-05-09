package Business.concretes;

import Business.abstracts.AuthenticationService;
import Core.utilities.BusinessRules;
import Entities.concretes.User;

import java.util.regex.Pattern;

public class AuthenticationManager implements AuthenticationService {

    public static final Pattern VALID_EMAIL_ADDRESS_REGEX = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);

    private boolean ifPasswordCheckLength(User user) {
        if (user.getPassword().length()<6) {
            System.out.println("The password must be at least 6 characters long!");
            return false;
        }
        return true;
    }

    private boolean ifFirstNameCheckLength(User user) {
        if (user.getUserFirstName().length()<2) {
            System.out.println("The name must be at least 2 characters long!");
            return false;
        }
        return true;
    }
    private boolean ifLastNameCheckLength(User user) {
        if (user.getUserLastName().length()<2) {
            System.out.println("The surname must be at least 2 characters long!");
            return false;
        }
        return true;
    }
    private boolean ifEmailFormatCheckValid(User email) {
        return VALID_EMAIL_ADDRESS_REGEX.matcher(email.getEmail()).find();
    }

    private boolean isEmailorPasswordMissing(User user) {
        if (user.getEmail()==null || user.getPassword()==null) {
            System.out.println("E-mail or password is missing!");
            return false;
        }
        System.out.println("Logged into the system!");
        return true;
    }


    @Override
    public boolean validate(User user) {
        boolean result= BusinessRules.Run(ifEmailFormatCheckValid(user),
                ifFirstNameCheckLength(user),
                ifLastNameCheckLength(user),
                ifPasswordCheckLength(user));
        return result;
    }

    @Override
    public boolean login(User user) {
        boolean result = BusinessRules.Run(isEmailorPasswordMissing(user));
        return result;
    }
}
