package com.example.navigation_test

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.navigation_test.Database.UserViewModel
import com.example.navigation_test.databinding.FragmentListBinding
import com.google.android.material.floatingactionbutton.FloatingActionButton

class ListFragment : Fragment() {
    private var _binding:FragmentListBinding?=null
    private val binding get() = _binding!!
    private lateinit var mUserViewModel: UserViewModel
    private lateinit var navController: NavController


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding=FragmentListBinding.inflate(inflater,container,false)
        val adaptor = ListAdaptor()
        val recyclerView=binding.rvList
        recyclerView.adapter = adaptor

        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        mUserViewModel = ViewModelProvider(this).get(UserViewModel::class.java)
        mUserViewModel.readAllData.observe(viewLifecycleOwner, Observer { user ->

            adaptor.setData(user)
        })

        binding.floatingActionButton.setOnClickListener {
            navController.navigate(R.id.action_addFragment_to_listFragment)

        }


        return binding.root


    }
}



