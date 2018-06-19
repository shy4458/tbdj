package com.sx;

/***       Author  shy 
 *         Time   2018/6/19 0019    15:07      */

public class CurrentWeather {


    /**
     * date : 20180619
     * temperature : 20℃~33℃
     * weather : 晴
     * weather_id : {"fa":"00","fb":"00"}
     * week : 星期二
     * wind : 东北风3-5级
     */

    private String date;
    private String temperature;
    private String weather;
    private WeatherIdBean weather_id;
    private String week;
    private String wind;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTemperature() {
        return temperature;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }

    public String getWeather() {
        return weather;
    }

    public void setWeather(String weather) {
        this.weather = weather;
    }

    public WeatherIdBean getWeather_id() {
        return weather_id;
    }

    public void setWeather_id(WeatherIdBean weather_id) {
        this.weather_id = weather_id;
    }

    public String getWeek() {
        return week;
    }

    public void setWeek(String week) {
        this.week = week;
    }

    public String getWind() {
        return wind;
    }

    public void setWind(String wind) {
        this.wind = wind;
    }

    public static class WeatherIdBean {
        /**
         * fa : 00
         * fb : 00
         */

        private String fa;
        private String fb;

        public String getFa() {
            return fa;
        }

        public void setFa(String fa) {
            this.fa = fa;
        }

        public String getFb() {
            return fb;
        }

        public void setFb(String fb) {
            this.fb = fb;
        }
    }
}
