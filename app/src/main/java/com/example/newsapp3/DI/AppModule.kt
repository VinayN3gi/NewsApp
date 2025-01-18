package com.example.newsapp3.DI

import android.app.Application
import com.example.newsapp3.Data.Manager.LocalUserManagerImp
import com.example.newsapp3.Domain.Manager.LocalUserManager
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideLocalUserManger(application: Application): LocalUserManager {
        return LocalUserManagerImp(application);
    }

}