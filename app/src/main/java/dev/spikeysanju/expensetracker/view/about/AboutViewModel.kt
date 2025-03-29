package dev.db.expensetracker.view.about

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class AboutViewModel @Inject constructor() : ViewModel() {
    private val _url = MutableStateFlow("https://github.com/DB-DB09/Expenso")
    val url: StateFlow<String> = _url

    fun launchRepository() {
        _url.value = "https://github.com/DB-DB09/Expenso"
    }
}
