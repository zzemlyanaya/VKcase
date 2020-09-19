package ru.zzemlyanaya.vkcase.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import ru.zzemlyanaya.vkcase.R
import ru.zzemlyanaya.vkcase.Utils.FROM_RIGHT
import ru.zzemlyanaya.vkcase.databinding.FragmentNewsBinding


class NewsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: FragmentNewsBinding
                =DataBindingUtil.inflate(inflater, R.layout.fragment_news, container, false)

        binding.fabGlobe.setOnClickListener {
            (requireActivity() as MainActivity).showMapFragment(FROM_RIGHT)
        }

        return binding.root
    }

}