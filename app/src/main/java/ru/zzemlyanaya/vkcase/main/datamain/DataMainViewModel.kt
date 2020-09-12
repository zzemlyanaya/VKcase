package ru.zzemlyanaya.vkcase.main.datamain

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class DataMainViewModel : ViewModel() {
    private val _mainForm = MutableLiveData(DataMainFormState())
    val loginFormState: LiveData<DataMainFormState> = _mainForm

    fun mainDataChanged(name: String, sum: String, goal: String, description: String){
        _mainForm.value =
            DataMainFormState(
                validateField(name),
                validateField(sum),
                validateField(goal),
                validateField(description),
                name.isNotBlank() && sum.isNotBlank() && goal.isNotBlank() && description.isNotBlank())
    }

    private fun validateField(data: String)
        = if (data.isBlank()) "Заполните все поля" else null
}