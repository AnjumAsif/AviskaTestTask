package com.asif.aviskatesttask

import android.app.Application
import android.content.Intent
import android.view.View
import androidx.databinding.Bindable
import androidx.databinding.Observable
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class SignViewModel(application: Application) : AndroidViewModel(application), Observable {
    @Bindable
    private var inputEmail = MutableLiveData<String>()

    @Bindable
    private var inputPassword = MutableLiveData<String>()
    private var showErrorMessage = MutableLiveData<Event<String>>()
    private val mApplication: Application = application


    val emailId: MutableLiveData<String>
        get() = inputEmail
    val password: MutableLiveData<String>
        get() = inputPassword

    val errorMsg: MutableLiveData<Event<String>>
        get() = showErrorMessage


    fun checkValidation(view: View) {
        when {
            inputEmail.value == null -> {
                showErrorMessage.value =
                    Event(mApplication.getString(R.string.email_empty_error_msg))
            }
            inputPassword.value == null -> {
                showErrorMessage.value =
                    Event(mApplication.getString(R.string.enter_a_password_error_msg))
            }
            else -> {
                redirectToHomePage()
            }
        }

    }

    private fun redirectToHomePage() {
        mApplication.startActivity(Intent(mApplication, HomeActivity::class.java).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK))

    }

    override fun addOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {
    }

    override fun removeOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {
    }


}