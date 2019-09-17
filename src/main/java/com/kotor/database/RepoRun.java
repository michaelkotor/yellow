package com.kotor.database;

import com.kotor.logic.Run;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class RepoRun {
    private List<Run> runs = new ArrayList<>();

    public List<Run> getRuns() {
        return runs;
    }

    public void addRun(int distance, int time, String date) {
        runs.add(new Run(distance, time, date));
    }
}
