package okik.tech.prueba.ui.theme.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okik.tech.prueba.ui.theme.data.ChallengeRepositoryImpl
import okik.tech.prueba.ui.theme.data.Service
import okik.tech.prueba.ui.theme.domain.ChallengeRepository
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class ChallengeModule {
    @Provides @Singleton
    fun providesService(): Service {
        return Retrofit.Builder()
            .baseUrl("https://api.chucknorris.io/jokes")
            .build()
            .create(Service::class.java)
    }

    @Provides @Singleton
    fun providesChallengeRepository(service: Service): ChallengeRepository =
        ChallengeRepositoryImpl(service)
}