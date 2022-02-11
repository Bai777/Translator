package com.example.core.viewmodel

import com.example.model.data.AppState

interface Interactor<T> {
    suspend fun getData(word: String, fromRemoteSource: Boolean): AppState
}