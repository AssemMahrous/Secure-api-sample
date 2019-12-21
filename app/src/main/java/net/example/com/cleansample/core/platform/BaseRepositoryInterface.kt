package net.example.com.cleansample.core.platform

import net.example.com.cleansample.core.data.RemoteDataSource

interface BaseRepositoryInterface {
    val remoteDataSource: RemoteDataSource
}