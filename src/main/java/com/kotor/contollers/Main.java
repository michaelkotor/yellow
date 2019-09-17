package com.kotor.contollers;

import com.kotor.database.RepoRun;
import com.kotor.database.RepoUser;
import com.kotor.logic.Run;
import com.kotor.models.RunModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController()
@RequestMapping("/api")
public class Main {
    @Autowired
    private RepoUser repoUser;

    @Autowired
    private RepoRun repoRun;


    @GetMapping("/runs")
    public List<Run>  doGet(HttpSession session) {
        if (session.getAttribute("isAuth") instanceof Boolean) {
            return repoRun.getRuns();
        }
        return null;
    }

    @PostMapping("/new")
    public String doPost(HttpSession session, @RequestBody RunModel runModel) {
        if (session.getAttribute("isAuth") instanceof Boolean) {
            repoRun.addRun(runModel.getDistance(), runModel.getTime(), runModel.getDate());
            return "run was added";
        }
        return "403";

    }

    public String doPut(HttpSession session, @RequestBody String some) {
        return null;
    }

    public String doDelete(HttpSession session, @RequestBody String some) {
        return null;
    }
}
