package com.kotor.contollers;

import com.kotor.database.RepoRun;
import com.kotor.models.RunModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping("/api")
public class Main {
    @Autowired
    private RepoRun repoRun;


    @GetMapping("/runs")
    public List<RunModel> getAllRuns(HttpSession session) {
        if (session.getAttribute("isAuth") instanceof Boolean) {
            return repoRun.getRuns();
        }
        return null;
    }

    @PostMapping("/new")
    public String create(HttpSession session, @RequestBody RunModel runModel) {
        if (session.getAttribute("isAuth") instanceof Boolean) {
            repoRun.addRun(runModel);
            return "run was added";
        }
        return "403";

    }

    @PutMapping()
    public String update(HttpSession session, @RequestBody RunModel runModel) {
        if (session.getAttribute("isAuth") instanceof Boolean) {
            repoRun.update(runModel);
            return "updated";
        }
        return "403";
    }

    @DeleteMapping("/run/{id}")
    public String remove(HttpSession session, @PathVariable long id) {
        if (session.getAttribute("isAuth") instanceof Boolean) {
            repoRun.remove(id);
            return "removed";
        }
        return "403";
    }
}
