package com.ztz.loginmvp.model;

import okhttp3.Callback;

/**
 * Created by MK on 2017/11/9.
 */
public interface RegModel {
    public void Idata(String phone, String pwd, Callback callback);
}
