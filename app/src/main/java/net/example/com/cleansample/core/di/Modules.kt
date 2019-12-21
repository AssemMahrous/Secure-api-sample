package net.example.com.cleansample.core.di

import dagger.Module
import dagger.android.ContributesAndroidInjector
import net.example.com.cleansample.feature.MainActivity

@Suppress("unused")
@Module
abstract class Modules {
    @ContributesAndroidInjector
    abstract fun contributeMainActivity(): MainActivity
}
