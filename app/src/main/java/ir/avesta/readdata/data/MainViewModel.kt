package ir.avesta.readdata.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import ir.avesta.readdata.data.remote.Item
import ir.avesta.readdata.data.remote.Repository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainViewModel(
    repo: Repository

) : ViewModel() {

    private val _name = MutableLiveData<String>()
    val name: LiveData<String>
        get() = _name

    private val _age = MutableLiveData<String>()
    val age: LiveData<String>
        get() = _age

    private val _error = MutableLiveData<String>()
    val error: LiveData<String>
        get() = _error

    private val _resultVisible = MutableLiveData<Boolean>(false)
    val resultVisible: LiveData<Boolean>
        get() = _resultVisible

    init {
        repo.getData()?.enqueue(object : Callback<Item> {
            override fun onResponse(call: Call<Item>, response: Response<Item>) {
                val item = response.body()

                _name.value = item?.name
                _age.value = item?.age.toString()

                _resultVisible.value = true
            }

            override fun onFailure(call: Call<Item>, t: Throwable) {
                _error.value = t.message

                _resultVisible.value = true
            }
        })
    }
}


class MainViewModelFactory(
    private val repo: Repository

) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return MainViewModel(repo) as T
    }
}