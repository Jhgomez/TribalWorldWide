package okik.tech.prueba.ui.theme.data

import retrofit2.Call
import retrofit2.http.GET

interface Service {
    @GET("categories")
    suspend fun categoriesList(): Call<List<Category>>
}