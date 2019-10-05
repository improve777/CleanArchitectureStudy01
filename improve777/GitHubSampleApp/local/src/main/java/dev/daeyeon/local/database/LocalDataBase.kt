package dev.daeyeon.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import dev.daeyeon.local.dao.RepoDao
import dev.daeyeon.local.entity.RepoEntity

@Database(entities = [RepoEntity::class], version = 1, exportSchema = false)
abstract class LocalDataBase : RoomDatabase() {

    abstract fun repoDao(): RepoDao
}