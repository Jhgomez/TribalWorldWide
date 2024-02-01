package okik.tech.prueba.ui.theme.data

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import okik.tech.prueba.ui.theme.domain.Category
import okik.tech.prueba.ui.theme.domain.ChallengeRepository

class ChallengeRepositoryImpl(
    private val service: Service,
    private val defaultDispatcher: CoroutineDispatcher = Dispatchers.IO

): ChallengeRepository {

    override suspend fun getCategories(): List<Category> {
        return withContext(defaultDispatcher) {
            service.categoriesList().body()?.map { category ->
                Category(category)
            }
        } ?: emptyList()
    }
}