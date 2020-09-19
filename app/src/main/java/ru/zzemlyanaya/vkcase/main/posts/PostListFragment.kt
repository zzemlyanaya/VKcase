package ru.zzemlyanaya.vkcase.main.posts

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import ru.zzemlyanaya.vkcase.R
import ru.zzemlyanaya.vkcase.Utils.TEXT
import ru.zzemlyanaya.vkcase.databinding.FragmentPostListBinding


class PostListFragment : Fragment() {
    private lateinit var text: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            text = it.getString(TEXT)!!
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: FragmentPostListBinding
            =DataBindingUtil.inflate(inflater, R.layout.fragment_post_list, container, false)

        val list = listOf(text, text, text)
        with(binding.recyclerView) {
            layoutManager = LinearLayoutManager(context)
            adapter = PostAdapter(list)
        }

        return binding.root
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String) =
            PostListFragment().apply {
                arguments = Bundle().apply {
                    putString(TEXT, param1)
                }
            }
    }
}