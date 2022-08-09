package com.example.ex_navigationcomponent

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.example.ex_navigationcomponent.databinding.FragmentSecondBinding
import com.example.ex_navigationcomponent.databinding.FragmentThirdBinding

class ThirdFragment : Fragment() {
    //view binding
    private var _binding: FragmentThirdBinding? = null

    private val binding get() = _binding!!



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentThirdBinding.inflate(inflater, container, false)
        return binding.root

    }
    private val args: ThirdFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        val user = args.user
        val userName = args.addressHaNoi

        binding.txtUser.text = "$user"
        binding.txtUserName.text = userName
    }


}