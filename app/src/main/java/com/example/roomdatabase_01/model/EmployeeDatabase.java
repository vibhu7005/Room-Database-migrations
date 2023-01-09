package com.example.roomdatabase_01.model;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = EmployeeEntity.class, version = 2, exportSchema = false)
public abstract class EmployeeDatabase extends RoomDatabase {
    public abstract EmployeeDao getEmployeeDao() ;
    private static EmployeeDatabase employeeDatabase;

    public static EmployeeDatabase getInstance(Context context) {
        if (employeeDatabase == null) {
            employeeDatabase = Room.databaseBuilder(context, EmployeeDatabase.class, "Room_DB").fallbackToDestructiveMigrationFrom(1).build();
        }
        return employeeDatabase;
    }


}
