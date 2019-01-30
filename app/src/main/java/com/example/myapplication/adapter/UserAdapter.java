package com.example.myapplication.adapter;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.myapplication.R;
import com.example.myapplication.databinding.UserBinding;
import com.example.myapplication.viewmodel.UserViewModel;

import java.util.ArrayList;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.CustomViewModel> {

    private Context context;
    private ArrayList<UserViewModel> userViewModels;
    private LayoutInflater inflater;


    public UserAdapter(ArrayList<UserViewModel> arrayList) {
        this.userViewModels = arrayList;
    }

    @NonNull
    @Override
    public CustomViewModel onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        if (inflater == null) {
            inflater = LayoutInflater.from(viewGroup.getContext());
        }
        UserBinding userBinding = DataBindingUtil.inflate(inflater, R.layout.item_list, viewGroup, false);
        return new CustomViewModel(userBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomViewModel customViewModel, int i) {
        UserViewModel userViewModel = userViewModels.get(i);
        customViewModel.bind(userViewModel);
    }

    @Override
    public int getItemCount() {
        return userViewModels.size();
    }

    public class CustomViewModel extends RecyclerView.ViewHolder {
        private UserBinding userBinding;

        public CustomViewModel(UserBinding userBinding) {
            super(userBinding.getRoot());
            this.userBinding = userBinding;
        }

        private void bind(UserViewModel userViewModel) {
            this.userBinding.setUser(userViewModel);
            userBinding.executePendingBindings();
        }

        public UserBinding getUserBinding() {
            return userBinding;
        }
    }
}
