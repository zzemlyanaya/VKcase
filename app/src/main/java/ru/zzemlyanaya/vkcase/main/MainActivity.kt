package ru.zzemlyanaya.vkcase.main

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import ru.zzemlyanaya.vkcase.R
import ru.zzemlyanaya.vkcase.Utils.FROM_LEFT
import ru.zzemlyanaya.vkcase.Utils.FROM_RIGHT
import ru.zzemlyanaya.vkcase.Utils.MODE_TARGET
import ru.zzemlyanaya.vkcase.Utils.NAME
import ru.zzemlyanaya.vkcase.databinding.ActivityMainBinding
import ru.zzemlyanaya.vkcase.main.dataaddit.DataAdditFragment
import ru.zzemlyanaya.vkcase.main.datamain.DataMainFragment

class MainActivity : AppCompatActivity() {
    var name: String = ""

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        name = intent?.getStringExtra(NAME)!!

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Toast.makeText(this, "Привет, $name!", Toast.LENGTH_SHORT).show()

        binding.headBar.butBack.setOnClickListener { onBackPressed() }

        showFirstFragment(FROM_RIGHT)
    }

    override fun onBackPressed() {
        val fragment = supportFragmentManager.findFragmentById(R.id.container)
        when(fragment!!.tag) {
            "first" -> {}
            "choice" -> showFirstFragment(FROM_LEFT)
            "data_main_target" -> showChoiceFragment(FROM_LEFT)
            "data_main_regular" -> showChoiceFragment(FROM_LEFT)
            "data_addit" -> showDataMainFragment(FROM_LEFT, MODE_TARGET)
            "congrats" -> showFirstFragment(FROM_LEFT)
            else -> {}
        }
    }

    private fun showFirstFragment(direction: Int){
        val transaction = supportFragmentManager.beginTransaction()
        when(direction){
            FROM_RIGHT -> transaction.setCustomAnimations(R.anim.enter_from_right, R.anim.exit_to_left, R.anim.enter_from_left, R.anim.exit_to_right)
            else -> transaction.setCustomAnimations(R.anim.enter_from_left, R.anim.exit_to_right, R.anim.enter_from_right, R.anim.exit_to_left)
        }
        transaction
            .replace(R.id.container, FirstFragment(), "first")
            .commitAllowingStateLoss()

        binding.headBar.root.visibility = View.VISIBLE
        binding.headBar.headerText.text = "Пожертвования"
        binding.headBar.butBack.visibility = View.INVISIBLE
    }

    fun showChoiceFragment(direction: Int){
        val transaction = supportFragmentManager.beginTransaction()
        when(direction){
            FROM_RIGHT -> transaction.setCustomAnimations(R.anim.enter_from_right, R.anim.exit_to_left, R.anim.enter_from_left, R.anim.exit_to_right)
            else -> transaction.setCustomAnimations(R.anim.enter_from_left, R.anim.exit_to_right, R.anim.enter_from_right, R.anim.exit_to_left)

        }
        transaction
            .replace(R.id.container, ChoiceFragment(), "choice")
            .commitAllowingStateLoss()

        binding.headBar.headerText.text = "Тип сбора"
        binding.headBar.butBack.visibility = View.VISIBLE
    }

    fun showDataMainFragment(direction: Int, mode: String){
        val transaction = supportFragmentManager.beginTransaction()
        when(direction){
            FROM_RIGHT -> transaction.setCustomAnimations(R.anim.enter_from_right, R.anim.exit_to_left, R.anim.enter_from_left, R.anim.exit_to_right)
            else -> transaction.setCustomAnimations(R.anim.enter_from_left, R.anim.exit_to_right, R.anim.enter_from_right, R.anim.exit_to_left)

        }
        transaction
            .replace(R.id.container, DataMainFragment.newInstance(mode), "data_main_$mode")
            .commitAllowingStateLoss()

        binding.headBar.headerText.text = "Основное"
    }

    fun showDataAdditFragment(direction: Int){
        val transaction = supportFragmentManager.beginTransaction()
        when(direction){
            FROM_RIGHT -> transaction.setCustomAnimations(R.anim.enter_from_right, R.anim.exit_to_left, R.anim.enter_from_left, R.anim.exit_to_right)
            else -> transaction.setCustomAnimations(R.anim.enter_from_left, R.anim.exit_to_right, R.anim.enter_from_right, R.anim.exit_to_left)

        }
        transaction
            .replace(R.id.container, DataAdditFragment.newInstance(name), "data_addit")
            .commitAllowingStateLoss()

        binding.headBar.headerText.text = "Дополнительно"
    }

    fun showCongratsFragment(direction: Int){
        val transaction = supportFragmentManager.beginTransaction()
        when(direction){
            FROM_RIGHT -> transaction.setCustomAnimations(R.anim.enter_from_right, R.anim.exit_to_left, R.anim.enter_from_left, R.anim.exit_to_right)
            else -> transaction.setCustomAnimations(R.anim.enter_from_left, R.anim.exit_to_right, R.anim.enter_from_right, R.anim.exit_to_left)

        }
        transaction
            .replace(R.id.container, CongratsFragment(), "congrats")
            .commitAllowingStateLoss()

        binding.headBar.headerText.text = "Поздравления"
    }
}