package com.example.translator.di

import androidx.room.Room
import com.example.model.data.DataModel
import com.example.translator.view.main.MainInteractor
import com.example.translator.view.main.MainViewModel
import com.example.view.HistoryInteractor
import com.example.view.HistoryViewModel
import org.koin.dsl.module

val application = module {
    single { Room.databaseBuilder(get(),
        com.example.repository.room.HistoryDataBase::class.java, "HistoryDB").build() }

    single { get<com.example.repository.room.HistoryDataBase>().historyDao() }

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
    factory { HistoryViewModel(get()) }
    factory { HistoryInteractor(get(), get()) }
}
