package okik.tech.prueba.domain

interface ChallengeRepository {
    suspend fun getCategories(): List<Category>
}