package com.product.aji.soaltest;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

import com.product.aji.db.DaoMaster;
import com.product.aji.db.DaoSession;
import com.product.aji.db.Item;
import com.product.aji.db.ItemDao;
import com.product.aji.soaltest.R;
import com.product.aji.soaltest.commands.ItemList;
import com.product.aji.soaltest.databinding.ActivityInsertBinding;
import com.product.aji.soaltest.viewModel.ItemModel;

import org.greenrobot.greendao.database.Database;

/**
 * Created by LP on 2/24/2018.
 */

public class InsertActivity  extends AppCompatActivity{
    private ActivityInsertBinding activityInsertBinding;
    private ItemModel itemModel;
    private DaoSession daoSession;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(InsertActivity.this,"TEST");
        Database db = helper.getWritableDb();
        daoSession = new DaoMaster(db).newSession();
        activityInsertBinding = DataBindingUtil.setContentView(this, R.layout.activity_insert);
        itemModel = new ItemModel("Judul","Pemasok","Jumlah","Tanggal");
        activityInsertBinding.setItem(itemModel);
        activityInsertBinding.setInsertItemEvent(new ItemList() {
            @Override
            public void AddNewOnclick() {

            }

            @Override
            public void InsertOnclick() {
                ItemDao itemDao = daoSession.getItemDao();
                Item item = new Item();
                item.setJudul(activityInsertBinding.getItem().getJudul());
                item.setPemasok(activityInsertBinding.getItem().getPemasok());
                item.setJumlah(activityInsertBinding.getItem().getJumlah());
                item.setTanggal(activityInsertBinding.getItem().getTanggal());
                itemDao.insert(item);
                setResult(200);
                finish();
            }
        });
    }
}
