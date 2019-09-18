package com.kotor.database;

import com.kotor.models.RunModel;
import com.kotor.models.StatModel;
import org.springframework.stereotype.Repository;

import java.util.*;

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

    public List<StatModel> getStat() {
        List<StatModel> stats = new ArrayList<>();
        Date start = runs.get(0).getDate();
        Date finish = runs.get(0).getDate();
        for (int i = 0; i < runs.size(); i++) {
            if (runs.get(i).getDate().before(start)) {
                start = runs.get(i).getDate();
            }
            if (runs.get(i).getDate().after(finish)) {
                finish = runs.get(i).getDate();
            }
        }
        Calendar calendar1 = new GregorianCalendar(start.getYear(), start.getMonth(), start.getDay());
        Calendar calendar2 = new GregorianCalendar(finish.getYear(), finish.getMonth(), finish.getDate());
        for (long i = start.getTime(); i < finish.getTime(); i = i + 604800 * 1000) {
            double speedAv;
            double timeAv;
            double totalLength = 0;
            double totalTime = 0;
            List<RunModel> tempList = new ArrayList<>();
            for (int k = 0; k < runs.size(); k++) {
                if (runs.get(k).getDate().getTime() < i) {
                    tempList.add(runs.get(k));
                }
            }
            for (int k = 0; k < tempList.size(); k++) {
                totalLength += tempList.get(k).getDistance();
                totalTime += tempList.get(k).getTime();
            }
            speedAv = totalLength / totalTime;
            timeAv = totalTime / tempList.size();
            stats.add(new StatModel(start, finish, speedAv, timeAv, totalLength));
        }
        return stats;

    }
}
