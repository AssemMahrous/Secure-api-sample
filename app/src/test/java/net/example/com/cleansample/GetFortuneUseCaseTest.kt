package net.example.com.cleansample

import io.reactivex.Single
import net.example.com.cleansample.modules.fortune.data.FortuneRepositoryInterface
import net.example.com.cleansample.modules.fortune.entities.FortuneResponse
import net.example.com.cleansample.modules.fortune.usecase.GetFortuneUseCase
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

class GetFortuneUseCaseTest {
    @Mock
    lateinit var fortuneRepository: FortuneRepositoryInterface

    lateinit var getFortuneUseCase: GetFortuneUseCase

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        getFortuneUseCase = GetFortuneUseCase(fortuneRepository)
    }

    @Test
    fun getCategories() {
        Mockito.`when`(fortuneRepository.getFortune())
            .thenReturn(Single.just(FortuneResponse(ArrayList<String>())))

        getFortuneUseCase.getFortune()
            .test()
            .assertNoErrors()
            .assertComplete()
    }
}