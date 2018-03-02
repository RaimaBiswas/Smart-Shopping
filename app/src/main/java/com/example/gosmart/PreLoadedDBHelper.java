package com.example.gosmart;

/**
 * Created by Raimu on 02/07/2017.
 */

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.google.gson.Gson;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

public class PreLoadedDBHelper extends SQLiteOpenHelper {
    private static final int DB_VERSION = 1;
    private static String DB_NAME = "gosmart.db";
    private static String DB_PATH = "";
    private final Context mContext;
    private SQLiteDatabase mDataBase;
    private boolean mNeedUpdate = false;

    public PreLoadedDBHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
        if (android.os.Build.VERSION.SDK_INT >= 17)
            DB_PATH = context.getApplicationInfo().dataDir + "/databases/";
        else
            DB_PATH = "/data/data/" + context.getPackageName() + "/databases/";
        this.mContext = context;

        copyDataBase();

        this.getReadableDatabase();
    }

    public void updateDataBase() throws IOException {
        if (mNeedUpdate) {
            File dbFile = new File(DB_PATH + DB_NAME);
            if (dbFile.exists())
                dbFile.delete();

            copyDataBase();

            mNeedUpdate = false;
        }
    }

    private boolean checkDataBase() {
        File dbFile = new File(DB_PATH + DB_NAME);
        return dbFile.exists();
    }

    private void copyDataBase() {
        if (!checkDataBase()) {
            this.getReadableDatabase();
            this.close();
            try {
                copyDBFile();
            } catch (IOException mIOException) {
                throw new Error("ErrorCopyingDataBase");
            }
        }
    }

    private void copyDBFile() throws IOException {
        //InputStream mInput = mContext.getAssets().open(DB_NAME);
        InputStream mInput = mContext.getResources().openRawResource(R.raw.gosmart);
        OutputStream mOutput = new FileOutputStream(DB_PATH + DB_NAME);
        byte[] mBuffer = new byte[1024];
        int mLength;
        while ((mLength = mInput.read(mBuffer)) > 0)
            mOutput.write(mBuffer, 0, mLength);
        mOutput.flush();
        mOutput.close();
        mInput.close();
    }

    public boolean openDataBase() throws SQLException {
        mDataBase = SQLiteDatabase.openDatabase(DB_PATH + DB_NAME, null, SQLiteDatabase.CREATE_IF_NECESSARY);
        return mDataBase != null;
    }

    @Override
    public synchronized void close() {
        if (mDataBase != null)
            mDataBase.close();
        super.close();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if (newVersion > oldVersion)
            mNeedUpdate = true;
    }

    public List<ProductAvailability> getMatchingStoreList(String product) {
        List<ProductAvailability> availabilityList = new ArrayList<>();
        String query = "SELECT * FROM ProductInventory WHERE Product = '" + product + "';";
        SQLiteDatabase db = this.getWritableDatabase();

        Gson gson = new Gson();
        try {
            Cursor cursor = db.rawQuery(query, null);
            // looping through all rows and adding to list
            if (cursor.moveToFirst()) {
                do {
                    for (int i = 1; i <= 6; i++) {
                        //ProductAvailability productAvailability = new ProductAvailability();
                        System.out.println(i);
                        System.out.println(cursor.getString(i));
                        ProductAvailability productAvailability = gson.fromJson(cursor.getString(i), ProductAvailability.class);
                        productAvailability.setStore(cursor.getColumnName(i));
                        if (productAvailability.isAvailable()) {
                            availabilityList.add(productAvailability);
                        }
                    }
                } while (cursor.moveToNext());
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            this.close();
        }
        return availabilityList;
    }
}

