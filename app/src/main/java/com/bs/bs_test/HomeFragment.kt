package com.bs.bs_test

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bs.bs_test.adapter.DataAdapter
import com.bs.bs_test.model.DataModels
import com.bs.bs_test.viewmodels.MainViewModel
import com.google.android.material.snackbar.Snackbar


class HomeFragment : Fragment() {
    private var searchView: SearchView? = null
    private var searchBtn: ImageView? = null
    private lateinit var adapter : DataAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_home, container, false)
        initViewModel(view)
        initViewModel()
        return view
    }

    private fun initViewModel(view: View?) {
      val recyclerView= view?.findViewById<RecyclerView>(R.id.recycler)
        recyclerView?.layoutManager = LinearLayoutManager(activity)
        val decoration = DividerItemDecoration(activity,DividerItemDecoration.VERTICAL)
        recyclerView?.addItemDecoration(decoration)
        adapter = DataAdapter()
        recyclerView?.adapter = adapter

        searchView = view?.findViewById<SearchView>(R.id.search_view_id)
        searchBtn = view?.findViewById<ImageView>(R.id.search_hit_img_id)
        searchView?.setOnClickListener(object : View.OnClickListener {
            override fun onClick(p0: View?) {
                searchView?.onActionViewExpanded()
            }
        })

        searchBtn!!.setOnClickListener { view ->
            val newText = searchView!!.query.toString()
            if (newText.isEmpty()) {
                Snackbar.make(view, "Query is not Empty", Snackbar.LENGTH_SHORT
                ).show()
            } else {
                searchView!!.setQuery("",false)
                val viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
                viewModel.makeApiCall(newText,"stargazers")
            }
        }
    }
    private fun initViewModel(){

    val viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
    viewModel.getListObserver().observe(viewLifecycleOwner, Observer<DataModels> {
        if (it!=null){
            adapter.setUpdatedData(it.items)
        }
        else{
            Toast.makeText(activity,"Error",Toast.LENGTH_SHORT)
        }
    })
    viewModel.makeApiCall("Android","stargazers")
}

}