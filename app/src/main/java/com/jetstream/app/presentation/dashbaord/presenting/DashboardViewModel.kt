package com.jetstream.app.presentation.dashbaord.presenting

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jetstream.app.presentation.dashbaord.domain.usecase.GetDashboardUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.async
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DashboardViewModel @Inject constructor(
    private val getProfileUseCase: GetDashboardUseCase,


    ) : ViewModel() {

    private val _state = MutableStateFlow(DashboardState())
    val state = _state.asStateFlow()

    init {
        loadDashboard()
    }

    fun loadDashboard() {

        viewModelScope.launch {

            try {

                _state.update {
                    it.copy(isLoading = true)
                }

                val dataDashDeferred = async {
                    getProfileUseCase()
                }




                _state.update {
                    it.copy(
                        isLoading = false,
                          data=dataDashDeferred.await(),


                    )
                }

            } catch (e: Exception) {

                _state.update {
                    it.copy(
                        isLoading = false,
                        error = e.message ?: "Unknown Error"
                    )
                }
            }
        }
    }
}