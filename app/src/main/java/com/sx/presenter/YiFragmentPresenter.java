package com.sx.presenter;

import com.sx.model.CurrentWeather;
import com.sx.ui.fragment.YiFragment;

import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;

/***       Author  shy
 *         Time   2018/6/25 0025    10:45      */

public class YiFragmentPresenter extends BasePresenter {

    private YiFragment fragment;

    public YiFragmentPresenter(YiFragment fragment) {
        this.fragment = fragment;
    }

    public void weather() {
        Call<ResponseBody> weather = retrofit2Service.weather("2d60f2d7873567e3909e76b892e011db", "北京");
        weather.enqueue(new CallbackAdapter());
    }

    @Override
    protected void failed(String msg) {

    }

    @Override
    protected void parserData(String data) {
        List<CurrentWeather> weather = get7Weather(data);
        fragment.yWeather(weather);
        //缓存到数据库

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
            } else {
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

    public void simulationData() {
        //模拟json
        /**
         * date : 20180619
         * temperature : 20℃~33℃
         * weather : 晴
         * weather_id : {"fa":"00","fb":"00"}
         * week : 星期二
         * wind : 东北风3-5级
         */
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  //HH:24小时制  hh:12小时制
        String date = dateFormat.format(new Date());
        List<CurrentWeather> list = new ArrayList<>();
        for (int i = 0; i < 7; i++) {
            CurrentWeather currentWeather = new CurrentWeather();
            currentWeather.setDate(date);
            currentWeather.setTemperature(20 + i + "℃ ~" +  30 + i + "℃");
            currentWeather.setWeather(i / 2 == 0 ? "晴" : "阴");
            currentWeather.setWeek(i == 6 ? "星期日" : i == 5 ? "星期六" : i == 4 ? "星期五" : i == 3 ? "星期四" : i == 2 ? "星期三" : i == 1 ? "星期二" : "星期一");
            currentWeather.setWind("东北风" + (i + 1) + "级");
            list.add(currentWeather);
        }
        fragment.yWeather(list);

    }
}
