package net.example.com.cleansample.core.platform


import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.ProgressBar
import androidx.annotation.CallSuper
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.HasSupportFragmentInjector
import net.example.com.cleansample.R
import net.example.com.cleansample.utils.ErrorType
import net.example.com.cleansample.utils.EventObserver
import net.example.com.cleansample.utils.Status
import javax.inject.Inject

abstract class BaseActivity<MBaseViewModel : BaseViewModel>
    : AppCompatActivity(), HasSupportFragmentInjector {

    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Fragment>

    private lateinit var viewModel: MBaseViewModel
    private val progressBar: View?
        get() = (findViewById(R.id.progress_bar_loading)
            ?: findViewById(R.id.progress_bar_loading))
    private val noInternetConnection: View?
        get() = (findViewById(R.id.no_internet_connection)
            ?: findViewById(R.id.no_internet_connection))

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = getBaseViewModel()
        viewModel.status.observe(this, EventObserver {
            when (it) {
                is Status.Error -> {
                    hideLoading()
                    if (it.errorType == ErrorType.NoInternetConnection)
                        showNoInternetConnection()
                }
                is Status.Loading -> {
                    if (it.show) showLoading()
                    else hideLoading()
                }
            }
        })
    }

    open fun hideLoading() {
        val progressBar = findViewById<ProgressBar>(R.id.progress_circular)
        if (progressBar != null)
            progressBar.visibility = View.GONE
    }

    open fun showLoading() {
        val progressBar = findViewById<ProgressBar>(R.id.progress_circular)
        if (progressBar != null)
            progressBar.visibility = View.VISIBLE
    }

    abstract fun getBaseViewModel(): MBaseViewModel

    override fun supportFragmentInjector() = dispatchingAndroidInjector

    @CallSuper
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.home -> onBackPressed()
        }
        return super.onOptionsItemSelected(item)
    }

    open fun showNoInternetConnection() {
        // pass
        noInternetConnection?.visibility = View.VISIBLE
    }

}
