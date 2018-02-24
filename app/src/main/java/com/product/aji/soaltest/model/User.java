package com.product.aji.soaltest.model;

/**
 * Created by LP on 2/24/2018.
 */

public class User {
    private String username;
    private String password;
    public String usernamehint;
    public String passwordhint;

    public User(String usernamehint, String passwordhint) {
        this.usernamehint = usernamehint;
        this.passwordhint = passwordhint;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
