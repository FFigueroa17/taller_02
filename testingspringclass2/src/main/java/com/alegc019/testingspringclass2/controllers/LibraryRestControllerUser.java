package com.alegc019.testingspringclass2.controllers;

import com.alegc019.testingspringclass2.domain.dtos.GeneralResponse;
import com.alegc019.testingspringclass2.domain.dtos.LoginDTO;
import com.alegc019.testingspringclass2.domain.dtos.SaveUserDto;
import com.alegc019.testingspringclass2.domain.entities.User;
import com.alegc019.testingspringclass2.services.UserService;
import com.alegc019.testingspringclass2.utils.ErrorsTool;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
@RequestMapping("/api/user")
public class LibraryRestControllerUser {

    final UserService userService;
    private final ErrorsTool errorsTool;


    public LibraryRestControllerUser(UserService userService, ErrorsTool errorsTool) {
        this.userService = userService;
        this.errorsTool = errorsTool;
    }

    @GetMapping("/")
    public ResponseEntity<GeneralResponse> getAll(){
        return GeneralResponse.getResponse(
                HttpStatus.OK,
                "Users found",
                userService.getAll()
        );
    }

    //Login
    @PostMapping("/login")
    public ResponseEntity<GeneralResponse> login(@RequestBody @Valid LoginDTO info, BindingResult result){

        User user = userService.searchForLoginEmail(info.getIdentifier(), info.getPassword());

        if(user == null){
            return GeneralResponse.getResponse(
                    HttpStatus.UNAUTHORIZED,
                    "User not found"
            );
        }

        return GeneralResponse.getResponse(
                HttpStatus.OK,
                "User found",
                user
        );
    }


    //Register
    @PostMapping("/register")
    public ResponseEntity<GeneralResponse> register(@RequestBody @Valid SaveUserDto info, BindingResult result){

        if(result.hasErrors()){
           return GeneralResponse.getResponse(
                   HttpStatus.BAD_REQUEST,
                   errorsTool.mapErrors(result.getFieldErrors())
           );
        }

        userService.save(info);

        return GeneralResponse.getResponse(
                HttpStatus.OK,
                "User saved"
        );
    }
}
