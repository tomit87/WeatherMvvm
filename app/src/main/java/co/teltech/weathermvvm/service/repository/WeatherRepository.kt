package co.teltech.weathermvvm.service.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import co.teltech.weathermvvm.service.model.Weather

class WeatherRepository(
        private var weatherService: WeatherService
) {

    var data: MutableLiveData<Weather> = MutableLiveData()

    fun getWeatherObservable() : LiveData<Weather> {
        return data
    }

    fun postQuery(query: String) {
        val options = WeatherService.getApiParams()
        options["q"] = query
        WeatherService.getInstance().getWeather(options).enqueue(object : retrofit2.Callback<Weather> {
            override fun onFailure(call: retrofit2.Call<Weather>, t: Throwable) {
            }

            override fun onResponse(call: retrofit2.Call<Weather>, response: retrofit2.Response<Weather>) {
                if (response.code() == 200) {
                    data.postValue(response.body())
                }
            }

        })
    }

}