package com.example.translator.model.datasource

import com.example.translator.model.data.DataModel
import io.reactivex.Observable

class DataSourceLocal (private val localProvider: RoomDataBaseImplementation = RoomDataBaseImplementation())
    :DataSource<List<DataModel>>{
    override suspend fun getData(word: String): Observable<List<DataModel>> = localProvider.getData(word)
}