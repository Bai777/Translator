package com.example.translator.model.datasource

import com.example.translator.model.data.DataModel

interface DataSource<T> {
    suspend fun getData(word: String): List<DataModel>
}