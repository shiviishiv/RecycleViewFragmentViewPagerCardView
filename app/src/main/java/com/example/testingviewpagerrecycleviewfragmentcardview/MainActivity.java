package com.example.testingviewpagerrecycleviewfragmentcardview;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;

import DataUtils.FetchAllData;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.send).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(FetchAllData.getAllPermission(MainActivity.this)){
                    Intent intent = new Intent(MainActivity.this,SecondActivity.class);
                    startActivity(intent);
                }
                else{

                }
            }
        });
        findViewById(R.id.receive).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(FetchAllData.getAllPermission((MainActivity) getApplicationContext())){

                }else{

                }
            }
        });
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if(requestCode == 123 && grantResults.length >0){
            for (int i = 0; i < permissions.length; i++) {
                if(permissions[i]== Manifest.permission.READ_EXTERNAL_STORAGE){
                    if(grantResults[i]== PackageManager.PERMISSION_GRANTED){
                        return;
                    }
                }
            }
        }
    }
}