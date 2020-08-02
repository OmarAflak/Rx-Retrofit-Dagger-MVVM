package com.example.mvvm.api

import com.example.mvvm.entities.User
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path

interface GithubApi {
    @GET("/users/{username}")
    fun getUser(@Path("username") username: String): Single<User>
}
