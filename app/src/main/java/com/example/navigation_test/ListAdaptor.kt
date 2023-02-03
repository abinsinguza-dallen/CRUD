package com.example.navigation_test

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.navigation_test.Database.User
import com.example.navigation_test.databinding.CvitemRowBinding
import com.example.navigation_test.databinding.FragmentAddBinding

class ListAdaptor(var userList: List<User>,) : RecyclerView.Adapter<ListAdaptor.MyViewHolder>() {

    inner class MyViewHolder(val binding: CvitemRowBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding = CvitemRowBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return MyViewHolder(binding)
    }


    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
    with(holder) {
        with(userList[position]) {
            binding.idTxt.text = this.id.toString()
            binding.firstNameText.text = this.firstName
            binding.lastNameText.text = this.lastName
            binding.AgeText.text = this.age.toString()

        }
    }
}
        override fun getItemCount(): Int {
            return userList.size
        }
    fun setData(user: List<User>){
        this.userList=user
        notifyDataSetChanged()
    }

}