package com.wong.databaseoptimize;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.support.annotation.NonNull;

/**
 * @author WongKyunban
 * description
 * created at 2019-04-08 上午11:11
 * @version 1.0
 */
public class MyDao {
    private  MyDBHelper dbHelper;
    public MyDao(@NonNull Context context){
        dbHelper = new MyDBHelper(context);
    }

    public void insertTable1(int id,String name,String school,int classNum){
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        db.beginTransaction();
        db.execSQL("insert into " + MyDBHelper.TABLE_NAME1 + " (Id, name, school, ban) values ("+id+", '"+name+"', '"+school+"', "+classNum+")");
        db.endTransaction();

    }

    public void insertTable2(String name,String school,int classNum){
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        db.beginTransaction();
        db.execSQL("insert into " + MyDBHelper.TABLE_NAME2 + " (name, school, ban) values ('"+name+"', '"+school+"', "+classNum+")");
        db.endTransaction();

    }
}
