package ru.zzemlyanaya.vkcase.login

import android.content.Intent
import android.os.Bundle
import android.view.inputmethod.EditorInfo
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import ru.zzemlyanaya.vkcase.R
import ru.zzemlyanaya.vkcase.Utils.NAME
import ru.zzemlyanaya.vkcase.databinding.ActivityLoginBinding
import ru.zzemlyanaya.vkcase.main.MainActivity

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityLoginBinding
                = DataBindingUtil.setContentView(this, R.layout.activity_login)

        binding.butLogin.setOnClickListener {
            if(binding.textLogin.text.isNullOrBlank())
                Toast.makeText(this, "Имя не может быть пустым!", Toast.LENGTH_SHORT).show()
            else
                goOnMain(binding.textLogin.text.toString())
        }

        binding.textLogin.setOnEditorActionListener { textLogin, actionID, _ ->
            when(actionID){
                EditorInfo.IME_ACTION_DONE -> {
                    if(textLogin.text.isNullOrBlank())
                        Toast.makeText(this, "Имя не может быть пустым!", Toast.LENGTH_SHORT).show()
                    else
                        goOnMain(textLogin.text.toString())
                }
            }
            false
        }
    }

    private fun goOnMain(name: String) {
        val intent = Intent(this, MainActivity::class.java)
        intent.putExtra(NAME, name)
        startActivity(intent)
        finish()
    }
}