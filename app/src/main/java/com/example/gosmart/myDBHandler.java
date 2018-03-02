package com.example.gosmart;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class myDBHandler extends SQLiteOpenHelper {

    private static final int DATABSE_VERSION = 3;
    private static final String DATABASE_NAME = "products.db";
    public static final String TABLE_PRODUCTS = "products";
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_PRODUCTNAME = "productname";
    public static final String COLUMN_PRODUCTPRICE = "productprice";

    public myDBHandler(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME, factory, DATABSE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE " + TABLE_PRODUCTS + "(" +
                COLUMN_ID + " TEXT PRIMARY KEY, " +
                COLUMN_PRODUCTNAME + " TEXT, " +
                COLUMN_PRODUCTPRICE + " TEXT" +
                ");";
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_PRODUCTS + ";");
        onCreate(db);
    }

    public void addProduct(Products Product)
    {
        ContentValues values = new ContentValues();
        values.put(COLUMN_ID,Product.get_id());
        values.put(COLUMN_PRODUCTNAME,Product.get_productname());
        values.put(COLUMN_PRODUCTPRICE,Product.get_productprice());
        SQLiteDatabase db = getWritableDatabase();
        db.insert(TABLE_PRODUCTS,null,values);
        db.close();
    }

    public String databaseToString (String check)
    {
        String dbstring = "";
        SQLiteDatabase db = getWritableDatabase();
        String query = "SELECT * FROM " + TABLE_PRODUCTS + " WHERE " + COLUMN_ID + "=" + check + ";";

        Cursor c = db.rawQuery(query,null);
        c.moveToFirst();
        if (c.getString(c.getColumnIndex("productname")) != null)
        {
            //dbstring += c.getString(c.getColumnIndex("_id"));
            //dbstring += "\t\t\t\t";
            dbstring += c.getString(c.getColumnIndex("productname"));
            dbstring += "\t\t\t\t";
            dbstring += c.getString(c.getColumnIndex("productprice"));
            dbstring += "\n";
        }
        db.close();
        return dbstring;
    }
}