package com.example.translator.di

import androidx.room.Room
import com.example.translator.model.server.DataModel
import com.example.repository.RetrofitImplementation
import com.example.repository.RoomDataBaseImplementation
import com.example.repository.Repository
import com.example.repository.RepositoryImplementation
import com.example.repository.RepositoryImplementationLocal
import com.example.repository.RepositoryLocal
import com.example.repository.api.room.HistoryDataBase
import history.view.HistoryInteractor
import history.view.HistoryViewModel
import com.example.translator.view.main.MainInteractor
import com.example.translator.view.main.MainViewModel
import org.koin.dsl.module

val application = module {
    single { Room.databaseBuilder(get(),
        com.example.repository.api.room.HistoryDataBase::class.java, "HistoryDB").build() }

    single { get<com.example.repository.api.room.HistoryDataBase>().historyDao() }

    single<com.example.repository.Repository<List<DataModel>>> {
        com.example.repository.RepositoryImplementation(com.example.repository.RetrofitImplementation())
    }

    single<com.example.repository.RepositoryLocal<List<DataModel>>>{
        com.example.repository.RepositoryImplementationLocal(com.example.repository.RoomDataBaseImplementation(
            get()))
    }
}
val mainScreen = module {
    factory { MainViewModel(get()) }
    factory { MainInteractor(get(), get()) }
}

val historyScreen = module {
    factory { history.view.HistoryViewModel(get()) }
    factory { history.view.HistoryInteractor(get(), get()) }
}
