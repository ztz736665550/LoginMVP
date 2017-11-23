package com.ztz.loginmvp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.ztz.loginmvp.bean.LoginBean;
import com.ztz.loginmvp.presenter.LoginPresenter;
import com.ztz.loginmvp.view.LoginView;

public class MainActivity extends AppCompatActivity implements LoginView {
    private EditText phone;
    private EditText pwd;
    private Button log;
    private Button zc;
    private LoginPresenter loginPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        phone = findViewById(R.id.phone);
        pwd =  findViewById(R.id.pwd);
        log =  findViewById(R.id.log);
        zc =  findViewById(R.id.zc);
        loginPresenter = new LoginPresenter(this);
        // viewData(LoginBean bean);
        //登录按钮
        log.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loginPresenter.abc(phone.getText().toString(),pwd.getText().toString());
            }
        });
        //注册按钮
        zc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,ZhuCeActivity.class);
                startActivity(intent);
            }
        });
    }
    //登录成功返回的方法
    @Override
    public void viewData(final LoginBean bean) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(MainActivity.this,bean.getMsg(),Toast.LENGTH_SHORT).show();
                /*Intent intent = new Intent(MainActivity.this,xxxxxx.class);

                startActivity(intent);*/
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        loginPresenter.sa();
    }
}