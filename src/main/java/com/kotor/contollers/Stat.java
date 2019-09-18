package com.kotor.contollers;

import com.kotor.database.RepoRun;
import com.kotor.models.StatModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping("/api")
public class Stat {
    @Autowired
    private RepoRun repoRun;

    @GetMapping("/stat")
    public List<StatModel> getStat(HttpSession session) {
        if (session.getAttribute("isAuth") instanceof Boolean) {
            return repoRun.getStat();

        }
        return null;
    }
}
