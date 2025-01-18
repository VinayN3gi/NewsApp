package com.example.newsapp3.Presentation.Onboarding

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.newsapp3.Domain.Manager.LocalUserManager
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class OnBoardingViewModel @Inject constructor(private val localUserManager: LocalUserManager):ViewModel()
{
    private val _state= MutableStateFlow(OnBoardingPageList[0])
    private val _currentScreen=MutableStateFlow(0)
    val currentScreen=_currentScreen.asStateFlow()
    val state:StateFlow<Page> = _state.asStateFlow()

    init{
        readEntry()
    }


    fun nextClick()
    {
        if(_currentScreen.value<2)
        {
            _currentScreen.value++;
            _state.value= OnBoardingPageList[_currentScreen.value]
        }
        else{
           viewModelScope.launch {
               invoke()
           }
        }
    }

    fun previousClick()
    {
        if(_currentScreen.value>0)
        {
            _currentScreen.value--
            _state.value= OnBoardingPageList[_currentScreen.value]
        }
    }

    suspend fun invoke()
    {
        localUserManager.saveAppEntry()
    }

    fun readEntry()
    {
        viewModelScope.launch {
            localUserManager.readAppEntry().collect { it ->
                Log.d("Test", it.toString())
            }
        }

    }


}
