package com.kotor.contollers;

import com.kotor.database.Repo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SingUp {
    @Autowired
    private Repo repo;
    @PostMapping("/sign-up")
    public String register(@RequestBody
                                   String name, @RequestBody String password) {
        repo.addUser(name, password);
        return "<h1>" + name + " " + password + "</h1>";
    }

    @GetMapping("/hi")
    public String hi() {
        return "h1";
    }
}