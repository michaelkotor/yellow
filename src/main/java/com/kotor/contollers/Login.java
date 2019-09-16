package com.kotor.contollers;

import com.kotor.database.Repo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
public class Login {

    @Autowired
    private Repo repo;

    @PostMapping("/login")
    public String pLogin(HttpSession session, @RequestBody String userInfo) {
        String name = userInfo.split(" ")[0];
        String password = userInfo.split(" ")[1];
        if (repo.exists(name, password)) {
            session.setAttribute("isAuth", true);
            return "you ar welcome";
        }
        session.setAttribute("isAuth", null);
        return "no such user";
    }
}