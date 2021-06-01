package ir.avesta.readdata.data.remote

class Repository(private val apiInterface: ApiInterface?) {

    fun getData() = apiInterface?.getData()

}