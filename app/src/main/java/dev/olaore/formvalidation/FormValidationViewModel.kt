package dev.olaore.formvalidation

import android.util.Log
import android.util.Patterns
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

@Suppress("NULLABILITY_MISMATCH_BASED_ON_JAVA_ANNOTATIONS")
class FormValidationViewModel() : ViewModel() {

    var email = MutableLiveData<String>("email@email.com")

    val valid = MediatorLiveData<Boolean>().apply {
        addSource(email) {
            postValue(isFormValid(it))
        }
    }

    private fun isFormValid(address: String): Boolean {
        var valid = Patterns.EMAIL_ADDRESS.matcher(address).matches()
        Log.d("FormValidation", "Address: $address, Valid: $valid")
        return valid
    }

}