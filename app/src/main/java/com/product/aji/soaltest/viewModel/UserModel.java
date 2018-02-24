package com.product.aji.soaltest.viewModel;

import android.databinding.BaseObservable;

import com.product.aji.soaltest.R;
import com.product.aji.soaltest.model.User;

/**
 * Created by LP on 2/24/2018.
 */

public class UserModel extends BaseObservable{
    private String username;
    private String password;
    private String usernamehint;
    private String passwordhint;
    private User user;

    public UserModel(User user) {
        this.usernamehint = user.usernamehint;
        this.passwordhint = user.passwordhint;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
        notifyPropertyChanged(R.id.usernameid);
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
        notifyPropertyChanged(R.id.passwordid);
    }

    public String getUsernamehint() {
        return usernamehint;
    }

    public void setUsernamehint(String usernamehint) {
        this.usernamehint = usernamehint;
    }

    public String getPasswordhint() {
        return passwordhint;
    }

    public void setPasswordhint(String passwordhint) {
        this.passwordhint = passwordhint;
    }
}
