package com.example.repository

import com.example.model.data.dto.SearchResultDto

interface Repository<T> {
    suspend fun getData(word: String): List<SearchResultDto>
}