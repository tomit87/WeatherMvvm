package co.teltech.weathermvvm.service.repository

import co.teltech.weatherkotlin.BuildConfig
import co.teltech.weathermvvm.service.model.Weather
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.QueryMap

interface WeatherService {

    @GET("/data/2.5/weather")
    fun getWeather(@QueryMap options: Map<String, String>): Call<Weather>

    companion object {

        var BASE_URL = "http://api.openweathermap.org/"

        fun getInstance(): WeatherService {
            val interceptor = HttpLoggingInterceptor()

            if (BuildConfig.DEBUG) {
                interceptor.level = HttpLoggingInterceptor.Level.BODY
            } else {
                interceptor.level = HttpLoggingInterceptor.Level.NONE
            }

            val client = OkHttpClient.Builder().addInterceptor(interceptor).build()

            val retrofitBuilder = Retrofit.Builder()
                    .client(client)
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create())
                    .baseUrl(BASE_URL)

            val retrofit = retrofitBuilder.build()
            return retrofit.create(WeatherService::class.java)
        }

        fun getApiParams(): HashMap<String, String> {
            val options = HashMap<String, String>()
            options["appid"] = "ffee28b9ec9430dc8d18e4c8a3d69854"
            options["units"] = "metric"
            return options
        }

    }

}