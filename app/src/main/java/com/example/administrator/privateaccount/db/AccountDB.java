package com.example.administrator.privateaccount.db;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.administrator.privateaccount.dao.Tb_inaccount;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/4/5.
 */
public class AccountDB  {

    private static final String DB_NAME = "account.db";
    private static final int DB_VERSION = 2;

    private static AccountDB accountDB;
    private SQLiteDatabase db;

    private AccountDB(Context context) {
        AccountDBHelp dbHelper = new AccountDBHelp(context,DB_NAME,null,DB_VERSION);
        db = dbHelper.getWritableDatabase();
    }

    public synchronized static AccountDB getInstance(Context context) {
        if(accountDB == null) {
            accountDB = new AccountDB(context);
        }

        return accountDB;
    }

    public void saveInAccount(Tb_inaccount tb_inaccount) {
        db.execSQL("insert into tb_inaccount (money,time,type,handler,mark)" +
                " values (?,?,?,?,?)", new Object[]{tb_inaccount.getMoney(),
            tb_inaccount.getTime(),tb_inaccount.getType(),tb_inaccount.getHandler(),tb_inaccount.getMark()});
    }

    public void updateInAccount(Tb_inaccount tb_inaccount) {
        db.execSQL("update tb_inaccount set money = ?,time = ?,type = ?,handler= ?," +
                "mark = ? where _id = ?",new Object[]{tb_inaccount.getMoney(),tb_inaccount.getTime(),tb_inaccount.getType(),tb_inaccount.getHandler(),
        tb_inaccount.getMark(),tb_inaccount.get_id()});
    }

    public List<Tb_inaccount> queryTb_inaccount() {
        List<Tb_inaccount> tb_inaccountList = new ArrayList<Tb_inaccount>();
        Cursor cursor = db.rawQuery("select * from tb_inaccount",null);
        if(cursor.moveToFirst()) {
            do {
                Tb_inaccount tb_inaccount = new Tb_inaccount();
                tb_inaccount.set_id(cursor.getInt(cursor.getColumnIndex("_id")));
                tb_inaccount.setMoney(cursor.getDouble(cursor.getColumnIndex("money")));
                tb_inaccount.setTime(cursor.getString(cursor.getColumnIndex("time")));
                tb_inaccount.setType(cursor.getString(cursor.getColumnIndex("type")));
                tb_inaccount.setHandler(cursor.getString(cursor.getColumnIndex("handler")));
                tb_inaccount.setMark(cursor.getString(cursor.getColumnIndex("mark")));
                tb_inaccountList.add(tb_inaccount);
            } while (cursor.moveToNext());
        }
        return tb_inaccountList;
    }

}
