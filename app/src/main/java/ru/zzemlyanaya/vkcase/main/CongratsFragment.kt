package ru.zzemlyanaya.vkcase.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import ru.zzemlyanaya.vkcase.R
import ru.zzemlyanaya.vkcase.Utils.NAME
import ru.zzemlyanaya.vkcase.databinding.FragmentCongratsBinding

class CongratsFragment : Fragment() {
    private var name = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let { name = it.getString(NAME)!! }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: FragmentCongratsBinding
                = DataBindingUtil.inflate(inflater, R.layout.fragment_congrats, container, false)

        binding.butHey.setOnClickListener {
            (requireActivity() as MainActivity).onBackPressed()
        }

        return binding.root
    }
}