package co.teltech.weathermvvm.view.ui

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import co.teltech.weatherkotlin.R
import co.teltech.weathermvvm.di.Injection
import co.teltech.weathermvvm.service.model.Weather
import co.teltech.weathermvvm.viewmodel.WeatherViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var viewModel: WeatherViewModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProviders.of(this, Injection.provideViewModelFactory(this)).get(WeatherViewModel::class.java)
        viewModel?.let {
            it.getWeather().observe(this, Observer<Weather> {
                runOnUiThread {
                    labelCityName.text = it.name
                    labelWeatherDescription.text = it.weatherInfo.get(0).description
                    labelCurrentTemp.text = it.mainInfo.temp.toString()

                    weatherData.visibility = View.VISIBLE
                }
            })
        }
    }

    fun getData(query: String) {
        viewModel?.let {
            it.postQuery(query)
        }
    }

    fun fetchWeather(v: View) {
        weatherData.visibility = View.GONE
        if (searchField.text.toString().equals("")) {
            Toast.makeText(this, getString(R.string.toast_enter_city_name), Toast.LENGTH_SHORT).show()
        } else {
            getData(searchField.text.toString())
        }
    }
}
