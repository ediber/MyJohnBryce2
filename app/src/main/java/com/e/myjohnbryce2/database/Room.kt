package com.e.myrecyclerlivedatasql_int.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [DatabaseCountry::class], version = 1)
abstract class CountriesDatabase : RoomDatabase() {
    abstract val countryDao: CountryDao
}

private lateinit var INSTANCE: CountriesDatabase

// this is a singelton, makes sure that only 1 instance of Room database is created
fun getDatabase(context: Context): CountriesDatabase {
    synchronized(CountriesDatabase::class.java) {
        if (!::INSTANCE.isInitialized) {
            INSTANCE = Room.databaseBuilder(context.applicationContext,
                CountriesDatabase::class.java,
                "countries").build()
        }
    }
    return INSTANCE
}