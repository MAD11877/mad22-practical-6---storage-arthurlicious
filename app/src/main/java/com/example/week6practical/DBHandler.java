package com.example.week6practical;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class DBHandler extends SQLiteOpenHelper {


    public DBHandler(Context context) {

        super(context, "Week6Practical.db",null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String sql = "CREATE TABLE User (Id_TEXT, Username_TEXT, Description_TEXT, Followed_TEXT)";
        sqLiteDatabase.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS User");
        onCreate(sqLiteDatabase);

    }

    public void insertUser(User user){
        SQLiteDatabase database=this.getWritableDatabase();
        database.execSQL("INSERT INTO User VALUES(\"" + user.id + "\", \"" + user.username + "\", \"" + user.description + "\", \"" + user.followed + "\" )");
        database.close();
    }

    public void updateUser(User user){
        SQLiteDatabase database=this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("Id_TEXT", user.id);
        contentValues.put("Username_TEXT", user.username);
        contentValues.put("Description_TEXT", user.description);
        contentValues.put("Followed_TEXT", user.followed);
        database.replace("User", null, contentValues);
//        database.execSQL("UPDATE User (Id_TEXT, Username_TEXT, Description_TEXT, Followed_TEXT) SET(\"" + user.id + "\", \"" + user.username + "\", \"" + user.description + "\", \"" + user.followed + "\" ) WHERE Id_TEXT = \"" + user.id +"\" ");
//        database.close();

    }

    public ArrayList<User> getUsers(){
        SQLiteDatabase database=this.getWritableDatabase();
        ArrayList<User> list = new ArrayList<>();

        Cursor cursor = database.rawQuery("SELECT * FROM MESSAGE", null);
        while(cursor.moveToNext()){
            User user = new User();
            // retrieving column value
            user.id = cursor.getInt(0);
            user.username = cursor.getString(1);
            user.description = cursor.getString(2);
            user.followed = (cursor.getInt(3) > 0);

            list.add(user);
        }

        return list;
    }
}
