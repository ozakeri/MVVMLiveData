package com.example.myapplication;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.myapplication.adapter.UserAdapter;
import com.example.myapplication.viewmodel.UserViewModel;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        UserViewModel userViewModel = ViewModelProviders.of(MainActivity.this).get(UserViewModel.class);

        final RecyclerView recyclerView = findViewById(R.id.recyclerView);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        userViewModel.getArrayListMutableLiveData.observe(this, new Observer<ArrayList<UserViewModel>>() {
            @Override
            public void onChanged(@Nullable ArrayList<UserViewModel> arrayList) {
                UserAdapter userAdapter = new UserAdapter(arrayList);
                recyclerView.setAdapter(userAdapter);
            }
        });
    }
}
