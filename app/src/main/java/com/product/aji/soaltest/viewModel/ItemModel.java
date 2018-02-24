package com.product.aji.soaltest.viewModel;

import android.databinding.BaseObservable;

import com.product.aji.soaltest.R;
import com.product.aji.soaltest.model.Item;

import java.util.ArrayList;

/**
 * Created by LP on 2/24/2018.
 */

public class ItemModel extends BaseObservable {
    private String judul;
    private String pemasok;
    private String jumlah;
    private String tanggal;
    private String judulhint;
    private String pemasokhint;
    private String jumlahhint;
    private String tanggalhint;

    public ItemModel(){

    }
    public ItemModel(String judulhint, String pemasokhint, String jumlahhint, String tanggalhint){
        this.judulhint = judulhint;
        this.pemasokhint = pemasokhint;
        this.jumlahhint = jumlahhint;
        this.tanggalhint = tanggalhint;
    }
    public ItemModel(Item item) {
        this.judul = item.getJudul();
        this.pemasok = item.getPemasok();
        this.jumlah = item.getJumlah();
        this.tanggal = item.getTanggal();
    }

    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
        notifyPropertyChanged(R.id.judul);
    }

    public String getPemasok() {
        return pemasok;
    }

    public void setPemasok(String pemasok) {
        this.pemasok = pemasok;
        notifyPropertyChanged(R.id.pemasok);
    }

    public String getJumlah() {
        return jumlah;
    }

    public void setJumlah(String jumlah) {
        this.jumlah = jumlah;
        notifyPropertyChanged(R.id.jumlah);
    }

    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
        notifyPropertyChanged(R.id.tanggal);
    }

    public String getJudulhint() {
        return judulhint;
    }

    public String getPemasokhint() {
        return pemasokhint;
    }

    public String getJumlahhint() {
        return jumlahhint;
    }

    public String getTanggalhint() {
        return tanggalhint;
    }

    public ArrayList<ItemModel> getListItem(){
        ArrayList<ItemModel> ItemArrayList = new ArrayList<>();
        ItemModel item1 = new ItemModel(new Item("buku1","orang1","2","19-10-2011"));
        ItemModel item2 = new ItemModel(new Item("buku2","orang2","2","19-10-2011"));
        ItemModel item3 = new ItemModel(new Item("buku3","orang3","2","19-10-2011"));
        ItemModel item4 = new ItemModel(new Item("buku4","orang4","2","19-10-2011"));
        ItemArrayList.add(item1);
        ItemArrayList.add(item2);
        ItemArrayList.add(item3);
        ItemArrayList.add(item4);

        return  ItemArrayList;

    }
}
