package com.wong.databaseoptimize;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.NonNull;

/**
 * @author WongKyunban
 * description
 * created at 2019-04-08 上午10:53
 * @version 1.0
 */
public class MyDBHelper extends SQLiteOpenHelper {

    private static final int VERSION = 1;
    private static final String DB_NAME = "test.db";

    public static final String TABLE_NAME1 = "table1";
    public static final String TABLE_NAME2 = "table2";


    public MyDBHelper(@NonNull Context context) {
        super(context, DB_NAME, null, VERSION);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql1 = "create table if not exists " + TABLE_NAME1 + "(Id integer primary key, name text, school text, ban int)";
        String sql2 = "create table if not exists " + TABLE_NAME2 + "(Id integer primary key autoincrement, name text, school text, ban int)";
        db.execSQL(sql1);
        db.execSQL(sql2);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String sql1 = "DROP TABLE IF EXISTS " + TABLE_NAME1;
        String sql2 = "DROP TABLE IF EXISTS " + TABLE_NAME2;

        db.execSQL(sql1);
        db.execSQL(sql2);

        onCreate(db);
    }


}
