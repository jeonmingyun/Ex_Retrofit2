package com.mx.retrofit2_ex.Api;

import com.mx.retrofit2_ex.model.LoginResultModel;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface JsonPlaceHolderApi {

    /* POST 방법 1 */
    @POST("sendData")
    Call<LoginResultModel> do_login(@Body LoginResultModel logimModel);

//    /* POST 방법 2 */
//    @FormUrlEncoded
//    @POST("sendData")
//    Call<LoginResultModel> do_login(@Field("name") String name, @Field("comment") String comment);
//
//    /* GET 방법 */
//    @GET("sendData")
//    Call<LoginResultModel> do_login(@Query("name") String name, @Query("comment") String comment);

}
