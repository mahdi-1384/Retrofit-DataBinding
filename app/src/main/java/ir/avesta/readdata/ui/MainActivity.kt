package ir.avesta.readdata.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import ir.avesta.readdata.MyApplication
import ir.avesta.readdata.R
import ir.avesta.readdata.data.MainViewModel
import ir.avesta.readdata.data.MainViewModelFactory
import ir.avesta.readdata.data.remote.ApiClient
import ir.avesta.readdata.data.remote.ApiInterface
import ir.avesta.readdata.data.remote.Item
import ir.avesta.readdata.databinding.ActivityMainBinding
import ir.avesta.readdata.util.mToast
import retrofit2.Call
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel: MainViewModel by viewModels {
        MainViewModelFactory((application as MyApplication).repository)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        init()
    }



    private fun init() {
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.viewModel = viewModel
        binding.lifecycleOwner = this
    }
}