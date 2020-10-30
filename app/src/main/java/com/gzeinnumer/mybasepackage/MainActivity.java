package com.gzeinnumer.mybasepackage;

import android.os.Bundle;

import com.gzeinnumer.mybasepackage.base.BaseActivity;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        onShowLoading();
    }
}