package ru.zzemlyanaya.vkcase.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import ru.zzemlyanaya.vkcase.R
import ru.zzemlyanaya.vkcase.Utils.FROM_RIGHT
import ru.zzemlyanaya.vkcase.Utils.MODE_REGULAR
import ru.zzemlyanaya.vkcase.Utils.MODE_TARGET
import ru.zzemlyanaya.vkcase.databinding.FragmentChoiceBinding

class ChoiceFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding: FragmentChoiceBinding
            = DataBindingUtil.inflate(inflater, R.layout.fragment_choice, container, false)

        binding.cardTarget.setOnClickListener {
            (requireActivity() as MainActivity).showDataMainFragment(FROM_RIGHT, MODE_TARGET)
        }
        binding.cardMonths.setOnClickListener {
            (requireActivity() as MainActivity).showDataMainFragment(FROM_RIGHT, MODE_REGULAR)
        }
        return binding.root
    }
}