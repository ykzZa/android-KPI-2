package com.example.lab2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.LifecycleOwner
import com.example.lab2.databinding.FragmentNotificationBinding

class NotificationFragment : Fragment() {

    private val choiceModel : ChoiceModel by activityViewModels()
    lateinit var binding: FragmentNotificationBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentNotificationBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        choiceModel.choice.observe(activity as LifecycleOwner, {
            binding.textView4.text = choiceModel.choice.value
        })
    }

    companion object {

        @JvmStatic
        fun newInstance() = NotificationFragment()
    }
}