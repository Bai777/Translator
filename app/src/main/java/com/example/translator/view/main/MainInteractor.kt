package com.example.translator.view.main

import com.example.translator.model.server.AppState
import com.example.translator.model.server.DataModel
import com.example.repository.Repository
import com.example.repository.RepositoryLocal
import com.example.core.viewmodel.Interactor

class MainInteractor(
    private val repositoryRemote: com.example.repository.Repository<List<DataModel>>,
    private val repositoryLocal: com.example.repository.RepositoryLocal<List<DataModel>>,
) : com.example.core.viewmodel.Interactor<AppState> {

    override suspend fun getData(word: String, fromRemoteSource: Boolean): AppState {
        val appState: AppState
        if (fromRemoteSource) {
            appState = AppState.Success(repositoryRemote.getData(word))
            repositoryLocal.saveToDB(appState)
        } else {
            appState = AppState.Success(repositoryLocal.getData(word))
        }
        return appState
    }
}