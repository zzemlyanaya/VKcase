package ru.zzemlyanaya.vkcase.main.dataaddit

import android.app.DatePickerDialog
import android.app.DatePickerDialog.OnDateSetListener
import android.os.Bundle
import android.text.format.DateUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import ru.zzemlyanaya.vkcase.R
import ru.zzemlyanaya.vkcase.Utils.FROM_RIGHT
import ru.zzemlyanaya.vkcase.Utils.NAME
import ru.zzemlyanaya.vkcase.databinding.FragmentDataAdditBinding
import ru.zzemlyanaya.vkcase.main.MainActivity
import java.util.*


class DataAdditFragment : Fragment() {
    private var name = ""

    private lateinit var textDate: EditText
    private var dateAndTime: Calendar = Calendar.getInstance()

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

        binding.butDate.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked)
                binding.layoutDate.visibility = View.VISIBLE
            else
                binding.layoutDate.visibility = View.INVISIBLE
        }

        binding.textAuthor.setText(name)

        textDate = binding.textDate
        binding.textDate.setText(
            DateUtils.formatDateTime(
                requireContext(),
                dateAndTime.timeInMillis,
                DateUtils.FORMAT_SHOW_DATE
            )
        )
        binding.textDate.setOnFocusChangeListener { _, b -> if(b) showDateDialog() }
        binding.textDate.setOnClickListener { showDateDialog() }

        binding.butDone.setOnClickListener {
            (requireActivity() as MainActivity).showCongratsFragment(FROM_RIGHT)
        }

        return binding.root
    }

    private fun setDate() {
        textDate.setText(
            DateUtils.formatDateTime(
                requireContext(),
                dateAndTime.timeInMillis,
                DateUtils.FORMAT_SHOW_DATE or DateUtils.FORMAT_SHOW_YEAR
            )
        )
    }

    fun showDateDialog() {
        val d =
            OnDateSetListener { _, year, monthOfYear, dayOfMonth ->
                dateAndTime[Calendar.YEAR] = year
                dateAndTime[Calendar.MONTH] = monthOfYear
                dateAndTime[Calendar.DAY_OF_MONTH] = dayOfMonth
                setDate()
            }

        DatePickerDialog(
            requireContext(), d,
            dateAndTime[Calendar.YEAR],
            dateAndTime[Calendar.MONTH],
            dateAndTime[Calendar.DAY_OF_MONTH]
        )
            .show()
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