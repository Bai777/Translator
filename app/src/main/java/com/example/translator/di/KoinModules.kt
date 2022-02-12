package com.example.translator.di

import androidx.room.Room
import com.example.model.data.DataModel
import com.example.repository.*
import com.example.repository.room.HistoryDataBase
import com.example.translator.view.main.MainInteractor
import com.example.translator.view.main.MainViewModel
import com.example.view.HistoryInteractor
import com.example.view.HistoryViewModel
import org.koin.dsl.module

val application = module {
    single { Room.databaseBuilder(get(),
        HistoryDataBase::class.java, "HistoryDB").build() }

//    single { get<HistoryDataBase>().historyDao() }

    single<Repository<List<DataModel>>> {
        RepositoryImplementation(RetrofitImplementation())
    }

    single<RepositoryLocal<List<DataModel>>>{
        RepositoryImplementationLocal(RoomDataBaseImplementation(
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
