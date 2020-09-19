package ru.zzemlyanaya.vkcase.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import ru.zzemlyanaya.vkcase.R
import ru.zzemlyanaya.vkcase.Utils.FROM_RIGHT
import ru.zzemlyanaya.vkcase.databinding.FragmentMapBinding

class MapFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: FragmentMapBinding
            =DataBindingUtil.inflate(inflater, R.layout.fragment_map, container, false)

        binding.butClose.setOnClickListener { (requireActivity() as MainActivity).onBackPressed()  }
        binding.butIT.setOnClickListener {
            (requireActivity() as MainActivity).showPostListFragment(FROM_RIGHT)
        }
        binding.butCovid.setOnClickListener {
            (requireActivity() as MainActivity).showPostListFragment(FROM_RIGHT)
        }

        return  binding.root
    }


}