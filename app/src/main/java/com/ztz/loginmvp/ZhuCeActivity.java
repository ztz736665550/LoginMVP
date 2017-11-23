package com.ztz.loginmvp;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.ztz.loginmvp.bean.RegBean;
import com.ztz.loginmvp.presenter.RegPresenter;
import com.ztz.loginmvp.view.RegView;

public class ZhuCeActivity extends AppCompatActivity implements RegView {

    private RegPresenter regPresenter;
    private EditText phone;
    private EditText pwd;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zhu_ce);

        phone = (EditText) findViewById(R.id.phone_id);
        pwd = (EditText) findViewById(R.id.pwd_id);
        button = (Button) findViewById(R.id.btn_id);
        regPresenter = new RegPresenter(this);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                regPresenter.abc(phone.getText().toString(),pwd.getText().toString());
            }
        });
    }
    @Override
    public void showReg(final RegBean regBean) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(ZhuCeActivity.this,regBean.getMsg(),Toast.LENGTH_SHORT).show();
            }
        });
    }
}
