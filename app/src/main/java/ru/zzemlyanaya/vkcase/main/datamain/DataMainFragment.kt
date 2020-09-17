package ru.zzemlyanaya.vkcase.main.datamain

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import ru.zzemlyanaya.vkcase.R
import ru.zzemlyanaya.vkcase.Utils.FROM_RIGHT
import ru.zzemlyanaya.vkcase.Utils.afterTextChanged
import ru.zzemlyanaya.vkcase.databinding.FragmentDataMainBinding
import ru.zzemlyanaya.vkcase.main.MainActivity


class DataMainFragment : Fragment() {
    var isFileAdded = false

    private val viewModel
            by lazy { ViewModelProviders.of(this).get(DataMainViewModel::class.java) }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: FragmentDataMainBinding
            = DataBindingUtil.inflate(inflater, R.layout.fragment_data_main, container, false)
        binding.lifecycleOwner = viewLifecycleOwner
        binding.viewmodel = viewModel

        binding.textName.afterTextChanged {
            viewModel.mainDataChanged(
                binding.textName.text.toString(),
                isFileAdded,
                binding.textDescription.text.toString(),
            )
        }
        binding.textDescription.afterTextChanged {
            viewModel.mainDataChanged(
                binding.textName.text.toString(),
                isFileAdded,
                binding.textDescription.text.toString(),
            )
        }

        binding.butAddFile.setOnClickListener {
            isFileAdded = true
            viewModel.mainDataChanged(
                binding.textName.text.toString(),
                isFileAdded,
                binding.textDescription.text.toString(),
            )
            binding.layoutAdd.visibility = View.INVISIBLE
            binding.layoutAdded.visibility = View.VISIBLE
        }

        binding.butEditFile.setOnClickListener {
            (requireActivity() as MainActivity).showDataAdditFragment(FROM_RIGHT)
        }

        binding.butNext.setOnClickListener {
            (requireActivity() as MainActivity).showCongratsFragment(FROM_RIGHT)
        }

        return binding.root
    }


}