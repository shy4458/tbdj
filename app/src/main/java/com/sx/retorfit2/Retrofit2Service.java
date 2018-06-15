package com.sx.retorfit2;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;

/***       Author  shy
 *         Time   2018/6/1 0001    10:49      */

public interface Retrofit2Service {

    @GET("weather/index")
    Call<ResponseBody> weather(@Query("key") String key,@Query("cityname") String cityname);



    /**
     1、请求方法注解
     @GET	get请求
     @POST	post请求
     @PUT	put请求
     @DELETE	delete请求
     @PATCH	patch请求，该请求是对put请求的补充，用于更新局部资源
     @HEAD	head请求
     @OPTIONS	option请求
     @HTTP	通用注解,可以替换以上所有的注解，其拥有三个属性：method，path，hasBody

     2、请求头注解
     @Headers	用于添加固定请求头，可以同时添加多个。通过该注解添加的请求头不会相互覆盖，而是共同存在
     @Header	作为方法的参数传入，用于添加不固定值的Header，该注解会更新已有的请求头

     3、请求参数注解
     @Body	多用于post请求发送非表单数据,比如想要以post方式传递json格式数据
     @Filed	多用于post请求中表单字段,Filed和FieldMap需要FormUrlEncoded结合使用
     @FiledMap	和@Filed作用一致，用于不确定表单参数
     @Part	用于表单字段,Part和PartMap与Multipart注解结合使用,适合文件上传的情况
     @PartMap	用于表单字段,默认接受的类型是 Map，可用于实现多文件上传
     @Path	用于url中的占位符
     @Query	用于Get中指定参数
     @QueryMap	和Query使用类似
     @Url	指定请求路径

     4、请求和响应格式注解
     @FormUrlEncoded	表示请求发送编码表单数据，每个键值对需要使用@Field注解
     @Multipart	表示请求发送multipart数据，需要配合使用@Part
     @Streaming	表示响应用字节流的形式返回,如果没使用该注解，默认会把数据全部载入到内存中，该注解在在下载大文件的特别有用
     */

}
