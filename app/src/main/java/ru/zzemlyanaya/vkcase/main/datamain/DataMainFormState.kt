package ru.zzemlyanaya.vkcase.main.datamain

data class DataMainFormState(
    var nameError: String? = null,
    var fileError: String? = null,
    var descriptionError: String? = null,
    var isDataValid: Boolean = false
)