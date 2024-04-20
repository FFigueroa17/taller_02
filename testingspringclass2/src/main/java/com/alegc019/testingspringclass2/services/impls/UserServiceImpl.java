package com.alegc019.testingspringclass2.services.impls;

import com.alegc019.testingspringclass2.domain.dtos.SaveUserDto;
import com.alegc019.testingspringclass2.domain.entities.User;
import com.alegc019.testingspringclass2.services.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class UserServiceImpl implements UserService {

    public final static List<User> users = new ArrayList<>();
    static{
        //Add user
        users.add(new User(
                //Username
                //Password
                //Email
        ));
    }

    @Override
    public void save(SaveUserDto info) {

        User user = searchUser(info);

        if(user == null){
            user = new User();
            users.add(user);
        }

        user.setUsername(info.getUsername());
        user.setPassword(info.getPassword());
        user.setEmail(info.getEmail());
    }

    @Override
    public List<User> getAll() {
        return users;
    }

    @Override
    public User searchForLoginName(String username, String password) {
        return users.stream()
                .filter(u -> username.equals(u.getUsername()) && password.equals(u.getPassword()))
                .findAny()
                .orElse(null);
    }

    @Override
    public User searchForLoginEmail(String email, String password) {
        return users.stream()
                .filter(u -> email.equals(u.getEmail()) && password.equals(u.getPassword()))
                .findAny()
                .orElse(null);
    }

    @Override
    public User searchUser(SaveUserDto info) {
        //Look between the two functions
        User search = searchForLoginName(info.getUsername(), info.getPassword());

        if(search == null){
            search = searchForLoginEmail(info.getEmail(), info.getPassword());
        }

        return search;
    }

    @Override
    public User searchForLogin(SaveUserDto info) {
        User user = searchUser(info);

        return user;
    }
}
