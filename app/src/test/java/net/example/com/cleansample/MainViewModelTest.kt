package net.example.com.cleansample

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import io.reactivex.Single
import net.example.com.cleansample.FakeData.getFortuneResponse
import net.example.com.cleansample.core.data.ApiRequests
import net.example.com.cleansample.core.data.RemoteDataSource
import net.example.com.cleansample.feature.MainViewModel
import net.example.com.cleansample.modules.fortune.data.FortuneRepository
import net.example.com.cleansample.modules.fortune.data.FortuneRepositoryInterface
import net.example.com.cleansample.modules.fortune.usecase.GetFortuneUseCase
import net.example.com.cleansample.utils.IConnectivityUtils
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

class MainViewModelTest {
    @get:Rule
    var instantExecutorRule = InstantTaskExecutorRule()

    // Subject under test
    private lateinit var homeViewModel: MainViewModel

    private lateinit var getFortuneUseCase: GetFortuneUseCase
    @Mock
    private lateinit var connectivityUtils: IConnectivityUtils

    @Mock
    private lateinit var remoteDataSource: RemoteDataSource
    private lateinit var fortuneRepository: FortuneRepositoryInterface


    @Before
    fun setupViewModel() {
        MockitoAnnotations.initMocks(this)


        fortuneRepository = FortuneRepository(remoteDataSource)

        getFortuneUseCase = GetFortuneUseCase(fortuneRepository)

        homeViewModel = MainViewModel(getFortuneUseCase)
        homeViewModel.connectivityUtils = connectivityUtils

        Mockito.`when`(connectivityUtils.isNetworkConnected).thenReturn(true)

        Mockito.`when`(remoteDataSource.apiRequests)
            .thenReturn(Mockito.mock(ApiRequests::class.java))

        Mockito.`when`(remoteDataSource.apiRequests.getFortune())
            .thenReturn(Single.just(getFortuneResponse()))
    }

    @Test
    fun `fetch fortune test`() {
        homeViewModel.getFortune()
        val value = homeViewModel.fortune.getOrAwaitValue()
        val data = value.getContentIfNotHandled()
        Assert.assertNotNull(data)
    }
}