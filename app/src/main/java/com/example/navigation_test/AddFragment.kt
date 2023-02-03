package com.example.navigation_test

import android.os.Bundle
import android.text.Editable
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.example.navigation_test.Database.User
import com.example.navigation_test.Database.UserViewModel
import com.example.navigation_test.databinding.FragmentAddBinding
import com.example.navigation_test.databinding.FragmentListBinding


class AddFragment : Fragment() {
    private lateinit var mUserViewModel:UserViewModel
    private var _binding: FragmentAddBinding?=null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding= FragmentAddBinding.inflate(inflater,container,false)
        mUserViewModel=ViewModelProvider(this).get(UserViewModel::class.java)
       binding.btnAdd.setOnClickListener {
            insertDataToDatabase()
        }

        return binding.root    }

    private fun insertDataToDatabase() {
        val firstname=binding.etfirstName.text.toString()
        val lastName=binding.etlastName.text.toString()
        val age=binding.etAge.text
        if (inputCheck(firstname, lastName,age )){
            val user =User(0,firstname,lastName, Integer.parseInt(age.toString()))
            mUserViewModel.addUser(user)
            Toast.makeText(requireContext(),"successfully added", Toast.LENGTH_SHORT).show()
       findNavController().navigate(R.id.action_addFragment_to_listFragment)
        }else{
            Toast.makeText(requireContext(),"plz fill out the fields", Toast.LENGTH_SHORT).show()

        }
    }
    private fun inputCheck(firstname:String, lastName:String, age: Editable):Boolean{
        return !(TextUtils.isEmpty(firstname)&& TextUtils.isEmpty(lastName)&& age.isEmpty())
    }

}
