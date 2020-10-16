package service;

import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import repository.UserRepoInterface;

public class UserService implements UserServiceInterface {
    @Autowired
    private UserRepoInterface userRepoInterface;

    @Override
    public void save(User user) {
        if (user.getId() != null){
            userRepoInterface.
        }
    }
}
