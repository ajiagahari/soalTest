package com.product.aji.soaltest;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import com.product.aji.db.DaoMaster;
import com.product.aji.db.DaoSession;
import com.product.aji.db.Item;
import com.product.aji.db.ItemDao;
import com.product.aji.soaltest.adapter.ItemDaoAdapter;
import com.product.aji.soaltest.commands.ItemList;
import com.product.aji.soaltest.databinding.ActivityListBinding;
import com.product.aji.soaltest.viewModel.ItemModel;

import org.greenrobot.greendao.database.Database;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by LP on 2/24/2018.
 */

public class ListActivity extends AppCompatActivity {

    private ActivityListBinding activityListBinding;
    private ItemModel itemModel;
    private ItemDaoAdapter itemDaoAdapter;
    private List<Item> itemlist;
    private DaoSession daoSession;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        itemlist = new ArrayList<Item>();
        itemDaoAdapter = new ItemDaoAdapter(this,itemlist);
        activityListBinding = DataBindingUtil.setContentView(this,R.layout.activity_list);
        itemModel = new ItemModel();
        DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(ListActivity.this,"TEST");
        Database db = helper.getWritableDb();
        daoSession = new DaoMaster(db).newSession();
        activityListBinding.listItem.setAdapter(itemDaoAdapter);
        fetchItemList();
        activityListBinding.setItemListEvent(new ItemList() {
            @Override
            public void AddNewOnclick() {

                Intent intent = new Intent(ListActivity.this, InsertActivity.class);
                ListActivity.this.startActivityForResult(intent,200);
            }

            @Override
            public void InsertOnclick() {

            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        fetchItemList();
//        Toast.makeText(ListActivity.this,"masuk",Toast.LENGTH_SHORT).show();
    }
    private void fetchItemList(){
        if (!itemlist.isEmpty()){
            itemlist.clear();
        }
        //// Get the entity dao we need to work with.
        ItemDao itemDao = daoSession.getItemDao();

        //// Load all items
        itemlist.addAll(itemDao.loadAll());

        /// Notify our adapter of changes
        itemDaoAdapter.notifyDataSetChanged();
    }
}
