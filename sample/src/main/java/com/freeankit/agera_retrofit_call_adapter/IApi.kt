package com.freeankit.agera_retrofit_call_adapter

import retrofit2.http.GET
import retrofit2.http.Path
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import com.freeankit.agera_retrofit_call_adapter.model.User
import com.google.android.agera.Function;
import com.google.android.agera.Functions;
import com.google.android.agera.Repository;
import com.google.android.agera.Result;
import com.google.android.agera.Supplier;
import com.google.android.agera.Updatable;
import okhttp3.OkHttpClient;
import retrofit2.HttpException;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


/**
 * @author Ankit Kumar (ankitdroiddeveloper@gmail.com) on 04/01/2018 (MM/DD/YYYY )
 */
interface IApi {
    @GET("users/AnkitDroidGit")
    fun android(): Supplier<Result<User>>

//    @GET("{page}")
//    fun android(@Path("page") page: Int): Supplier<Result<Response<User>>>
}