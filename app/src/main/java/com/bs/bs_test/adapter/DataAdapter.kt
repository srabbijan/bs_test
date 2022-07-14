package com.bs.bs_test.adapter

import android.annotation.SuppressLint
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bs.bs_test.R
import com.bs.bs_test.model.Item
import com.bs.bs_test.utils.dateUtils

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.bs.bs_test.DetailsFragment
import com.bs.bs_test.HomeFragment
import androidx.appcompat.app.AppCompatActivity
import androidx.core.os.bundleOf
import androidx.navigation.NavController
import androidx.navigation.Navigation


class DataAdapter :RecyclerView.Adapter<DataAdapter.DataHolder>(){
    var items = ArrayList<Item>()
    fun setUpdatedData(items: ArrayList<Item>){
        this.items = items
        notifyDataSetChanged()
    }
    class DataHolder(view: View):RecyclerView.ViewHolder(view) {
        val tvfull_name = view.findViewById<TextView>(R.id.tvfull_name)
        val tvUpdatedDate = view.findViewById<TextView>(R.id.tvUpdatedDate)
        val tvTDes = view.findViewById<TextView>(R.id.tvTDes)
        val tvLanguage = view.findViewById<TextView>(R.id.tvLanguage)
        val tvwatchers = view.findViewById<TextView>(R.id.tvwatchers)
        val tvForksCount = view.findViewById<TextView>(R.id.tvForksCount)
        val tvStargazersCount = view.findViewById<TextView>(R.id.tvStargazersCount)
        val tvOpen_issues_count = view.findViewById<TextView>(R.id.tvOpen_issues_count)
        @SuppressLint("SetTextI18n")
        fun bind(data:Item){
            tvfull_name.text = data.full_name
            tvUpdatedDate.text = "Updated on ${dateUtils().getCustomDate(data.updated_at)}"
            tvTDes.text = data.description
            tvLanguage.text = data.language
            tvwatchers.text = data.watchers_count.toString()
            tvForksCount.text = data.forks_count.toString()
            tvStargazersCount.text = data.stargazers_count.toString()
            tvOpen_issues_count.text = data.open_issues_count.toString()
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataHolder {
        val view=LayoutInflater.from(parent.context).inflate(R.layout.list_row,parent,false)
    return DataHolder(view)
    }
    override fun onBindViewHolder(holder: DataHolder, @SuppressLint("RecyclerView") position: Int) {
        holder.bind(items.get(position))
        holder.itemView.setOnClickListener(object : View.OnClickListener {
            override fun onClick(p0: View?) {
                var navController:NavController?=null
                navController = p0?.let { Navigation.findNavController(it) }
                val bundle = bundleOf("url" to items.get(position).owner.login)
                navController?.navigate(R.id.action_homeFragment_to_detailsFragment,bundle)
            }
        })
    }
    override fun getItemCount(): Int {
       return items.size
    }
}