package com.sx.presenter;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

import okhttp3.Cookie;
import okhttp3.CookieJar;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/***       Author  shy
 *         Time   2018/6/25 0025    9:48      */

public abstract class BasePresenter {

    private static final String BASEURL = "http://v.juhe.cn/";

    protected static Retrofit2Service retrofit2Service;

    public BasePresenter() {
        if (retrofit2Service == null) {
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(BASEURL)
                    .client(client)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            retrofit2Service = retrofit.create(Retrofit2Service.class);
        }
    }
    private static OkHttpClient client = new OkHttpClient.Builder()
            .cookieJar(new myCoo())
            .build();


    public class CallbackAdapter implements Callback<ResponseBody> {
        @Override
        public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
            // 处理回复
            if (response != null && response.isSuccessful()) {
                try {
                    String str = response.body().string();
//                    JSONObject jsonObject = new JSONObject(str);
//                    String code = jsonObject.getString("code");
//                    if ("1".equals(code)) {
//                        // 服务器端处理成功，并返回目标数据
//                        parserData(str);
//                    } else if ("-3".equals(code)) {
//                        //退出到登陆界面
//                        BaseApplication.context().startActivity(new Intent(BaseApplication
//                                .context(), LoginActivity.class));
//                    } else {
//                        // 服务器端处理成功，返回错误提示，该信息需要展示给用户
//                        // 依据code值获取到失败的数据
//                        String message = jsonObject.getString("message");
//                        String msg = ErrorInfo.INFO.get(message);
//                        failed(msg);
//                    }
                    parserData(str);

                } catch (IOException e) {
                    e.printStackTrace();
//                } catch (JSONException e) {
//                    e.printStackTrace();
                }
            } else {
                // 联网过程中的异常
            }
        }

        @Override
        public void onFailure(Call<ResponseBody> call, Throwable t) {
            // 联网过程中的异常
        }
    }

    /**
     * 错误处理
     * @param msg
     */

    protected abstract void failed(String msg);

    /**
     * 解析服务器回复数据
     * @param data
     */
    
    protected abstract void parserData(String data);


    static class myCoo implements CookieJar{

        private List<Cookie> cookie = null;

        @Override
        public void saveFromResponse(HttpUrl url, List<Cookie> cookies) {
            cookie = cookies;
        }

        @Override
        public List<Cookie> loadForRequest(HttpUrl url) {
            if (cookie == null){
                return Collections.emptyList();
            }
            return cookie;
        }
    }
}
