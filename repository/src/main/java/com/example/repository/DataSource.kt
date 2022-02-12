package com.example.repository

interface DataSource<T> {
    suspend fun getData(word: String): T
    suspend fun getData(): T
}