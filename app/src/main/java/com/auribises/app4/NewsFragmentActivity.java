package com.auribises.app4;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;

public class NewsFragmentActivity extends AppCompatActivity {
    UpperFragment upperFragment;
    LowerFragment lowerFragment;

    void initViews(){
        //Object construction statements
        // For activity android males object itself but object of fragment we have to make
        upperFragment=new UpperFragment();
        lowerFragment=new LowerFragment();
        upperFragment.setMyListner(lowerFragment);

        FragmentManager manager=getSupportFragmentManager();
        manager.beginTransaction().add(R.id.upperFrame,upperFragment).commit();
        manager.beginTransaction().add(R.id.lowerFrame,lowerFragment).commit();
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_fragment);
        initViews();
    }
}
