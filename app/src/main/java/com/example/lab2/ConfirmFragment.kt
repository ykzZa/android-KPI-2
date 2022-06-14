package com.example.lab2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.LifecycleOwner
import com.example.lab2.databinding.FragmentConfirmBinding
import com.example.lab2.databinding.FragmentDataInputBinding


class ConfirmFragment : Fragment() {

    lateinit var binding: FragmentConfirmBinding
    private val choiceModel : ChoiceModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentConfirmBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        choiceModel.choice.observe(activity as LifecycleOwner, {
            binding.textConfirm.text = choiceModel.choice.value
        })

        binding.button.setOnClickListener {
            choiceModel.choice.value = choiceModel.choice.value?.dropLast(9)
            activity?.supportFragmentManager
                ?.beginTransaction()
                ?.replace(R.id.frameLayoutConfirm, NotificationFragment.newInstance())
                ?.addToBackStack(null)
                ?.commit()}

        binding.button2.setOnClickListener {
            choiceModel.choice.value = "You've canceled your choice"
            activity?.supportFragmentManager
                ?.beginTransaction()
                ?.replace(R.id.frameLayoutConfirm, NotificationFragment.newInstance())
                ?.addToBackStack(null)
                ?.commit()
        }
    }


    companion object {

        @JvmStatic
        fun newInstance() = ConfirmFragment()
    }
}
