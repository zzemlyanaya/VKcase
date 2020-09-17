package ru.zzemlyanaya.vkcase.main.datamain

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class DataMainViewModel : ViewModel() {
    private val _mainForm = MutableLiveData(DataMainFormState())
    val loginFormState: LiveData<DataMainFormState> = _mainForm

    fun mainDataChanged(name: String, isFileAdded: Boolean, description: String){
        _mainForm.value =
            DataMainFormState(
                validateField(name),
                if (isFileAdded) null else "Добавьте файл!",
                validateField(description),
                name.isNotBlank() && isFileAdded && description.isNotBlank())
    }

    private fun validateField(data: String)
        = if (data.isBlank()) "Заполните все поля" else null
}