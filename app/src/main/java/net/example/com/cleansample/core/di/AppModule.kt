package net.example.com.cleansample.core.di

import android.content.Context
import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import net.example.com.cleansample.core.data.LocalScheduler
import net.example.com.cleansample.core.data.LocalSchedulerInterface
import net.example.com.cleansample.core.data.RemoteDataSource
import net.example.com.cleansample.core.data.RemoteDataSourceImpl
import net.example.com.cleansample.utils.ConnectivityUtils
import net.example.com.cleansample.utils.IConnectivityUtils
import retrofit2.Retrofit
import javax.inject.Singleton

@Module(includes = [NetworkModule::class, ViewModelModule::class, RepositoriesModule::class])
class AppModule {

    @Singleton
    @Provides
    fun provideGson(): Gson {
        return Gson()
            .newBuilder()
            // add any type converter or date format here
            .create()
    }

    @Singleton
    @Provides
    fun provideRemoteDataSource(retrofit: Retrofit): RemoteDataSource =
        RemoteDataSourceImpl(retrofit)


    @Singleton
    @Provides
    fun provideConnectivityUtils(context: Context): IConnectivityUtils = ConnectivityUtils(context)

    @Singleton
    @Provides
    fun provideLocalScheduler(): LocalSchedulerInterface =
        LocalScheduler()
}