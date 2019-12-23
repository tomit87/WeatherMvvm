package co.teltech.weathermvvm.di

import android.content.Context
import androidx.lifecycle.ViewModelProvider
import co.teltech.weathermvvm.service.repository.WeatherRepository
import co.teltech.weathermvvm.service.repository.WeatherService

object Injection {

    private fun provideWeatherRepository(context: Context): WeatherRepository{
        return WeatherRepository(WeatherService.getInstance())
    }

    fun provideViewModelFactory(context: Context): ViewModelProvider.Factory{
        return ViewModelFactory(provideWeatherRepository(context))
    }

}