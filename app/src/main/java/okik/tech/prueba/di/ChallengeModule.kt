package okik.tech.prueba.di

import com.squareup.moshi.Moshi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import okik.tech.prueba.data.ChallengeRepositoryImpl
import okik.tech.prueba.data.Service
import okik.tech.prueba.domain.ChallengeRepository
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class ChallengeModule {
    @Provides @Singleton
    fun providesService(): Service {
        val logging = HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }

        val client = OkHttpClient.Builder()
            .addInterceptor(logging)
            .build()

        val moshi = Moshi.Builder()
            .build()

        return Retrofit.Builder()
            .client(client)
            .baseUrl("https://api.chucknorris.io/jokes/")
            .addConverterFactory(MoshiConverterFactory.create(
                moshi
            ))
            .build()
            .create(Service::class.java)
    }

    @Provides @Singleton
    fun providesChallengeRepository(service: Service): ChallengeRepository =
        ChallengeRepositoryImpl(service)
}