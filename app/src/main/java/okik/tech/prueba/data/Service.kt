package okik.tech.prueba.data

import retrofit2.Response
import retrofit2.http.GET

interface Service {
    @GET("categories")
    suspend fun categoriesList(): Response<List<String>>
}
