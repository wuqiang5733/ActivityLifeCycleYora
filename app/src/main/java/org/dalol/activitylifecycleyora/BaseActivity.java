package org.dalol.activitylifecycleyora;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

/**
 * Created by WuQiang on 2017/1/3.
 */

public abstract class BaseActivity extends AppCompatActivity {
    private String tag;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        tag = getClass().getSimpleName();
//        tag = getClass().getName();
        Log.e(tag,"-- onCreate");
    }
    @Override
    protected void onStart() {
        super.onStart();
        Log.e(tag,"-- onStart");

    }
    @Override
    protected void onStop() {
        super.onStop();
        Log.e(tag,"-- onStop");

    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e(tag,"-- onDestroy");

    }
    @Override
    protected void onPause() {
        super.onPause();
        Log.e(tag,"-- onPause");

    }
    @Override
    protected void onResume() {
        super.onResume();
        Log.e(tag,"-- onResume");

    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.e(tag,"-- onRestart");

    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.e(tag,"-- onSaveInstanceState");

    }

    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Log.e(tag,"-- onRestoreInstanceState");

    }
}
