package com.example.administrator.privateaccount.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Administrator on 2016/4/5.
 */
public class AccountDBHelp extends SQLiteOpenHelper {

    public static final String TB_OUTACCOUNT = "create table tb_outaccount(_id integer primary key," +
            "money decimal,time varchar(10),type varchar(10),address varchar(100),mark varchar(200))";
    public static final String TB_INACCOUNT = "create table tb_inaccount(_id integer primary key," +
            "money decimal,time varchar(10),type varchar(10),handler varchar(100),mark varchar(200))";
    public static final String TB_PWD = "create table tb_pwd(password varchar(20))";
    public static final String TB_FLAG = "create table tb_flag(_id integer primary key,flag varchar(200))";


    public AccountDBHelp(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(TB_OUTACCOUNT);
        db.execSQL(TB_INACCOUNT);
        db.execSQL(TB_FLAG);
        db.execSQL(TB_PWD);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
