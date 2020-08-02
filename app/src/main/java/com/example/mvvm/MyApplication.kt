package com.example.mvvm

import android.app.Application
import com.example.mvvm.api.ApiComponent
import com.example.mvvm.api.DaggerApiComponent
import com.example.mvvm.api.GithubModule

class MyApplication : Application() {
    val apiComponent: ApiComponent = DaggerApiComponent.builder()
        .githubModule(GithubModule())
        .build()

    override fun onCreate() {
        super.onCreate()
        app = this
    }

    companion object {
        lateinit var app: MyApplication
    }
}
