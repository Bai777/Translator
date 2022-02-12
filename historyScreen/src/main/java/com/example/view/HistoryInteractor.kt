package com.example.view

import com.example.core.viewmodel.Interactor
import com.example.model.data.AppState
import com.example.repository.Repository
import com.example.repository.RepositoryLocal
import com.example.model.data.DataModel

class HistoryInteractor(
    private val repositoryRemote: Repository<List<DataModel>>,
    private val repositoryLocal: RepositoryLocal<List<DataModel>>,
) : Interactor<AppState> {
    override suspend fun getData(word: String, fromRemoteSource: Boolean): AppState {
        return AppState.Success(
            if (fromRemoteSource) {
                repositoryRemote
            } else {
                repositoryLocal
            }.getData(word)
        )
    }
}