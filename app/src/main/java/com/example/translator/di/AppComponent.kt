package com.example.translator.di

import android.app.Application
import com.example.translator.application.TranslatorApp
import dagger.BindsInstance
import dagger.Component
import dagger.android.support.AndroidSupportInjection
import javax.inject.Singleton

@Component(
    modules = [
        InteractorModule::class,
        RepositoryModule::class,
        ViewModelModule::class,
        ActivityModule::class,
        AndroidSupportInjection::class
    ]
)

@Singleton
interface AppComponent {
    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }

    fun inject(englishVocabularyApp: TranslatorApp)
}