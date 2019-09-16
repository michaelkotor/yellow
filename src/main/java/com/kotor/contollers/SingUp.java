package com.kotor.contollers;

import com.kotor.database.Repo;
import com.kotor.error.UserAlreadyExist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class SingUp {
    @Autowired
    private Repo repo;

    @PostMapping("/in")
    public String register(@RequestBody String userInfo) {
        System.out.println(userInfo);
        String name = userInfo.split(" ")[0];
        String password = userInfo.split(" ")[1];
        try {
            repo.addUser(name, password);
        } catch (UserAlreadyExist e) {
            return e.getMessage();
        }

        return  userInfo;
    }

    @GetMapping("/hi")
    public String hi() {
        return "h1";
    }
}