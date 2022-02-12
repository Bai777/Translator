package com.example.repository

import com.example.model.data.DataModel
import com.example.repository.room.HistoryDataBase
import mapHistoryEntityToSearchResult

class RoomDataBaseImplementation(private val historyDao: HistoryDataBase) :
    DataSource<List<DataModel>> {

    private val db = historyDao.getHistoryDao()

    override suspend fun getData(word: String): List<DataModel> {
        return mapHistoryEntityToSearchResult(db.getDataByWord(word))
    }

    override suspend fun getData(): List<DataModel> {
        return mapHistoryEntityToSearchResult(db.all())
    }
}