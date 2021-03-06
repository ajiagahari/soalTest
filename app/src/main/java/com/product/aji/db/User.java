package com.product.aji.db;

import org.greenrobot.greendao.annotation.*;

// THIS CODE IS GENERATED BY greenDAO, EDIT ONLY INSIDE THE "KEEP"-SECTIONS

// KEEP INCLUDES - put your custom includes here
// KEEP INCLUDES END

/**
 * Entity mapped to table "USER".
 */
@Entity
public class User {

    @Id(autoincrement = true)
    private Long id;
    private String username;
    private String password;

    // KEEP FIELDS - put your custom fields here
    // KEEP FIELDS END

    @Generated
    public User() {
    }

    public User(Long id) {
        this.id = id;
    }

    @Generated
    public User(Long id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    // KEEP METHODS - put your custom methods here
    // KEEP METHODS END

}
