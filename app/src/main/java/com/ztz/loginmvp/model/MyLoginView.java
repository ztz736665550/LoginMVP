package com.ztz.loginmvp.model;

import java.util.concurrent.TimeUnit;

import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;

/**
 * Created by MK on 2017/11/9.
 */
public class MyLoginView implements LoginModle{
    @Override
    public void initdata(String mobile, String password, Callback callback) {

        OkHttpClient client = new OkHttpClient.Builder()
                .readTimeout(10, TimeUnit.SECONDS)
                .writeTimeout(10,TimeUnit.SECONDS)
                .connectTimeout(10,TimeUnit.SECONDS)
                .build();
        RequestBody requestBody = new FormBody.Builder()
                .add("mobile",mobile)
                .add("password",password)
                .build();
        Request request = new Request.Builder().url("http://120.27.23.105/user/login")
                .post(requestBody)
                .build();

        client.newCall(request).enqueue(callback);
    }
}
