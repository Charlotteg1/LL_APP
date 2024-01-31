package services;

import models.Login;
import models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repositories.LoginRepository;
import repositories.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
public class LoginService {

    @Autowired
    LoginRepository loginRepository;

    @Autowired
    UserRepository userRepository;

    public void saveUserLogin(String email, String password, Long id){
        Login newUser = new Login();
        newUser.setEmail(email);
        newUser.setPassword(password);
        newUser.setUser(userRepository.findById(id).get());
        loginRepository.save(newUser);
    }

//    Checking password
//  9 or more characters long
//  contains a capital letter
//  contains a number
//  extension : could check it doesn't contain their name or common words like password


    public boolean checkContainsCapital(String enteredPassword){
        for (char c : enteredPassword.toCharArray()) {
            if (Character.isUpperCase(c)) {
                return true;
            }
        }
        return false;
    }

    public boolean checkContainsNumber(String enteredPassword){
        for (char c : enteredPassword.toCharArray()) {
            if (Character.isDigit(c)) {
                return true;
            }
        }
        return false;
    }

    public boolean checkPasswordLength(String enteredPassword){
        if(enteredPassword.length() > 8) {
            return true;
        }else {
            return false;
        }
    }

//    checking email
//        check contains @
//        check isn't already in user list
    public boolean containsAt(String enteredEmail){
        for (char c : enteredEmail.toCharArray()) {
            if (c=='@') {
                return true;
            }
        }
        return false;
    }
    public boolean checkIsNewEmail(String enteredEmail){
//        could be more efficient by finding matching first letter in full list and then searching through that.
        List<Login> currentUsersList = loginRepository.findAll();
        for(Login userLogin: currentUsersList ){
            if(enteredEmail.equals(userLogin.getEmail())){
                return false;
            }
        }
        return true;
    }


//    check Login details
    public Optional<User> checkLogin(String email, String password){
        List<Login> currentUsersList = loginRepository.findAll();
        for (Login userLogin : currentUsersList) {
            if (email.equals(userLogin.getEmail()) && password.equals(userLogin.getPassword())) {
                return Optional.of(userLogin.getUser());
            }
        }
        return null;
    }
}
