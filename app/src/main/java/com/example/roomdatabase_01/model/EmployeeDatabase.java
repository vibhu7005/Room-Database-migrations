package com.example.roomdatabase_01.model;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;

@Database(entities = EmployeeEntity.class, version = 3, exportSchema = false)
public abstract class EmployeeDatabase extends RoomDatabase {
    static final Migration MIGRATION_2_3 = new Migration(2, 3) {
        @Override
        public void migrate(SupportSQLiteDatabase database) {
            database.execSQL("ALTER TABLE 'Employee-Db' ADD COLUMN 'position' TEXT");
        }
    };
    public abstract EmployeeDao getEmployeeDao() ;
    private static EmployeeDatabase employeeDatabase;

    public static EmployeeDatabase getInstance(Context context) {
        if (employeeDatabase == null) {
            employeeDatabase = Room.databaseBuilder(context, EmployeeDatabase.class, "Room_DB")
                    .addMigrations(MIGRATION_2_3)
                    .build();
        }
        return employeeDatabase;
    }


}
