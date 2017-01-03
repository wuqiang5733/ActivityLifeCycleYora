package org.dalol.activitylifecycleyora;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class SelectContactActivity extends BaseActivity implements View.OnClickListener {

    Intent data = new Intent();

    public final static String EXTRA_TITLE = "EXTRA_TITLE";
    public final static String RESULT_CONTACT_NAME = "RESULT_CONTACT_NAME";

    public static final int REQUEST_SEARCH_CONTACTS = 1;

    private TextView title;
    private ArrayList<Person> secondArrayList;
    private Button button1;
    private Button button2;
    private Button button3;
    private Button button4;
    private Button button5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_contact);

        title = (TextView) findViewById(R.id.activity_select_contact_title);
        secondArrayList = getIntent().getParcelableArrayListExtra(SelectContactActivity.EXTRA_TITLE);
        title.setText(secondArrayList.get(0).getFirstName());

        button1 = (Button) findViewById(R.id.activity_select_contactButton1);
        button2 = (Button) findViewById(R.id.activity_select_contactButton2);
        button3 = (Button) findViewById(R.id.activity_select_contactButton3);
        button4 = (Button) findViewById(R.id.activity_select_contactButton4);
        button5 = (Button) findViewById(R.id.activity_select_contact_search);


        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        button4.setOnClickListener(this);
        button5.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {

        if (view == button1) {
            data.putExtra(RESULT_CONTACT_NAME, "Contact_1");
            setResult(RESULT_OK, data);
            finish();
        }
        if (view == button2) {
            data.putExtra(RESULT_CONTACT_NAME, "Contact_2");
            setResult(RESULT_OK, data);
            finish();
        }
        if (view == button3) {
            data.putExtra(RESULT_CONTACT_NAME, "Contact_3");
            setResult(RESULT_OK, data);
            finish();
        }
        if (view == button4) {
            Log.i("SelectContactActivity", "Select隔开");
        }
        if (view == button5) {
            // 启动搜索
            Intent intent = new Intent(SelectContactActivity.this, SearchContactActivity.class);
            startActivityForResult(intent,REQUEST_SEARCH_CONTACTS);
//            startActivityForResult(intent, REQUEST_SEARCH_CONTACTS);
//            finish(); // 没有这一句，关闭Search之后，还会返回到这是

        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_SEARCH_CONTACTS) {
            if (resultCode == RESULT_OK) {
                String contactName = data.getStringExtra(SearchContactActivity.RESULT_CONTACT_NAME);
                data.putExtra(RESULT_CONTACT_NAME, contactName);
                setResult(RESULT_OK, data);
                finish();
            }
            super.onActivityResult(requestCode, resultCode, data);
        }
    }

}
