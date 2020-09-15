package com.chagok.chagokgreen;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class DBHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "Chagokk.db";
    // 회원가입 TABLE
    public static final String CHAGOK_TABLE_NAME = "signup";
    public static final String CHAGOK_COLUMN_ID = "id";
    public static final String CHAGOK_COLUMN_NAME = "name";
    public static final String CHAGOK_COLUMN_LOGINID = "loginid";
    public static final String CHAGOK_COLUMN_PASSWORD = "password";
    public static final String CHAGOK_COLUMN_PHONE = "phone";
    public static final String CHAGOK_COLUMN_EMAIL = "email";
    public static String setName = "";
    public static String setLoginid = "";
    public static String setPw = "";
    private String[] array_seq;

    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(         //id password name phone email
                "create table signup " +
                        "( name string, loginid string, password string, phone string, email string, id ingeger primary key)"
        );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS signup");
        onCreate(db);
    }
    //id password name phone email
    public boolean insertSignup(String name, String loginid, String password, String phone, String email) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put("name", name);
        contentValues.put("loginid", loginid);
        contentValues.put("password", password);
        contentValues.put("phone", phone);
        contentValues.put("email", email);

        db.insert("signup", null, contentValues);
        return true;
    }


    public Cursor getData(int id) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res = db.rawQuery("select * from signup where id=" + id + "", null);
        return res;
    }

    public int numberOfRows() {
        SQLiteDatabase db = this.getReadableDatabase();
        int numRows = (int) DatabaseUtils.queryNumEntries(db, CHAGOK_TABLE_NAME);
        return numRows;
    }

    public Integer deleteSignup(Integer id) {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete("signup",
                "id = ? ",
                new String[]{Integer.toString(id)});
    }

    public boolean updateSignup(String name, String loginid, String password, String phone, String email) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put("name", name);
        contentValues.put("loginid", loginid);
        contentValues.put("password", password);
        contentValues.put("phone", phone);
        contentValues.put("email", email);
        db.update("signup", contentValues, "id = ? ", null);
        return true;
    }

    public String getName() {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res = db.rawQuery("select * from signup", null);
        res.moveToFirst();
        while (res.isAfterLast() == false) {
            setName = res.getString(res.getColumnIndex(CHAGOK_COLUMN_NAME));

            res.moveToNext();
        }
        return setName;
    }


    public String getLoginid() {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res = db.rawQuery("select * from signup", null);
        res.moveToFirst();
        while (res.isAfterLast() == false) {
            setLoginid = res.getString(res.getColumnIndex(CHAGOK_COLUMN_LOGINID));

            res.moveToNext();
        }
        return setLoginid;
    }

    public String getPw() {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res = db.rawQuery("select * from signup", null);
        res.moveToFirst();
        while (res.isAfterLast() == false) {
            setPw = res.getString(res.getColumnIndex(CHAGOK_COLUMN_PASSWORD));

            res.moveToNext();
        }
        return setPw;
    }

    public String[] getId(int seq) {
        ArrayList array_list = new ArrayList();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res = db.rawQuery("select * from zimlist", null);
        res.moveToFirst();
        seq = 0;
        while (res.isAfterLast() == false) {
            array_list.add(seq +". "+   // 목록 순서 번호 매기기
                    res.getString(res.getColumnIndex(CHAGOK_COLUMN_NAME))+ " \n"+
                    res.getString(res.getColumnIndex(CHAGOK_COLUMN_LOGINID))+" || "+
                    res.getString(res.getColumnIndex(CHAGOK_COLUMN_PASSWORD)));

            array_seq[seq] = res.getString(res.getColumnIndex(CHAGOK_COLUMN_ID));  // 배열에 PK값 넣기
            seq++;

            res.moveToNext();
        }
        return array_seq;
    }

}
