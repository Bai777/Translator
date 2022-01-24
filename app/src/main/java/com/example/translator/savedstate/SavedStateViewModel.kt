package com.example.translator.savedstate

import androidx.lifecycle.LiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.switchMap
import com.example.translator.view.main.MainInteractor

class SavedStateViewModel(private val savedStateHandle: SavedStateHandle) : ViewModel() {
    val repository: MainInteractor = TODO()

    val filteredData: LiveData<List<String>> =
        savedStateHandle.getLiveData<String>("query").switchMap { query ->
            repository.getFilteredData(query)
        }

    fun setQuery(query: String) {
        savedStateHandle["query"] = query
    }
}

