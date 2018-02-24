package com.greendao;
import org.greenrobot.greendao.generator.DaoGenerator;
import org.greenrobot.greendao.generator.Entity;
import org.greenrobot.greendao.generator.Schema;

public class MyGenerator {
    public static void main(String[] args) {
        Schema schema = new Schema(1, "com.product.aji.db"); // Your app package name and the (.db) is the folder where the DAO files will be generated into.
        schema.enableKeepSectionsByDefault();

        addTables(schema);

        try {
            new DaoGenerator().generateAll(schema,"./app/src/main/java");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void addTables(final Schema schema) {
        addUserEntities(schema);
        addItemEntities(schema);
    }

    // This is use to describe the colums of your table
    private static Entity addUserEntities(final Schema schema) {
        Entity user = schema.addEntity("User");
        user.addIdProperty().primaryKey().autoincrement();
        user.addStringProperty("username");
        user.addStringProperty("password");
        return user;
    }
    private static Entity addItemEntities(final Schema schema) {
        Entity item = schema.addEntity("Item");
        item.addIdProperty().primaryKey().autoincrement();
        item.addStringProperty("judul");
        item.addStringProperty("pemasok");
        item.addStringProperty("jumlah");
        item.addStringProperty("tanggal");
        return item;
    }
}
