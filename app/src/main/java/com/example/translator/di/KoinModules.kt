package com.example.translator.di

import androidx.room.Room
import com.example.model.data.dto.SearchResultDto
import com.example.repository.*
import com.example.repository.room.HistoryDataBase
import com.example.translator.view.main.MainActivity
import com.example.translator.view.main.MainInteractor
import com.example.translator.view.main.MainViewModel
import com.example.view.HistoryActivity
import com.example.view.HistoryInteractor
import com.example.view.HistoryViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.qualifier.named
import org.koin.dsl.module

val application = module {
    single { Room.databaseBuilder(get(),
        HistoryDataBase::class.java, "HistoryDB").build() }

    single { get<HistoryDataBase>().getHistoryDao()}

    single<Repository<List<SearchResultDto>>> {
        RepositoryImplementation(RetrofitImplementation())
    }

    single<RepositoryLocal<List<SearchResultDto>>>{
        RepositoryImplementationLocal(RoomDataBaseImplementation(
            get()))
    }
}
val mainScreen = module {

    scope(named<MainActivity>()){
        scoped{MainInteractor(get(), get())}
        viewModel{MainViewModel(get())}
    }
}

val historyScreen = module {

    scope(named<HistoryActivity>()){
        scoped{HistoryInteractor(get(), get())}
        viewModel{HistoryViewModel(get())}
    }
}
