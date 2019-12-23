package co.teltech.weathermvvm.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import co.teltech.weathermvvm.service.model.Weather
import co.teltech.weathermvvm.service.repository.WeatherRepository

class WeatherViewModel(private val repository: WeatherRepository) : ViewModel() {

    fun getWeather() : LiveData<Weather> {
        return repository.getWeatherObservable()
    }

    fun postQuery(query: String) {
        repository.postQuery(query)
    }

}