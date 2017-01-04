/**
 * Created by WuQiang on 2017/1/3.
 */
package org.dalol.activitylifecycleyora;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends BaseActivity implements View.OnClickListener {
    private static final int REQUEST_SELECT_CONTACT = 1;

    private TextView textView;
    private View button;
    private EditText textBox;
    ArrayList<Person>  personArrayList = new ArrayList<>();
    private View seperateButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
//        Log.d("测试MainActivity开始","测试");

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        Person one = new Person("wu","qiang");
        Person two = new Person("xu","xiaoxiao");
        personArrayList.add(one);
        personArrayList.add(two);

        textView = (TextView)findViewById(R.id.activity_main_text);
        button = findViewById(R.id.activity_main_button);
        seperateButton = findViewById(R.id.activity_main_separate);
        textBox = (EditText)findViewById(R.id.activity_main_editText);

        button.setOnClickListener(this);
        seperateButton.setOnClickListener(this);
//        Log.d("测试MainActivity开始","测试");
        findViewById(R.id.activity_main_logout).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BaseActivity.IsLoggedIn = false;
                Intent intent = new Intent(MainActivity.this,LoginActivity.class);
                // 清空 BackStack ，要不，如果是在任意一个界面退出的，一按返回键，会不停的出现登陆界面
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
                finish();
            }
        });
    }


    @Override
    public void onClick(View view) {
        if (view == button){
            Intent intent = new Intent(this,SelectContactActivity.class);
            intent.putParcelableArrayListExtra(SelectContactActivity.EXTRA_TITLE,personArrayList);
            startActivityForResult(intent, 11);
        }
        if (view == seperateButton){
            Log.i("MainActivity","主隔开");
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 11){
            if (resultCode == RESULT_OK){
                Log.i("RESULT_OK", Integer.toString(RESULT_OK));
                String contactName = data.getStringExtra(SelectContactActivity.RESULT_CONTACT_NAME);
                textView.setText("You selected : " + contactName);
            }
        }


        else {
            textView.setText("好像出错了");
        }
            super.onActivityResult(requestCode,resultCode,data);

    }
}
