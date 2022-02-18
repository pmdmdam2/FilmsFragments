package com.example.fragments.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import com.example.fragments.R;
import com.example.fragments.fragments.FirstFragment;
import com.example.fragments.fragments.SecondFragment;
import com.google.android.material.button.MaterialButtonToggleGroup;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MaterialButtonToggleGroup tb = findViewById(R.id.toggleButton);

        tb.addOnButtonCheckedListener(new MaterialButtonToggleGroup.OnButtonCheckedListener() {
            @Override
            public void onButtonChecked(MaterialButtonToggleGroup group, int checkedId, boolean isChecked) {
                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                switch(checkedId){
                    case R.id.btMuerteNilo:
                        SecondFragment secondFragment = new SecondFragment();
                        fragmentTransaction.add(R.id.fragmentContainerView,secondFragment);
                        fragmentTransaction.commit();
                        break;
                    case R.id.btUncharted:
                        //opción por defecto
                        FirstFragment firstFragment = new FirstFragment();
                        fragmentTransaction.replace(R.id.fragmentContainerView,firstFragment);
                        fragmentTransaction.commit();
                    break;
                }
            }
        });
    }
}