package DataAccess.abstracts;

import Entities.concretes.User;

import java.util.List;

public interface UserDao {
    public void add(User user);
    public void delete(User user);
    public void update(User user);
    User get(int id);
    public List<User> getAll();
    User getEmail(String email);
}
