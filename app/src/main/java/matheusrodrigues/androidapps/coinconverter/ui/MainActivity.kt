package matheusrodrigues.androidapps.coinconverter.ui

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.core.widget.doAfterTextChanged
import matheusrodrigues.androidapps.coinconverter.R
import matheusrodrigues.androidapps.coinconverter.data.model.Coin
import matheusrodrigues.androidapps.coinconverter.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        bindAdapters()
        bindListeners()
    }

    private fun bindAdapters() {
        val list = Coin.values()
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, list)

        binding.tvFrom.setAdapter(adapter)
        binding.tvTo.setAdapter(adapter)

        binding.tvFrom.setText(Coin.BRL.name, false)
        binding.tvTo.setText(Coin.USD.name, false)
    }

    private fun bindListeners() {
        binding.tilValue.editText?.doAfterTextChanged {
            binding.btnConverter.isEnabled = it != null && it.toString().isNotEmpty()
        }

        binding.btnConverter.setOnClickListener {

        }
    }
}