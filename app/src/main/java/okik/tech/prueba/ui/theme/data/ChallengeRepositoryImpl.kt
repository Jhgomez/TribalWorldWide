package okik.tech.prueba.ui.theme.data

import okik.tech.prueba.ui.theme.domain.Category
import okik.tech.prueba.ui.theme.domain.ChallengeRepository

class ChallengeRepositoryImpl(private val service: Service): ChallengeRepository {

    override suspend fun getCategories(): List<Category> {
        return service.categoriesList().execute().body()?.map { category ->
            Category(category.name)
        } ?: emptyList()
    }
}