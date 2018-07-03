package com.reizx.antest;

import android.support.test.runner.AndroidJUnit4;
import android.util.Log;

import com.zhy.http.okhttp.OkHttpUtils;

import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.IOException;

import okhttp3.Response;

/**
 * okhttp 的测试
 */
@RunWith(AndroidJUnit4.class)
public class OkHttpUtilsTest {

    @Test
    public void useAppContext() {
        try {
            Response response = OkHttpUtils
                    .get()
                    .url("https://www.baidu.com/")
                    .build()
                    .execute();
            Log.d("tag", response.body().string());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
