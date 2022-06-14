package com.example.lab2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.activityViewModels
import com.example.lab2.databinding.FragmentDataInputBinding

class DataInputFragment : Fragment() {

    lateinit var binding: FragmentDataInputBinding
    private val choiceModel : ChoiceModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDataInputBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        val spinner : Spinner = binding.spinner
        activity?.let {
            ArrayAdapter.createFromResource(
                it.applicationContext,
                R.array.typesArray,
                android.R.layout.simple_spinner_item
            ).also { adapter ->
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                spinner.adapter = adapter
            }
        }

        binding.bFragIn.setOnClickListener {buttonClick()}
    }

    private fun buttonClick() {

        if( !binding.rbtnApple.isChecked and !binding.rbtnOppo.isChecked and !binding.rbtnSamsung.isChecked) {
            val alert = AlertFragment()
            alert.show(parentFragmentManager, "alert")
        }

        when {
            binding.rbtnApple.isChecked ->
            {choiceModel.choice.value = "You chose Apple ${binding.spinner.selectedItem.toString().lowercase()} phone. Confirm?"
                activity?.supportFragmentManager
                    ?.beginTransaction()
                    ?.replace(R.id.frameLayoutConfirm, ConfirmFragment.newInstance())
                    ?.addToBackStack(null)
                    ?.commit()}
            binding.rbtnOppo.isChecked ->
            {choiceModel.choice.value = "You chose Oppo ${binding.spinner.selectedItem.toString().lowercase()} phone. Confirm?"
                activity?.supportFragmentManager
                    ?.beginTransaction()
                    ?.replace(R.id.frameLayoutConfirm, ConfirmFragment.newInstance())
                    ?.addToBackStack(null)
                    ?.commit()}
            binding.rbtnSamsung.isChecked ->
            {choiceModel.choice.value = "You chose Samsung ${binding.spinner.selectedItem.toString().lowercase()} phone. Confirm?"
                activity?.supportFragmentManager
                    ?.beginTransaction()
                    ?.replace(R.id.frameLayoutConfirm, ConfirmFragment.newInstance())
                    ?.addToBackStack(null)
                    ?.commit()}
        }


    }

    companion object {

        @JvmStatic
        fun newInstance() = DataInputFragment()
    }
}