package ru.zzemlyanaya.vkcase.main

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import ru.zzemlyanaya.vkcase.R
import ru.zzemlyanaya.vkcase.Utils.FROM_LEFT
import ru.zzemlyanaya.vkcase.Utils.FROM_RIGHT
import ru.zzemlyanaya.vkcase.Utils.NAME
import ru.zzemlyanaya.vkcase.databinding.ActivityMainBinding
import ru.zzemlyanaya.vkcase.main.posts.PostListFragment


class MainActivity : AppCompatActivity() {
    var name: String = ""
    var postText: String = ""

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
            "first", "news" -> {}
            "create" -> showFirstFragment(FROM_LEFT)
            "congrats" -> showFirstFragment(FROM_LEFT)
            "map" -> showNewsFragment(FROM_LEFT)
            "posts" -> showMapFragment(FROM_LEFT)
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

        binding.headBar.root.visibility = View.GONE
    }

    fun showCreatePostFragment(direction: Int){
        val transaction = supportFragmentManager.beginTransaction()
        when(direction){
            FROM_RIGHT -> transaction.setCustomAnimations(R.anim.enter_from_right, R.anim.exit_to_left, R.anim.enter_from_left, R.anim.exit_to_right)
            else -> transaction.setCustomAnimations(R.anim.enter_from_left, R.anim.exit_to_right, R.anim.enter_from_right, R.anim.exit_to_left)

        }
        transaction
            .replace(R.id.container, CreatePostFragment.newInstance(name), "create")
            .commitAllowingStateLoss()

        binding.headBar.root.visibility = View.GONE
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

        binding.headBar.root.visibility = View.VISIBLE
        binding.headBar.headerText.text = "Успешно"
    }

    fun showNewsFragment(direction: Int){
        val transaction = supportFragmentManager.beginTransaction()
        when(direction){
            FROM_RIGHT -> transaction.setCustomAnimations(R.anim.enter_from_right, R.anim.exit_to_left, R.anim.enter_from_left, R.anim.exit_to_right)
            else -> transaction.setCustomAnimations(R.anim.enter_from_left, R.anim.exit_to_right, R.anim.enter_from_right, R.anim.exit_to_left)

        }
        transaction
            .replace(R.id.container, NewsFragment(), "news")
            .commitAllowingStateLoss()

        binding.headBar.root.visibility = View.GONE
    }

    fun showMapFragment(direction: Int){
        val transaction = supportFragmentManager.beginTransaction()
        when(direction){
            FROM_RIGHT -> transaction.setCustomAnimations(R.anim.enter_from_right, R.anim.exit_to_left, R.anim.enter_from_left, R.anim.exit_to_right)
            else -> transaction.setCustomAnimations(R.anim.enter_from_left, R.anim.exit_to_right, R.anim.enter_from_right, R.anim.exit_to_left)

        }
        transaction
            .replace(R.id.container, MapFragment(), "map")
            .commitAllowingStateLoss()

        binding.headBar.root.visibility = View.GONE
    }

    fun showPostListFragment(direction: Int){
        val transaction = supportFragmentManager.beginTransaction()
        when(direction){
            FROM_RIGHT -> transaction.setCustomAnimations(R.anim.enter_from_right, R.anim.exit_to_left, R.anim.enter_from_left, R.anim.exit_to_right)
            else -> transaction.setCustomAnimations(R.anim.enter_from_left, R.anim.exit_to_right, R.anim.enter_from_right, R.anim.exit_to_left)

        }
        transaction
            .replace(R.id.container, PostListFragment.newInstance(postText), "posts")
            .commitAllowingStateLoss()

        binding.headBar.root.visibility = View.VISIBLE
        binding.headBar.headerText.text = "Искусство"
    }
}