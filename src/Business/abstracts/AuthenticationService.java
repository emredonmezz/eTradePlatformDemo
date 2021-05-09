package Business.abstracts;

import Entities.concretes.User;

public interface AuthenticationService {
    boolean validate(User user);
    boolean login(User user);
}
