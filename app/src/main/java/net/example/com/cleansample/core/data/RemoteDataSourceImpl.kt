package net.example.com.cleansample.core.data

import retrofit2.Retrofit

class RemoteDataSourceImpl(retrofit: Retrofit) :
    RemoteDataSource {
    override val apiRequests: ApiRequests = retrofit.create(ApiRequests::class.java)
}
