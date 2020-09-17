package ru.zzemlyanaya.vkcase.main.dataaddit

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import ru.zzemlyanaya.vkcase.R
import ru.zzemlyanaya.vkcase.Utils.NAME
import ru.zzemlyanaya.vkcase.databinding.FragmentDataAdditBinding


class DataAdditFragment : Fragment() {
    private var name = ""



    private val viewModel
                    by lazy { ViewModelProviders.of(this).get(DataAdditViewModel::class.java) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let { name = it.getString(NAME)!! }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: FragmentDataAdditBinding
                = DataBindingUtil.inflate(inflater, R.layout.fragment_data_addit, container, false)


        return binding.root
    }




    companion object {
        @JvmStatic
        fun newInstance(name: String) =
            DataAdditFragment().apply {
                arguments = Bundle().apply {
                    putString(NAME, name)
                }
            }
    }

}