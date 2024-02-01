package okik.tech.prueba.ui.theme.di

import com.squareup.moshi.Moshi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import okik.tech.prueba.ui.theme.data.ChallengeRepositoryImpl
import okik.tech.prueba.ui.theme.data.Service
import okik.tech.prueba.ui.theme.domain.ChallengeRepository
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class ChallengeModule {
    @Provides @Singleton
    fun providesService(): Service {

        val moshi = Moshi.Builder()
            .build()

        return Retrofit.Builder()
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