package com.sx;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.google.gson.Gson;
import com.sx.retorfit2.HttpRetrofit;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private TextView tv;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        initData();
        initRV();
    }

    private void initView() {
        tv = findViewById(R.id.tv_content);
        recyclerView = findViewById(R.id.main_rv);
    }

    private void initData() {
        HttpRetrofit.getHttp().weather("2d60f2d7873567e3909e76b892e011db","北京").enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    String str = response.body().string();
                    Gson gson = new Gson();
                    TqBean tqBean = gson.fromJson(str, TqBean.class);
                    RvAdapter rvAdapter = new RvAdapter(MainActivity.this, tqBean);
                    recyclerView.setAdapter(rvAdapter);

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {

            }
        });
    }

    private void initRV() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(MainActivity.this);
        recyclerView.setLayoutManager(layoutManager);

    }

}
