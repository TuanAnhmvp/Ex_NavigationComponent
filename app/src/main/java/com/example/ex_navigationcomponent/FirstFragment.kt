package com.example.ex_navigationcomponent

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import com.example.ex_navigationcomponent.databinding.FragmentFirstBinding


class FirstFragment : Fragment() {
    //view binding
    private var _binding: FragmentFirstBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val controller = findNavController()

        binding.openFragment2.setOnClickListener {
            val user = User(binding.edtNameuser.text.toString().trim(), binding.edtAgeuser.text.toString().trim().toInt())

            val bundle = bundleOf(
                "userName" to binding.edtName.text.toString().trim(), "user" to user
            )
            controller.navigate(R.id.action_firstFragment_to_secondFragment, bundle)


        }

        binding.openFragment3.setOnClickListener {
            controller.navigate(R.id.thirdFragment)
        }
    }

    /*override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

    }*/


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}