package com.example.newsapp3.Presentation.Onboarding

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class OnBoardingViewModel @Inject constructor():ViewModel()
{
    private val _state= MutableStateFlow(OnBoardingPageList[0])
    private val _currentScreen=MutableStateFlow(0)
    val currentScreen=_currentScreen.asStateFlow()
    val state:StateFlow<Page> = _state.asStateFlow()

    fun nextClick()
    {
        if(_currentScreen.value<2)
        {
            _currentScreen.value++;
            _state.value= OnBoardingPageList[_currentScreen.value]
        }
        else{
            _currentScreen.value=0;
            _state.value= OnBoardingPageList[_currentScreen.value]
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



}
