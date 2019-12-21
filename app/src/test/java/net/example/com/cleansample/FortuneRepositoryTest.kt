package net.example.com.cleansample

import io.reactivex.Single
import net.example.com.cleansample.core.data.ApiRequests
import net.example.com.cleansample.core.data.RemoteDataSource
import net.example.com.cleansample.modules.fortune.data.FortuneRepository
import net.example.com.cleansample.modules.fortune.entities.FortuneResponse
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

class FortuneRepositoryTest {
    @Mock
    private lateinit var remoteDataSource: RemoteDataSource
    private lateinit var fortuneRepository: FortuneRepository

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        fortuneRepository = FortuneRepository(remoteDataSource)
    }

    @Test
    fun `check fortune fetched`() {
        Mockito.`when`(remoteDataSource.apiRequests)
            .thenReturn(Mockito.mock(ApiRequests::class.java))

        Mockito.`when`(remoteDataSource.apiRequests.getFortune())
            .thenReturn(Single.just(FortuneResponse(ArrayList<String>())))

        fortuneRepository
            .getFortune()
            .test()
            .assertNoErrors()
    }
}