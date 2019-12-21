package net.example.com.cleansample.feature

import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import net.example.com.cleansample.R
import net.example.com.cleansample.core.platform.BaseActivity
import net.example.com.cleansample.utils.EventObserver
import javax.inject.Inject

class MainActivity : BaseActivity<MainViewModel>() {
    @Inject
    lateinit var mainViewModel: MainViewModel

    override fun getBaseViewModel(): MainViewModel = mainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mainViewModel.fortune.observe(this, EventObserver {
            tv_fortune_quote.text = it
        })
        no_internet_connection.setOnClickListener {
            it.visibility = View.GONE
            getFortune()
        }
        getFortune()
    }

    private fun getFortune() {
        mainViewModel.getFortune()
    }
}
