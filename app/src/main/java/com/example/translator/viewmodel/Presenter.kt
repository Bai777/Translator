package com.example.translator.viewmodel

import com.example.translator.model.data.AppState
import com.example.translator.view.base.View

interface Presenter<T : AppState, V : View> {
    fun attachView(view: V)
    fun detachView(view: V)
    fun getData(word: String, isOnline: Boolean)
}