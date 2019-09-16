package com.kotor.database;

import com.kotor.error.UserAlreadyExist;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class Repo {
    private Map<String, String> users = new HashMap<>();

    public Map<String, String> getUsers() {
        return users;
    }

    public void addUser(String name, String password) {
        String user = users.get(name);
        if(user == null) {
            users.put(name, password);
        } else {
            throw new UserAlreadyExist(name);
        }

    }



}
