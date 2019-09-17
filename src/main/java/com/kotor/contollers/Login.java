package com.kotor.contollers;

import com.kotor.UserModel;
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
    public String pLogin(HttpSession session, @RequestBody UserModel userModel) {
        if (repo.exists(userModel.getName(), userModel.getPassword())) {
            session.setAttribute("isAuth", true);
            return "you ar welcome";
        }
        session.setAttribute("isAuth", null);
        return "no such user";
    }
}