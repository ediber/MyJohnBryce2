package com.e.myrecyclerlivedatasql_int.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "database_country")
data class DatabaseCountry(
    @PrimaryKey
    var name: String,

    var capital: String
)