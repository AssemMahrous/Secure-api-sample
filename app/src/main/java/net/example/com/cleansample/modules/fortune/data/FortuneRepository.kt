package net.example.com.cleansample.modules.fortune.data

import io.reactivex.Single
import net.example.com.cleansample.core.data.RemoteDataSource
import net.example.com.cleansample.core.platform.BaseRepository
import net.example.com.cleansample.modules.fortune.entities.FortuneResponse
import javax.inject.Inject

class FortuneRepository @Inject constructor(
    remoteDataSource: RemoteDataSource
) : BaseRepository(remoteDataSource),
    FortuneRepositoryInterface {
    override fun getFortune(): Single<FortuneResponse> {
        return remoteDataSource.apiRequests.getFortune()
    }
}