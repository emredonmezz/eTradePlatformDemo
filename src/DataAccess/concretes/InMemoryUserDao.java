package DataAccess.concretes;

import DataAccess.abstracts.UserDao;
import Entities.concretes.User;

import java.util.ArrayList;
import java.util.List;

public class InMemoryUserDao implements UserDao {
    List<User> users = new ArrayList<User>();

    public InMemoryUserDao(){
        System.out.println("List of Users : ");
        User user1=new User(1,"Harley", "Davidson",
                "harleydavidson121212@gmail.com","harley1234");
        User user2=new User(2,"David", "Harleyson",
                "davidharleyson121212@gmail.com","david1234");

        users.add(user1);
        users.add(user2);
    }

    @Override
    public void add(User user) {
        System.out.println("User added to the system   : "+user.getUserFirstName()+ " " + user.getUserLastName());
        users.add(user);
    }

    @Override
    public void delete(User user) {
        System.out.println("User deleted from the system  : "+user.getUserFirstName()+ " " + user.getUserLastName());
    }

    @Override
    public void update(User user) {
        System.out.println("User updated  : "+user.getUserFirstName()+ " " + user.getUserLastName());
    }

    @Override
    public User get(int id) {
        User user = users.stream()
                .filter(u -> u.getId() == id)
                .findFirst()
                .orElse(null);
        System.out.println("Username  : "+user.getUserFirstName());
        return user;

    }

    @Override
    public User getEmail(String email) {
        User user = users.stream()
                .filter(u -> u.getEmail() == email)
                .findFirst()
                .orElse(null);

        return user;
    }

    @Override
    public List<User> getAll() {
        for (User user : users) {
            System.out.println(user.getUserFirstName());
        }
        System.out.println("----------------");
        return this.users;
    }


}
