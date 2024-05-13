package com.hello.samachar.domain.usecases.app_entry

import com.hello.samachar.domain.manager.LocalUserManager
import kotlinx.coroutines.flow.Flow

class ReadAppEntry(
    private val localUserManager: LocalUserManager
) {
    operator fun invoke(): Flow<Boolean> {
        return localUserManager.readAppEntry()
    }
}

//Dependencies injection is a way to send dependencies or objects to a class