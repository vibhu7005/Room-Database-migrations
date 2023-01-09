package com.example.roomdatabase_01.model;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.Single;

//Data access object
@Dao
public interface EmployeeDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    Completable insertEmployee(EmployeeEntity employee);

    @Update
    Completable updateEmployee(EmployeeEntity employee);

    @Delete
    Completable deleteEmployeeWithId(EmployeeEntity employee);

    @Query("SELECT * FROM `Employee-Db`")
    Flowable<List<EmployeeEntity>> fetchAllEmployees();
}
