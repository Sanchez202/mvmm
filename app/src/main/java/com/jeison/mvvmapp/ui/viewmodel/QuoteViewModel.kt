package com.jeison.mvvmapp.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jeison.mvvmapp.data.model.QuoteModel
import com.jeison.mvvmapp.data.model.QuoteProvider
import com.jeison.mvvmapp.domain.GetQuotesUseCase
import com.jeison.mvvmapp.domain.GetRandomQuoteUseCase
import kotlinx.coroutines.launch

class QuoteViewModel : ViewModel() {

     val quoteModel = MutableLiveData<QuoteModel>()
    val isloading=MutableLiveData<Boolean>()

val getQuotesUseCase=GetQuotesUseCase()

    val  GetRandomQuoteUseCase = GetRandomQuoteUseCase()


    fun onCreate() {
        viewModelScope.launch {
isloading.postValue(true)

            val result = getQuotesUseCase()


            if (!result.isNullOrEmpty()){

                quoteModel.postValue(result[0])

                isloading.postValue(false)
        }

        }
    }
    fun randomQuote() {

        isloading.postValue(true)
val quote=GetRandomQuoteUseCase()
        if(quote!=null){
            quoteModel.postValue(quote)
        }
        isloading.postValue(false)

    }

}

