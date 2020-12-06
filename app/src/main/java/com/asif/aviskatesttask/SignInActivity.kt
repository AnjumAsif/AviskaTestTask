package com.asif.aviskatesttask

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import com.asif.aviskatesttask.databinding.ActivitySignInBinding

class SignInActivity : AppCompatActivity() {
    lateinit var binding: ActivitySignInBinding
    private val viewModel: SignViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initialization()
        viewModel.errorMsg.observe(this, Observer {
            it.getContentIfNotHandled()?.let {
                Utils.showToast(this, it)
            }
        })

    }

    private fun initialization() {
        binding = DataBindingUtil.setContentView(this, R.layout.activity_sign_in)
        binding.signInViewModel = viewModel
        binding.lifecycleOwner = this
    }
}