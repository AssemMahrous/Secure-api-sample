package net.example.com.cleansample.modules.fortune

import net.example.com.cleansample.modules.fortune.entities.FortuneResponse
import net.example.com.cleansample.utils.Event

object Mapper {
    fun mapToFortune(fortuneResponse: FortuneResponse): Event<String> {
        return Event(fortuneResponse.fortune.joinToString())
    }
}