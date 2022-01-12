package com.sanket.funplay;

public class Login_class {

    private String password;
    private String lock_mode;

    public Login_class() {
    }

    public Login_class(String password, String lock_mode) {
        this.password = password;
        this.lock_mode = lock_mode;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLock_mode() {
        return lock_mode;
    }

    public void setLock_mode(String lock_mode) {
        this.lock_mode = lock_mode;
    }
}
