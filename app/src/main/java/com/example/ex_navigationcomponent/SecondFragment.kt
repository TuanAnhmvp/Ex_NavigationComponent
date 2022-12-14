package com.example.ex_navigationcomponent

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.ex_navigationcomponent.databinding.FragmentSecondBinding


class SecondFragment : Fragment() {
    //view binding
    private var _binding: FragmentSecondBinding? = null

    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentSecondBinding.inflate(inflater, container, false)
        return binding.root
    }

    private var address = "Tuan Anh"
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val controller = findNavController()

        val bundle = arguments
        val userName  = bundle?.getString("userName")

        val user = bundle?.getSerializable("user") as User
        binding.txtName.text = userName

        binding.txtUser.text = user.toString()


        binding.openFragment3.setOnClickListener {
            //2 cach
            //controller.navigate(R.id.thirdFragment)

            val action = SecondFragmentDirections.actionSecondFragmentToThirdFragment(user, address)


            controller.navigate(action)
        }


    }

    /*override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

    }*/

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}