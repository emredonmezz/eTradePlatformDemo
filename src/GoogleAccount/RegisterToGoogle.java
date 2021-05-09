package GoogleAccount;

import Entities.concretes.User;

public class RegisterToGoogle {
    public boolean register(int id, String userFirstName, String userLastName, String email, String password) {
        if (userFirstName.length() > 2 && userLastName.length() > 2 && password.length() > 5) {
            return true;
        } else {
            return false;
        }
    }
}