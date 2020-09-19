package ru.zzemlyanaya.vkcase.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import ru.zzemlyanaya.vkcase.R
import ru.zzemlyanaya.vkcase.Utils.FROM_RIGHT
import ru.zzemlyanaya.vkcase.Utils.NAME
import ru.zzemlyanaya.vkcase.databinding.FragmentCreatePostBinding

class CreatePostFragment : Fragment() {
    private lateinit var name: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            name = it.getString(NAME)!!
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: FragmentCreatePostBinding
            =DataBindingUtil.inflate(inflater, R.layout.fragment_create_post, container, false)

        binding.textName.text = name

        binding.butCancel.setOnClickListener {
            (requireActivity() as MainActivity).onBackPressed()
        }

        binding.butPost.setOnClickListener {
            (requireActivity() as MainActivity).postText = binding.textPost.text.toString()
            (requireActivity() as MainActivity).showNewsFragment(FROM_RIGHT)
        }

        return binding.root
    }

    companion object {
        @JvmStatic
        fun newInstance(name: String) =
            CreatePostFragment().apply {
                arguments = Bundle().apply {
                    putString(NAME, name)
                }
            }
    }
}