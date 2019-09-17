package com.kotor.contollers;

import com.kotor.UserModel;
import com.kotor.database.Repo;
import com.kotor.error.UserAlreadyExist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class SingUp {
    @Autowired
    private Repo repo;

    @PostMapping("/in")
    public String register(@RequestBody UserModel userModel) {
        System.out.println(userModel);
        try {
            repo.addUser(userModel.getName(), userModel.getPassword());
        } catch (UserAlreadyExist e) {
            return e.getMessage();
        }

        return userModel.toString();
    }

    @GetMapping("/hi")
    public String hi() {
        return "h1";
    }
}