package com.example.mvvm

import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.mvvm.databinding.ActivityMainBinding
import com.example.mvvm.entities.User
import com.example.mvvm.models.UserViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class ProfileActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val userViewModel = UserViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(LayoutInflater.from(this))
        setContentView(binding.root)

        userViewModel.getUserDetails("omaraflak")
            .subscribeOn(Schedulers.computation())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSuccess(::showUser)
            .doOnError(::showError)
            .subscribe()
    }

    private fun showUser(user: User) {
        Glide.with(this).load(user.avatar_url).into(binding.profileImage)
        binding.name.text = user.name
        binding.username.text = user.login
        binding.reposCount.text = user.public_repos.toString()
        binding.followersCount.text = user.followers.toString()
    }

    private fun showError(t: Throwable) {
        t.printStackTrace()
    }
}
