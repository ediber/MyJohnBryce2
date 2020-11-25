package com.e.myrecyclerlivedatasql_int.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface CountryDao {

    @Query("select * from database_country")
    fun getCountries(): LiveData<List<DatabaseCountry>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertCountry(databaseCountry: DatabaseCountry)
}