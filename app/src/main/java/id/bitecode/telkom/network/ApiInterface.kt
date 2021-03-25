package com.smartcybermedia.apps.panicbutton.network

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import id.bitecode.telkom.BuildConfig
import id.bitecode.telkom.constant.BASE_URL
import id.bitecode.telkom.model.story.Story
import io.reactivex.Observable
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.*
import java.util.concurrent.TimeUnit

interface ApiInterface {

    @GET("newstories.json")
    fun getNewsList() : Observable<List<String>>

    @GET("item/{id}.json?")
    fun getStory(@Path("id") id:String) : Observable<Story>

    companion object Factory {
        fun create(): ApiInterface {
            val client = OkHttpClient().newBuilder()
                .addInterceptor(HttpLoggingInterceptor().apply {
                    level = if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY else HttpLoggingInterceptor.Level.NONE
                })
                .readTimeout(30, TimeUnit.SECONDS)
                .writeTimeout(30, TimeUnit.SECONDS)
                .build()

            val retrofit = retrofit2.Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .baseUrl(BASE_URL)
                .build()

            return retrofit.create(ApiInterface::class.java)
        }
    }
}