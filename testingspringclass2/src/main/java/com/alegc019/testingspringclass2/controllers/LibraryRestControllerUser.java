package com.alegc019.testingspringclass2.controllers;

import com.alegc019.testingspringclass2.domain.dtos.LoginDTO;
import com.alegc019.testingspringclass2.domain.dtos.SaveUserDto;
import com.alegc019.testingspringclass2.domain.entities.User;
import com.alegc019.testingspringclass2.services.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
public class LibraryRestControllerUser {

    @Autowired
    UserService userService;

    //Login
    @PostMapping("/login")
    public ResponseEntity<User> login(@RequestBody @Valid LoginDTO info, BindingResult result){

        if(result.hasErrors()){

            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        User user = userService.searchForLoginEmail(info.getIdentifier(), info.getPassword());

        if(user == null){

            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);

        }

        //Return user and status code
        return new ResponseEntity<User>(user, HttpStatus.OK);
    }


    //Register
    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody @Valid SaveUserDto info, BindingResult result){

        if(result.hasErrors()){

            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        userService.save(info);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

}
