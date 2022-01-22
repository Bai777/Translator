package com.example.translator.rx

import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class SchedulerProvider: ISchedulerProvider {
    override fun io(): Scheduler = Schedulers.io()
    override fun ui() : Scheduler = AndroidSchedulers.mainThread()
}