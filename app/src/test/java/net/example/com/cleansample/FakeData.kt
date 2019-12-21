package net.example.com.cleansample

import net.example.com.cleansample.modules.fortune.entities.FortuneResponse

object FakeData {
    fun getFortuneResponse(): FortuneResponse {
        return FortuneResponse(
            listOf(
                "Geriatric Relativity: The observation that time goes faster the older you get.",
                "Geriatric Relativity: The observation that time goes faster the older you get."
            )
        )
    }
}