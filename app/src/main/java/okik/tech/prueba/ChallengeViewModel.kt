package okik.tech.prueba

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import okik.tech.prueba.ui.theme.domain.Category
import okik.tech.prueba.ui.theme.domain.ChallengeRepository
import javax.inject.Inject

class ChallengeViewModel @Inject constructor(private val challengeRepository: ChallengeRepository): ViewModel() {

    private val _categories = MutableStateFlow<List<Category>>(emptyList())
    val categories = _categories.asStateFlow()

    init {

    }

    fun getCategories() {
        viewModelScope.launch {

        }
    }
}