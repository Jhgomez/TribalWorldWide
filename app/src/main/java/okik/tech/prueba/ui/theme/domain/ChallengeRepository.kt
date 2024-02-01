package okik.tech.prueba.ui.theme.domain

interface ChallengeRepository {
    suspend fun getCategories(): List<Category>
}