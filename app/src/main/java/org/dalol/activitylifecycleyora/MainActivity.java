/**
 * Created by WuQiang on 2017/1/3.
 */
package org.dalol.activitylifecycleyora;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends BaseActivity {
    private static final String TAG = "MainActivity";
    private static final String BUNDLE_COUNTER = "BUNDLE_COUNTER";
    private int counter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        final TextView textView = (TextView)findViewById(R.id.activity_main_text);
        View button = findViewById(R.id.activity_main_button);

        if(savedInstanceState != null){
            counter = savedInstanceState.getInt(BUNDLE_COUNTER);
            textView.setText(Integer.toString(counter));
        }



        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                counter++;
                textView.setText(Integer.toString(counter));
                Log.i(TAG,"你点击按钮了");
            }
        });

    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(BUNDLE_COUNTER,counter);
    }


}
