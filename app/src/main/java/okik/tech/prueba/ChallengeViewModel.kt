package okik.tech.prueba

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import okik.tech.prueba.domain.Category
import okik.tech.prueba.domain.ChallengeRepository
import javax.inject.Inject

@HiltViewModel
class ChallengeViewModel @Inject constructor(private val challengeRepository: ChallengeRepository): ViewModel() {

    private val _categories = MutableStateFlow<List<Category>>(emptyList())
    val categories = _categories.asStateFlow()

    init {
        getCategories()
    }

    private fun getCategories() {
        viewModelScope.launch() {
            val categories = challengeRepository.getCategories()
            if (!categories.isNullOrEmpty()) {
                _categories.value = categories
            }
        }
    }
}