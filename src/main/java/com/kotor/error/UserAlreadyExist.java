package com.kotor.error;

public class UserAlreadyExist extends RuntimeException {
    private String message;
    public UserAlreadyExist(String name) {
        this.message = name;
    }

    @Override
    public String getMessage() {
        return "User already exits " + message;
    }
}
