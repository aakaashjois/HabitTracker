package com.biryanistudio.habittracker;

import android.provider.BaseColumns;

/**
 * Created by Aakaash on 24/03/17 at 1:50 PM.
 */

class DatabaseContract {

    static final String DATABASE_NAME = "app_database";
    static final int DATABASE_VERSION = 1;

    public class HabitEntry implements BaseColumns {

        public static final String TABLE_NAME = "habit_entry";
        public static final String COLUMN_HABIT_NAME = "habit_name";
        public static final String COLUMN_HABIT_COUNT = "habit_count";
    }
}
