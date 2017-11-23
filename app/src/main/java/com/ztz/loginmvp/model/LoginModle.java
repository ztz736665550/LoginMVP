package com.ztz.loginmvp.model;

import okhttp3.Callback;

/**
 * Created by MK on 2017/11/7.
 */
public interface LoginModle {
    public void initdata(String mobile, String password, Callback callback);
}
