package co.teltech.weathermvvm.service.model

import com.google.gson.annotations.SerializedName

class Weather(
        @SerializedName("coord") var coordinates: Coordinates,
        @SerializedName("weather") var weatherInfo: List<WeatherInfo>,
        @SerializedName("base") var base: String,
        @SerializedName("main") var mainInfo: MainInfo,
        @SerializedName("visibility") var visibility: Number,
        @SerializedName("wind") var windInfo: WindInfo,
        @SerializedName("timezone") var timezone: Number,
        @SerializedName("name") var name: String
) {
    data class Coordinates(
            @SerializedName("lon") var longitude: Number,
            @SerializedName("lat") var latitude: Number
    )
    data class WeatherInfo(
            @SerializedName("id") var id: Int,
            @SerializedName("main") var main: String,
            @SerializedName("description") var description: String,
            @SerializedName("icon") var icon: String
    )
    data class MainInfo(
            @SerializedName("temp") var temp: Number,
            @SerializedName("feels_like") var feelsLike: Number,
            @SerializedName("temp_min") var tempMin: Number,
            @SerializedName("temp_max") var tempMax: Number,
            @SerializedName("pressure") var pressure: Number,
            @SerializedName("humidity") var humidity: Number
    )
    data class WindInfo(
            @SerializedName("speed") var speed: Number,
            @SerializedName("deg") var deg: Number,
            @SerializedName("gust") var gust: Number
    )
}