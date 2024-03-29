package com.abhilash.myappread.screen.login

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.api.LogDescriptor
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.launch

class LoginScreenViewModel:ViewModel() {
   // val loadingState= MutableStateFlow(LoadingState.IDLE)
   // private
   private val auth: FirebaseAuth = Firebase.auth
    private val _loading=MutableLiveData(false)
    val loading:LiveData<Boolean> =_loading

    fun signInWithEmailAndPassword(email:String,password:String,Home:()->Unit)
    =viewModelScope.launch{
        try {
            auth.signInWithEmailAndPassword(email, password).
            addOnCompleteListener {
                task->
                if (task.isSuccessful){
                    Log.d("FB","signInWithEmailAndPassword:yyyyyeey${task.result.toString()}")
                    Home()
                   // TODO("TakeThem Home")
                }
                else
                {
                    Log.d("FB","signInWithEmailAndPassword:${task.result.toString()}")
                }
            }
        }
        catch (ex:Exception){
            Log.d("FB","signInWithEmailAndPassword:${ex.message}")

        }

    }
fun createUserWithEmailAndPassword(
    email: String,
    password: String,
    home:()->Unit
){
if (_loading.value==false){
    _loading.value=true
    auth.createUserWithEmailAndPassword(email, password)
        .addOnCompleteListener {
            task->
            if (task.isSuccessful)
            {
                home()
            }else
            {
                Log.d("FB","createUserWithEmailAndPassword:${task.result.toString()}")
            }
            _loading.value=false
        }
}

}

}