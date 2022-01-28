package com.example.translator.model.repository

interface Repository<T> {
    fun getData(word: String): T
}