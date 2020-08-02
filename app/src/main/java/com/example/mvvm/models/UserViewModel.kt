package com.example.mvvm.models

import com.example.mvvm.MyApplication
import com.example.mvvm.api.GithubApi
import javax.inject.Inject

class UserViewModel {
    @Inject
    lateinit var api: GithubApi

    init {
        MyApplication.app.apiComponent.inject(this)
    }

    fun getUserDetails(username: String) = api.getUser(username)
        .map {
            it.copy(login = "@${it.login.toLowerCase()}")
        }
}
