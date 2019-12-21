package net.example.com.cleansample.core.di

import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import net.example.com.cleansample.BuildConfig
import net.example.com.cleansample.core.networkError.RxErrorHandlingCallAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
class NetworkModule {
    @Singleton
    @Provides
    fun provideRetrofit(
        adapterFactory: RxErrorHandlingCallAdapterFactory,
        okHttpClient: OkHttpClient,
        gson: Gson
    ): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BuildConfig.SERVER_URL)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .addCallAdapterFactory(adapterFactory)
            .client(okHttpClient)
            .build()
    }

    @Singleton
    @Provides
    fun provideOkHttp(): OkHttpClient {
        val logging = HttpLoggingInterceptor()
        if (BuildConfig.DEBUG) logging.level = HttpLoggingInterceptor.Level.BODY
        else logging.level = HttpLoggingInterceptor.Level.NONE

        return OkHttpClient.Builder()
            .readTimeout(10, TimeUnit.SECONDS)
            .connectTimeout(10, TimeUnit.SECONDS)
            .writeTimeout(10, TimeUnit.SECONDS)
            .addInterceptor(logging)
            .build()
    }

    @Singleton
    @Provides
    fun provideRxErrorHandlingCallAdapterFactory(): RxErrorHandlingCallAdapterFactory =
        RxErrorHandlingCallAdapterFactory.create()
}
