package com.kotor.contollers;

import com.kotor.models.UserModel;
import com.kotor.database.RepoUser;
import com.kotor.error.UserAlreadyExist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class SingUp {
    @Autowired
    private RepoUser repoUser;

    @PostMapping("/in")
    public String register(@RequestBody UserModel userModel) {
        System.out.println(userModel);
        try {
            repoUser.addUser(userModel.getName(), userModel.getPassword());
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