package com.jeison.mvvmapp.domain

import com.jeison.mvvmapp.data.model.QuoteModel
import com.jeison.mvvmapp.data.model.QuoteProvider


class GetRandomQuoteUseCase {
    operator fun invoke(): QuoteModel? {
        val quotes: List<QuoteModel> = QuoteProvider.quotes
        if (quotes.isNullOrEmpty()) {
            val randomNumber: Int = (quotes.indices).random()
            return quotes[randomNumber]
        }

        return null

    }
}