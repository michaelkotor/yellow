package com.kotor.database;

import com.kotor.models.RunModel;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class RepoRun {
    private List<RunModel> runs = new ArrayList<>();

    public List<RunModel> getRuns() {
        return runs;
    }

    public void addRun(RunModel runModel) {
        runs.add(runModel);
    }

    public void remove(long id) {
        for (int i = 0; i < runs.size(); i++) {
            if (runs.get(i).getId() == id) {
                runs.remove(i);
                return;
            }
        }
    }

    public void update(RunModel runModel) {
        for (int i = 0; i < runs.size(); i++) {
            if (runModel.getId() == runs.get(i).getId()) {
                runs.remove(i);
                runs.add(runModel);
                return;
            }
        }
    }
}
