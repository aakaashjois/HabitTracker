package com.biryanistudio.habittracker;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Aakaash on 24/03/17 at 2:07 PM.
 */

public class DatabaseHelper extends SQLiteOpenHelper {

    public DatabaseHelper(Context context) {
        super(context, DatabaseContract.DATABASE_NAME, null, DatabaseContract.DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + DatabaseContract.HabitEntry.TABLE_NAME + "("
                + DatabaseContract.HabitEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + DatabaseContract.HabitEntry.COLUMN_HABIT_NAME + " TEXT NOT NULL, "
                + DatabaseContract.HabitEntry.COLUMN_HABIT_COUNT + " INTEGER NOT NULL DEFAULT 0);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }

    public void insertHabit(String name, int count) {
        ContentValues values = new ContentValues();
        values.put(DatabaseContract.HabitEntry.COLUMN_HABIT_NAME, name);
        values.put(DatabaseContract.HabitEntry.COLUMN_HABIT_COUNT, count);
        getWritableDatabase().insert(DatabaseContract.HabitEntry.TABLE_NAME, null, values);
    }

    public Cursor readHabit() {
        return getReadableDatabase().query(
                DatabaseContract.HabitEntry.TABLE_NAME,
                new String[]{
                        DatabaseContract.HabitEntry._ID,
                        DatabaseContract.HabitEntry.COLUMN_HABIT_NAME,
                        DatabaseContract.HabitEntry.COLUMN_HABIT_COUNT
                },
                null,
                null,
                null,
                null,
                null);
    }
}
