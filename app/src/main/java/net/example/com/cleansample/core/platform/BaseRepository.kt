package net.example.com.cleansample.core.platform

import net.example.com.cleansample.core.data.RemoteDataSource
import javax.inject.Inject

open class BaseRepository @Inject constructor(
    override val remoteDataSource: RemoteDataSource
) : BaseRepositoryInterface