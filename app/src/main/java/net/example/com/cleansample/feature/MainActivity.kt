package net.example.com.cleansample.feature

import android.os.Bundle
import net.example.com.cleansample.R
import net.example.com.cleansample.core.platform.BaseActivity
import javax.inject.Inject

class MainActivity : BaseActivity<MainViewModel>() {

    @Inject
    lateinit var mainViewModel: MainViewModel

    override fun getBaseViewModel(): MainViewModel = mainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}
