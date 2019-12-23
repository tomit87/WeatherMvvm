package co.teltech.weathermvvm.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import co.teltech.weathermvvm.service.repository.WeatherRepository
import co.teltech.weathermvvm.viewmodel.WeatherViewModel

class ViewModelFactory(private val repository: WeatherRepository): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(WeatherViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return WeatherViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}