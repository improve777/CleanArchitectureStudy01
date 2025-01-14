package dev.daeyeon.local.database

import android.content.Context
import androidx.room.Room

class LocalDataBaseProvider private constructor() {

    companion object {
        @Volatile
        private var instance: LocalDataBase? = null

        @JvmStatic
        fun getInstance(context: Context): LocalDataBase =
            instance ?: synchronized(this) {
                instance ?: Room.databaseBuilder(
                    context.applicationContext,
                    LocalDataBase::class.java,
                    "github_sample.db"
                ).build()
                    .also {
                        instance = it
                    }
            }
    }
}