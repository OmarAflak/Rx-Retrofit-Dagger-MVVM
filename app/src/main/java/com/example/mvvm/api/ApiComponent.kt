package com.example.mvvm.api

import com.example.mvvm.models.UserViewModel
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [GithubModule::class])
interface ApiComponent {
    fun inject(model: UserViewModel)
}
