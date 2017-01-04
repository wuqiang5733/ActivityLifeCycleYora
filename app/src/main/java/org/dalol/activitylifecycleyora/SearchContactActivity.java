package org.dalol.activitylifecycleyora;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SearchContactActivity extends BaseActivity {
    public final static String RESULT_CONTACT_NAME = "RESULT_CONTACT_NAME";
    private Button button ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_contact);

        final EditText text = (EditText)findViewById(R.id.activity_search_contacts_searchText);
        button = (Button)findViewById(R.id.activity_search_contact_doSearch);

//        if (text.getText().toString().trim().length() == 0){
//            button.setEnabled(false);
//        } 只有动态的去检测才是有效的

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent data = new Intent();
                data.putExtra(RESULT_CONTACT_NAME,text.getText().toString());
                setResult(RESULT_OK,data);
                finish();
            }
        });

        findViewById(R.id.activity_search_contact_cancel).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setResult(RESULT_CANCELED);
                finish();
            }
        });

        findViewById(R.id.activity_search_contact_separate).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i(getLocalClassName(),"Search隔开");
            }
        });
        findViewById(R.id.activity_search_contacts_goBack).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SearchContactActivity.this,MainActivity.class));
                finish();
            }
        });
    }
    public interface trans{
        public void showResult(String str);
    }
}
