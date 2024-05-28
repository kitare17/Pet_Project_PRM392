package com.example.recycleview.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import com.example.recycleview.R;
import com.example.recycleview.model.Shop;

import java.util.ArrayList;
import java.util.List;

public class ShopDB extends SQLiteOpenHelper {

    private Context context;

    public static final String DATABASE_NAME = "ShopDB";

    public static final String TABLE_NAME = "Shop";
    public static final int DATABASE_VERSION = 1;


    public static final String COLUMN_ID = "id";
    public static final String COLUMN_NAME = "name";

    public static final String COlUMN_IMAGE = "image";

    public ShopDB(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String query = "CREATE TABLE " + TABLE_NAME + " (" +
                COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_NAME + " TEXT, " +
                COlUMN_IMAGE + " INTEGER " +
                ")";
        sqLiteDatabase.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(sqLiteDatabase);
    }

    public void deleteAll(){
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("delete from "+ TABLE_NAME);
    }

    public void insertShop(String name, int image){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COLUMN_NAME, name);
        values.put(COlUMN_IMAGE, image);
        long result=db.insert(TABLE_NAME, null, values);
        if(result==-1){
            Toast.makeText(context, "Failed", Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(context, "Added Successfully", Toast.LENGTH_SHORT).show();
        }
    }

    public List<Shop> getAllShop(){
        List<Shop> shopList = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT "+COLUMN_NAME+", "+COlUMN_IMAGE+" FROM " + TABLE_NAME, null);
        if (cursor.moveToFirst()){
            do {
                String name = cursor.getString(0);
                int image = cursor.getInt(1);
                Shop shop = new Shop(image, name);
                shopList.add(shop);
            } while (cursor.moveToNext());
        }
        cursor.close();
        return shopList;
    }

    public static void main(String[] args) {


    }
}
