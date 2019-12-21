package net.example.com.cleansample.feature

import androidx.lifecycle.MutableLiveData
import io.reactivex.functions.Consumer
import net.example.com.cleansample.core.platform.BaseViewModel
import net.example.com.cleansample.modules.fortune.usecase.GetFortuneUseCase
import net.example.com.cleansample.utils.Event
import javax.inject.Inject

class MainViewModel @Inject constructor(
    private val getFortuneUseCase: GetFortuneUseCase
) : BaseViewModel() {
    val fortune = MutableLiveData<Event<String>>()

    fun getFortune() {
        singleNetworkCall(getFortuneUseCase.getFortune(), Consumer {
            fortune.postValue(it)
        }, Consumer {
            fortune.postValue(
                Event(
                    "a penny saved is a penny earned', \n" +
                            "for example"
                )
            )
        }, showLoading = true)
    }
}
