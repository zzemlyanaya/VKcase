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
import ru.zzemlyanaya.vkcase.Utils.MODE
import ru.zzemlyanaya.vkcase.Utils.MODE_TARGET
import ru.zzemlyanaya.vkcase.Utils.afterTextChanged
import ru.zzemlyanaya.vkcase.databinding.FragmentDataMainBinding
import ru.zzemlyanaya.vkcase.main.MainActivity


class DataMainFragment : Fragment() {
    var mode = ""

    private val viewModel
            by lazy { ViewModelProviders.of(this).get(DataMainViewModel::class.java) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let { mode = it.getString(MODE)!! }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: FragmentDataMainBinding
            = DataBindingUtil.inflate(inflater, R.layout.fragment_data_main, container, false)
        binding.lifecycleOwner = viewLifecycleOwner
        binding.viewmodel = viewModel

        when(mode) {
            MODE_TARGET -> {
                binding.textViewSum.text = resources.getText(R.string.sum_target)
                binding.textSum.hint = resources.getText(R.string.sum_target_prompt)
                binding.textGoal.hint = resources.getText(R.string.goal_target)
                binding.butNext.apply {
                    text = "Далее"
                    setOnClickListener {
                        (requireActivity() as MainActivity).showDataAdditFragment(FROM_RIGHT)
                    }
                }
            }
            else -> {
                binding.textViewSum.text = resources.getText(R.string.sum_regular)
                binding.textSum.hint = resources.getText(R.string.sum_regular_prompt)
                binding.textGoal.hint = resources.getText(R.string.goal_regular)
                binding.butNext.apply {
                    text = "Создать сбор"
                    setOnClickListener {
                        (requireActivity() as MainActivity).showCongratsFragment(FROM_RIGHT)
                    }
                }
            }
        }

        binding.textName.afterTextChanged {
            viewModel.mainDataChanged(
                binding.textName.text.toString(),
                binding.textSum.text.toString(),
                binding.textGoal.text.toString(),
                binding.textDescription.text.toString(),
            )
        }
        binding.textSum.afterTextChanged {
            viewModel.mainDataChanged(
                binding.textName.text.toString(),
                binding.textSum.text.toString(),
                binding.textGoal.text.toString(),
                binding.textDescription.text.toString(),
            )
        }
        binding.textGoal.afterTextChanged {
            viewModel.mainDataChanged(
                binding.textName.text.toString(),
                binding.textSum.text.toString(),
                binding.textGoal.text.toString(),
                binding.textDescription.text.toString(),
            )
        }
        binding.textDescription.afterTextChanged {
            viewModel.mainDataChanged(
                binding.textName.text.toString(),
                binding.textSum.text.toString(),
                binding.textGoal.text.toString(),
                binding.textDescription.text.toString(),
            )
        }

        return binding.root
    }

    companion object {
        @JvmStatic
        fun newInstance(mode: String) = DataMainFragment().apply {
            arguments = Bundle().apply { putString(MODE, mode) }
        }
    }

}