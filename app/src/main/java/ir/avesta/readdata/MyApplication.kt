package ir.avesta.readdata

import android.app.Application
import ir.avesta.readdata.data.remote.ApiClient
import ir.avesta.readdata.data.remote.ApiInterface
import ir.avesta.readdata.data.remote.Repository

class MyApplication : Application() {

    val apiInterface: ApiInterface? by lazy { ApiClient.getDatabase()?.create(ApiInterface::class.java) }
    val repository: Repository by lazy { Repository(apiInterface) }

}