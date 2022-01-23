package com.example.translator.view.main


import androidx.lifecycle.LiveData
import com.example.translator.model.data.AppState
import com.example.translator.viewmodel.BaseViewModel
import io.reactivex.disposables.Disposable
import io.reactivex.observers.DisposableObserver
import javax.inject.Inject

class MainViewModel @Inject constructor(private val interactor: MainInteractor)
 : BaseViewModel<AppState>() {

    fun subscribe():LiveData<AppState>{
        return liveDataForViewToObserve
    }

    override fun getData(word: String, isOnline: Boolean): LiveData<AppState> {
        compositeDisposable.add(
            interactor.getData(word, isOnline)
                .subscribeOn(schedulerProvider.io())
                .observeOn(schedulerProvider.ui())
                .doOnSubscribe { doOnSubscribe() }
                .subscribeWith(getObserver())
        )
        return super.getData(word, isOnline)
    }

    private fun doOnSubscribe(): (Disposable) -> Unit = {
        liveDataForViewToObserve.value = AppState.Loading(null)
    }
    private fun getObserver(): DisposableObserver<AppState> {
        return object : DisposableObserver<AppState>() {

            override fun onNext(state: AppState) {
                liveDataForViewToObserve.value = state
            }

            override fun onError(e: Throwable) {
                liveDataForViewToObserve.value = AppState.Error(e)
            }

            override fun onComplete() {

            }
        }
    }
}