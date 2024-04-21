package com.alegc019.testingspringclass2.services;

import com.alegc019.testingspringclass2.domain.dtos.SaveUserDto;
import com.alegc019.testingspringclass2.domain.entities.User;

import java.util.List;

public interface UserService {

    boolean save(SaveUserDto info);

    List<User> getAll();

    //searchforlogin
    User searchForLoginName(String username, String password);

    User searchForLoginEmail(String email, String password);

    User searchUser(SaveUserDto info);

    User searchForLogin(SaveUserDto info);

    boolean isUserExists(SaveUserDto info);

}
