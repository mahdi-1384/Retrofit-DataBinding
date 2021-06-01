package ir.avesta.readdata.data.remote

import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {

    @GET("uc?export=download&id=1PXhMuUqAFbgge2V2QFTc2HoUkE-ULfx0")
    fun getData(): Call<Item>

}