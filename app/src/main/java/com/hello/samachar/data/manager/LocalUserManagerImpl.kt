//Implementing the interface file
//Data store preferences is just a jetpack library that allows us to save a value locally on the device.
package com.hello.samachar.data.manager

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.preferencesDataStore
import com.hello.samachar.domain.manager.LocalUserManager
import com.hello.samachar.util.Constants
import com.hello.samachar.util.Constants.USER_SETTINGS
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class LocalUserManagerImpl(         //Using Dagger Hilt we can create instance of this class and inject this Context object in NewsApplication class
    //Saving key value
    //This class needs this Context to work, so Context is working as a dependency
    private val context: Context
) :LocalUserManager{
    override suspend fun saveAppEntry() {
       context.dataStore.edit{settings->
           settings[PreferencesKeys.APP_ENTRY]=true

       }
    }

    override fun readAppEntry(): Flow<Boolean> {
        return context.dataStore.data.map{preferences->
            preferences[PreferencesKeys.APP_ENTRY]?:false //If it is null then it will return false

        }
    }

}
private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = USER_SETTINGS)

private object PreferencesKeys {
    val APP_ENTRY = booleanPreferencesKey(Constants.APP_ENTRY)

}