package net.example.com.cleansample.modules.fortune.data

import io.reactivex.Single
import net.example.com.cleansample.modules.fortune.entities.FortuneResponse

interface FortuneRepositoryInterface {
    fun getFortune(): Single<FortuneResponse>
}