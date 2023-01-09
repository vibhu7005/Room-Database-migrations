package com.example.roomdatabase_01.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;

import com.example.roomdatabase_01.databinding.ActivityEmployeeDetailsHomeBinding;
import com.example.roomdatabase_01.model.EmployeeEntity;
import com.example.roomdatabase_01.viewModel.EmployeeViewModel;

public class EmployeeDetailsHomeActivity extends AppCompatActivity {
    private ActivityEmployeeDetailsHomeBinding binding;
    private EmployeeViewModel viewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityEmployeeDetailsHomeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        viewModel = new ViewModelProvider(this).get(EmployeeViewModel.class);
        //viewModel.getA();
        binding.buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EmployeeEntity employee = new EmployeeEntity(binding.etName.getText().toString(),
                        binding.etEmail.getText().toString(), binding.etMobile.getText().toString());
                viewModel.insertEmployee(employee);
            }
        });

        binding.buttonUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewModel.updateEmployee("zoravar", "zoravar.gmail.com");
            }
        });

        binding.buttonDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewModel.deleteEmployee();
            }
        });
    }
}