package com.ztz.loginmvp.presenter;

import com.google.gson.Gson;
import com.ztz.loginmvp.ZhuCeActivity;
import com.ztz.loginmvp.bean.RegBean;
import com.ztz.loginmvp.model.MyRegMedel;
import com.ztz.loginmvp.view.RegView;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;
/**
 * Created by on 2017/11/9.
 */
public class RegPresenter {


    RegView regView;
    private final MyRegMedel myRegMedel;

    public RegPresenter(ZhuCeActivity regView) {
        this.regView=regView;
        myRegMedel = new MyRegMedel();

    }

    public void abc(final String s, String s1) {
        myRegMedel.Idata(s, s1, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {

                String string = response.body().string();

                Gson gson = new Gson();
                RegBean regBean = gson.fromJson(string, RegBean.class);
                regView.showReg(regBean);
            }
        });

    }
}
