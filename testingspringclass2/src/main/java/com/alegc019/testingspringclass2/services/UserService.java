package com.alegc019.testingspringclass2.services;

import com.alegc019.testingspringclass2.domain.dtos.SaveUserDto;
import com.alegc019.testingspringclass2.domain.entities.User;

public interface UserService {

    void save(SaveUserDto info);

    //searchforlogin
    User searchForLoginName(String username, String password);

    User searchForLoginEmail(String email, String password);

    User searchUser(SaveUserDto info);

    User searchForLogin(SaveUserDto info);



}
