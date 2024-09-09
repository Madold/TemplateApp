package com.markusw.templateapp.home.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.markusw.templateapp.core.utils.Result
import com.markusw.templateapp.home.domain.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val repository: Repository
) : ViewModel() {

    private val _state = MutableStateFlow(HomeState())
    val state = _state.asStateFlow()

    init {

        _state.update {
            it.copy(
                isLoading = true
            )
        }
        viewModelScope.launch(Dispatchers.IO) {
            delay(1200)
            when (val result = repository.getRepositories(
                language = "kotlin",
                pageSize = 40,
                pageIndex = 1
            )) {
                is Result.Error -> {

                }
                is Result.Success -> {
                    _state.update {
                        it.copy(
                            isLoading = false,
                            repositoriesList = result.data ?: emptyList()
                        )
                    }
                }
            }
        }
    }

}