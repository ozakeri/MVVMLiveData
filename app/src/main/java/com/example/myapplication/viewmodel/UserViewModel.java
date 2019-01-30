package com.example.myapplication.viewmodel;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import com.example.myapplication.model.User;

import java.util.ArrayList;

public class UserViewModel extends ViewModel {
    private String name;
    private String family;
    public MutableLiveData<ArrayList<UserViewModel>> getArrayListMutableLiveData = new MutableLiveData<>();
    private ArrayList<UserViewModel> arrayList;

    public UserViewModel(String name, String family) {
        this.name = name;
        this.family = family;
    }

    public UserViewModel(User user) {
        this.name = user.getName();
        this.family = user.getFamily();
    }

    public UserViewModel() {
        arrayList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            User user = new User("one", "two");
            UserViewModel userViewModel = new UserViewModel(user);
            arrayList.add(userViewModel);
        }
        getArrayListMutableLiveData.setValue(arrayList);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFamily() {
        return family;
    }

    public void setFamily(String family) {
        this.family = family;
    }
}
