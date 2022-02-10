package com.example.repository

import com.example.repository.

interface DataSourceLocal<T>: DataSource<T> {
    suspend fun saveToDB(appState: AppState)
}