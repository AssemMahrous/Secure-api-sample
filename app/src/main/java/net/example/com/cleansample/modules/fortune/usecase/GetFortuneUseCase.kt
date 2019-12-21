package net.example.com.cleansample.modules.fortune.usecase

import io.reactivex.Single
import net.example.com.cleansample.modules.fortune.Mapper.mapToFortune
import net.example.com.cleansample.modules.fortune.data.FortuneRepositoryInterface
import net.example.com.cleansample.utils.Event
import javax.inject.Inject

class GetFortuneUseCase @Inject constructor(val repository: FortuneRepositoryInterface) {

    fun getFortune(): Single<Event<String>> {
        return repository.getFortune().flatMap { Single.just(mapToFortune(it)) }
    }
}