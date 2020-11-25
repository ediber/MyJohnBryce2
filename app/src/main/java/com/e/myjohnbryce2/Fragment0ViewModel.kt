package com.e.myjohnbryce2

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import com.e.myrecyclerlivedatasql_int.database.DatabaseCountry
import com.e.myrecyclerlivedatasql_int.database.getDatabase
import kotlinx.coroutines.*

class Fragment0ViewModel(application: Application) : AndroidViewModel(application) {

    private val database = getDatabase(application)

    // getting the data
    val countries = database.countryDao.getCountries()

    // coroutines are created so the app will not get stuck when using database, because it's a heavy operation
    private var viewModelJob = Job()
    private val coroutineScope = CoroutineScope(viewModelJob + Dispatchers.Main)

    fun add(countryName: String, city: String) {
        val countryObject = DatabaseCountry(countryName, city)

        coroutineScope.launch {
            withContext(Dispatchers.IO){
                database.countryDao.insertCountry(countryObject)
            }
        }
    }
}