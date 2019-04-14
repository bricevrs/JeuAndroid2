package com.exemple.jeuandroid;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class MyDatabase {

    private final static String DATABASE_NAME = "myDatabase.db";
    private final static int DATABASE_VERSION = 1;
    private final static String TABLE_SCORE = "score_table";
    private final static String COL_ID = "ID";
    private final static String COL_NAME = "NAME";
    private final static String COL_SCORE = "SCORE";

    private static final String CREATE_DB =
            "create table " + TABLE_SCORE + " ("
                    + COL_ID + " integer primary key autoincrement, "
                    + COL_NAME + " text not null, "
                    + COL_SCORE + " integer);";

    private SQLiteDatabase database;
    private MyOpenHelper openHelper;

    public MyDatabase(Context context){
        openHelper = new MyOpenHelper(context, DATABASE_NAME,null,DATABASE_VERSION);
    }

    public void open(){
        database = openHelper.getReadableDatabase();
    }

    public void close(){
        database.close();
    }

    public ArrayList<Score> getAllScore(){
        ArrayList<Score> list_score = new ArrayList<>();
        Cursor c = database.query(TABLE_SCORE, new String[]{COL_ID, COL_NAME, COL_SCORE}, null,null,null,null,COL_SCORE+" DESC");
        c.moveToFirst();
        while(!(c.isAfterLast())){
            list_score.add(new Score(c.getLong(0),c.getString(1),c.getInt(2)));
            c.moveToNext();
        }
        c.close();
        return list_score;
    }

    public int removeScore(long id){
        return database.delete(TABLE_SCORE,COL_ID+" = "+id,null);
    }

    public long insertScore(String name, int score){
        ContentValues val = new ContentValues();
        val.put(COL_NAME,name);
        val.put(COL_SCORE,score);
        return database.insert(TABLE_SCORE, null, val);
    }

    private class MyOpenHelper extends SQLiteOpenHelper{


        public MyOpenHelper(Context context, String name,SQLiteDatabase.CursorFactory factory, int version) {
            super(context, name, factory, version);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL(CREATE_DB);
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL("drop table "+TABLE_SCORE+";");
            onCreate(db);
        }
    }
}
