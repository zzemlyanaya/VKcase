package ru.zzemlyanaya.vkcase

import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText

object Utils {
    const val NAME = "name"

    const val FROM_RIGHT = 0
    const val FROM_LEFT = 1

    const val MODE = "mode"
    const val MODE_TARGET = "target"
    const val MODE_REGULAR = "regular"

    /**
     * Extension function to simplify setting an afterTextChanged action to EditText components.
     */
    fun EditText.afterTextChanged(afterTextChanged: (String) -> Unit) {
        this.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(editable: Editable?) {
                afterTextChanged.invoke(editable.toString())
            }

            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {}
        })
    }
}