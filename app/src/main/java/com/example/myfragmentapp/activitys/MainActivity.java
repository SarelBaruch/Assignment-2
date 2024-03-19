package com.example.myfragmentapp.activitys;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.myfragmentapp.R;
import com.example.myfragmentapp.User;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    public static ArrayList<User> UsersList = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}