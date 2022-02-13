package com.example.model.data.userdata

import geekbrains.ru.model.data.userdata.Meaning

data class DataModel(
    val text: String = "",
    val meanings: List<Meaning> = listOf()
)
