package com.limayeneha.waglabsproject.ui;

import android.app.Activity;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.widget.Toast;

import com.limayeneha.waglabsproject.R;
import com.limayeneha.waglabsproject.databinding.ActivityMainBinding;
import com.limayeneha.waglabsproject.model.User;
import com.limayeneha.waglabsproject.utils.StackOverflowApi;
import com.limayeneha.waglabsproject.utils.StackOverflowApiInterface;
import com.limayeneha.waglabsproject.viewmodel.MainActivityView;
import com.limayeneha.waglabsproject.viewmodel.MainActivityViewModel;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity implements MainActivityView {

    MainActivityViewModel viewModel;
    private UserAdapter userAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        StackOverflowApiInterface apiService =
                StackOverflowApi.getClient(this).create(StackOverflowApiInterface.class);

        viewModel = new MainActivityViewModel(apiService);
        viewModel.attach(MainActivity.this);

        ActivityMainBinding activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        userAdapter = new UserAdapter(this, new ArrayList<>());

        activityMainBinding.userRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        activityMainBinding.userRecyclerView.setAdapter(userAdapter);
    }

    @Override
    protected void onStart() {
        super.onStart();
        viewModel.listUsers("stackoverflow");
    }

    @Override
    protected void onStop() {
        super.onStop();
        viewModel.clearSubscriptions();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        viewModel.detach();
    }

    @Override
    public void load(List<User> items) {
        userAdapter.setUserItems(items);
    }

    @Override
    public void error(Throwable e) {
        Toast.makeText(this, e.getMessage(), Toast.LENGTH_LONG).show();
    }
}
