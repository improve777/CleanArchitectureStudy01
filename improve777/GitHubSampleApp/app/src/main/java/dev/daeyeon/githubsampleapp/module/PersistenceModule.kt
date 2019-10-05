package dev.daeyeon.githubsampleapp.module

import dev.daeyeon.local.database.LocalDataBase
import dev.daeyeon.local.database.LocalDataBaseProvider
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val persistenceModule = module {

    single { LocalDataBaseProvider.getInstance(androidContext()) }

    single { (get() as LocalDataBase).repoDao() }
}
