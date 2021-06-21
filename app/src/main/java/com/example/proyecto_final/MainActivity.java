package com.example.proyecto_final;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {


    public static MyDataBase myDataBase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myDataBase = Room.databaseBuilder(getApplicationContext(),MyDataBase.class,"userdb").allowMainThreadQueries().build();
    }
}