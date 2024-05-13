//testable file
package com.hello.samachar.domain.manager

import kotlinx.coroutines.flow.Flow

interface LocalUserManager {
    suspend fun saveAppEntry()

    fun readAppEntry(): Flow<Boolean> //Flow is a cold asynchronous stream that can emit multiple values sequentially.
}