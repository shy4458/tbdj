package com.sx.retorfit2;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;

/***       Author  shy
 *         Time   2018/6/15 0015    10:12      */

public class HttpRetrofit {

    private static final String BASEURL = "http://v.juhe.cn/";

    private static OkHttpClient client = new OkHttpClient.Builder()
            .addNetworkInterceptor(new Interceptor() {
                @Override
                public Response intercept(Chain chain) throws IOException {
                    Request request = chain.request()
                            .newBuilder()
                            .addHeader("name", "key")
                            .build();
                    return chain.proceed(request);
                }
            }).build();

    private static Retrofit retrofir = new Retrofit.Builder()
            .baseUrl(BASEURL)
            .client(client)
            .build();

    public static Retrofit2Service getHttp() {
        Retrofit2Service httpSercice = retrofir.create(Retrofit2Service.class);
        return httpSercice;
    }

}
