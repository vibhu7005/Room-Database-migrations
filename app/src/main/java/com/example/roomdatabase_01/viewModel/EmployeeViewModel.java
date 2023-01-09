package com.example.roomdatabase_01.viewModel;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import com.example.roomdatabase_01.model.EmployeeDatabase;
import com.example.roomdatabase_01.model.EmployeeEntity;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class EmployeeViewModel extends AndroidViewModel {
    CompositeDisposable disposable = new CompositeDisposable();
    List<EmployeeEntity> employeeList = new ArrayList<>();

    public EmployeeViewModel(@NonNull Application application) {
        super(application);
    }
    {
        disposable.add(EmployeeDatabase.getInstance(getApplication()).getEmployeeDao().fetchAllEmployees()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::getDataUpdates));
    }

    private void getDataUpdates(List<EmployeeEntity> employeeList) {
        //put this data in recycler view
        Log.d("vaibhav", employeeList.size()+"");
        this.employeeList = employeeList;
    }

    public void insertEmployee(EmployeeEntity employee) {
        disposable.add(EmployeeDatabase.getInstance(getApplication()).getEmployeeDao().insertEmployee(employee).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe());
    }

    public void updateEmployee(String name, String email) {
        EmployeeEntity updatedEmployee = employeeList.get(0);
        updatedEmployee.setName(name);
        updatedEmployee.setEmailAddress(email);
        disposable.add(EmployeeDatabase.getInstance(getApplication()).getEmployeeDao().updateEmployee(updatedEmployee).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe());
    }

    public void deleteEmployee() {
        EmployeeEntity employeeTobeDeleted = employeeList.get(0);
        disposable.add(EmployeeDatabase.getInstance(getApplication()).getEmployeeDao().deleteEmployeeWithId(employeeTobeDeleted)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe());
    }


    @Override
    protected void onCleared() {
        super.onCleared();
        disposable.clear();
    }
}
