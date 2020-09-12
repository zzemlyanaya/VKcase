package ru.zzemlyanaya.vkcase.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import ru.zzemlyanaya.vkcase.R
import ru.zzemlyanaya.vkcase.Utils.FROM_RIGHT
import ru.zzemlyanaya.vkcase.databinding.FragmentFirstBinding


class FirstFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: FragmentFirstBinding
                = DataBindingUtil.inflate(inflater, R.layout.fragment_first, container, false)

        binding.butCreate.setOnClickListener {
            (requireActivity() as MainActivity).showChoiceFragment(FROM_RIGHT)
        }

        return binding.root
    }

}