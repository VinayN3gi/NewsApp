package com.example.newsapp3.Data.Manager

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.preferencesDataStore
import com.example.newsapp3.Domain.Manager.LocalUserManager
import com.example.newsapp3.utils.Constants
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map


class LocalUserManagerImp(
    private val context: Context
):LocalUserManager {


    override suspend fun saveAppEntry() {
        context.dataStore.edit {settings->
            settings[PreferencesKey.APP_ENTRY]=true
        }
    }

    override fun readAppEntry(): Flow<Boolean> {
        return context.dataStore.data.map {preferences->
            preferences[PreferencesKey.APP_ENTRY]?:false
        }
    }
}

private val Context.dataStore:DataStore<Preferences> by preferencesDataStore(name=Constants.USER_SETTINGS)//Name of the datastore

//Datastore keys
private object PreferencesKey{
    val APP_ENTRY= booleanPreferencesKey(name=Constants.APP_ENTRY)
}

