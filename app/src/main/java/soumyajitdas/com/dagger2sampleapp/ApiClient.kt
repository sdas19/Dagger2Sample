package soumyajitdas.com.dagger2sampleapp

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import soumyajitdas.com.dagger2sampleapp.Main.DataModel

interface ApiClient {

    @GET("/api/users?page=2")
    fun getData() : Call<DataModel>
}