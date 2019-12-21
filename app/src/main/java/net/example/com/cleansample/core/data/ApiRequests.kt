package net.example.com.cleansample.core.data

import io.reactivex.Single
import net.example.com.cleansample.modules.FortuneResponse
import retrofit2.http.GET

interface ApiRequests {
    @GET("fortune")
    fun getFortune(): Single<FortuneResponse>
}