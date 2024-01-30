package services;

import models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repositories.UserRepository;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public User getUserById(Long id){
        return userRepository.findById(id).get();
    }

    public User saveUser(String forename,String surname){
        User user = new User();
        user.setForename(forename);
        user.setSurname(surname);
        userRepository.save(user);
        return user;
    }

    public void updateLevel(Long id){
        User userToUpdate = userRepository.findById(id).get();
        userToUpdate.setLevel(userToUpdate.getLevel() + 1L);
    }
}
