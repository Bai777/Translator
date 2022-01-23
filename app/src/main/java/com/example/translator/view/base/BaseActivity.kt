package com.example.translator.view.base

import androidx.appcompat.app.AppCompatActivity
import com.example.translator.model.data.AppState
import com.example.translator.viewmodel.BaseViewModel

abstract class BaseActivity<T : AppState, U> : AppCompatActivity() {

    abstract val model: BaseViewModel<T>
    abstract fun renderData(appState: T)
}