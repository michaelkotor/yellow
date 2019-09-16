package com.kotor.contollers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Login {


    @PostMapping("/login")
    public String pLogin(@RequestBody String name, @RequestBody String password) {

        return "<h1>" + name + " " + password + "</h1>";
    }
}