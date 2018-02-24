package com.product.aji.soaltest;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.product.aji.db.DaoMaster;
import com.product.aji.db.DaoSession;
import com.product.aji.db.UserDao;
import com.product.aji.soaltest.commands.UserLogin;
import com.product.aji.soaltest.databinding.ActivityMainBinding;
import com.product.aji.soaltest.model.User;
import com.product.aji.soaltest.viewModel.UserModel;

import org.greenrobot.greendao.database.Database;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding activityMainBinding;
    private DaoSession daoSession;
    private List<com.product.aji.db.User> userList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        userList = new ArrayList<com.product.aji.db.User>();
        activityMainBinding = DataBindingUtil.setContentView(this,R.layout.activity_main);
        DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(MainActivity.this,"TEST");
        Database db = helper.getWritableDb();
        daoSession = new DaoMaster(db).newSession();
        UserDao userDao = daoSession.getUserDao();
        userList.addAll(userDao.loadAll());
        if (userList.isEmpty()){
            insertUser();
        }
        UserModel userModel = new UserModel(new User("username","password"));
        activityMainBinding.setLogin(userModel);
        activityMainBinding.setUserLoginEvent(new UserLogin() {
            @Override
            public void OnclickLogin() {
                if (checkLogin()){
                    Intent intent = new Intent(MainActivity.this,ListActivity.class);
                    MainActivity.this.startActivity(intent);
                    finish();
                }
                else {
                    Toast.makeText(MainActivity.this,"Maaf Login Error",Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
    public Boolean checkLogin(){
        Boolean istrue = false;
        UserDao userDao = daoSession.getUserDao();
        com.product.aji.db.User userd = userDao.queryBuilder()
                .where(UserDao.Properties.Username.eq(activityMainBinding.getLogin().getUsername())).orderAsc(UserDao.Properties.Id).list().get(0);
        Log.d("ini log","DAO username"+userd.getUsername()+" DAO password"+userd.getPassword());
        Log.d("ini log 2","bind username"+activityMainBinding.getLogin().getUsername()+" bind password"+activityMainBinding.getLogin().getPassword());
        if (Objects.equals(userd.getPassword(), activityMainBinding.getLogin().getPassword())){
            istrue = true;
        }
        return istrue;
    }
    public void insertUser(){
        UserDao userDao = daoSession.getUserDao();
        com.product.aji.db.User user = new com.product.aji.db.User();
        user.setUsername("demouser");
        user.setPassword("demopassword");
        userDao.insert(user);
    }
    public DaoSession getDaoSession() {
        return daoSession;
    }

}

