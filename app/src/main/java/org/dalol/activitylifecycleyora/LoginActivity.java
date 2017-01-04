package org.dalol.activitylifecycleyora;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class LoginActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        findViewById(R.id.activity_login_loginButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                BaseActivity.IsLoggedIn = true;

                Intent intent = new Intent(LoginActivity.this,MainActivity.class);
                startActivity(intent);
                finish(); // 不把这个Activity销毁的话，它会在BackStack当中，
                // 这样在主界面上点击返回按钮，就又回到登陆界面上了。
            }
        });
    }
}
