package com.example.repository

import com.example.translator.model.data.AppState

interface RepositoryLocal<T>: Repository<T> {
    suspend fun saveToDB(appState: AppState)
}