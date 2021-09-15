package com.example.university.di

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class University : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@University)
            modules(listOf(netModule, apiInterface, viewModel, repository))
        }
    }
}