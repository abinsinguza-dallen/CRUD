package com.example.navigation_test

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.navigation.NavArgs
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.navigation_test.databinding.FragmentListBinding
import com.example.navigation_test.databinding.FragmentUpdateBinding


class UpdateFragment : Fragment() {
    private val args by navArgs<NavArgs>()
//    private  lateinit var Update_firstName:TextView
//    private  lateinit var Update_:Button
    private var _binding: FragmentListBinding?=null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding=FragmentListBinding.inflate(inflater,container,false)

        return binding.root
    }


   
}