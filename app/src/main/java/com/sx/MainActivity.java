package com.sx;

import android.graphics.Canvas;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.sx.retorfit2.HttpRetrofit;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private TextView tv;
    private RecyclerView recyclerView;
    private ImageView ivBj;

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
        DividerItemDecoration decoration = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        decoration.setDrawable(ContextCompat.getDrawable(this,R.drawable.rv_decoration));
        recyclerView.addItemDecoration(decoration);
        ivBj = findViewById(R.id.iv_bj);
    }

    private void initData() {
        final Map<String, Object> map = new HashMap<>();
        HttpRetrofit.getHttp().weather("2d60f2d7873567e3909e76b892e011db", "北京").enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    String str = response.body().string();
                    RvAdapter rvAdapter = new RvAdapter(MainActivity.this,get7Weather(str));
                    recyclerView.setAdapter(rvAdapter);
                    Picasso.with(MainActivity.this).load("http://pp.myapp.com/ma_pic2/0/shot_52425468_1_1528770041/550").into(ivBj);
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

    private List<CurrentWeather> get7Weather(String str) {
        List<CurrentWeather> list = new ArrayList<>();
        for (int i = 0; i < 7; i++) {
            list.add(new CurrentWeather());
        }
        try {
            JSONObject obj = new JSONObject(str);
            String error_code = obj.getString("error_code");
            if ("0".equals(error_code)) {
                JSONObject resultObj = obj.getJSONObject("result");
                JSONObject futureObj = resultObj.getJSONObject("future");
                for (int i = 0; i < 7; i++) {
                    JSONObject jsonObject = futureObj.getJSONObject("day_" + getDateMonth().get(i));
                    String date = jsonObject.getString("date");
                    String temperature = jsonObject.getString("temperature");
                    String weather = jsonObject.getString("weather");
                    String week = jsonObject.getString("week");
                    String wind = jsonObject.getString("wind");
                    CurrentWeather currentWeather = list.get(i);
                    currentWeather.setDate(date);
                    currentWeather.setTemperature(temperature);
                    currentWeather.setWeather(weather);
                    currentWeather.setWeek(week);
                    currentWeather.setWind(wind);
                }
            }else {
                //TODO  请求失败
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return list;
    }

    public static List<String> getDateMonth() {
        List<String> list = new ArrayList<>();
        long nowDate = System.currentTimeMillis();
        for (int i = 0; i < 7; i++) {
            String s = beforeOrAfterNumberDay(new Date(nowDate), i);
            list.add(s);
        }
        return list;
    }

    public static String beforeOrAfterNumberDay(Date date, int day) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.DAY_OF_YEAR, day);
        return new SimpleDateFormat("yyyyMMdd").format(c.getTime());
    }

}
