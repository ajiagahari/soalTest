package com.product.aji.soaltest.adapter;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import com.product.aji.db.Item;
import com.product.aji.soaltest.R;
import com.product.aji.soaltest.databinding.ListRowBinding;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by LP on 2/24/2018.
 */

public class ItemDaoAdapter extends ArrayAdapter<Item> {
    private Context context;
    private List<Item> itemArrayList;

    public ItemDaoAdapter(@NonNull Context context, @NonNull List<Item> objects) {
        super(context, R.layout.list_row, objects);
        this.context = context;
        this.itemArrayList = objects;
    }
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        ListRowBinding listRowBinding = DataBindingUtil.inflate(layoutInflater,R.layout.list_row,parent,false);
        listRowBinding.setItemList(itemArrayList.get(position));
        return listRowBinding.getRoot();
    }
}
