package com.bs.bs_test

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.bs.bs_test.model.SingleOwner
import com.bs.bs_test.utils.dateUtils
import com.bs.bs_test.viewmodels.MainViewModel
import com.squareup.picasso.Picasso
import de.hdodenhof.circleimageview.CircleImageView

class DetailsFragment : Fragment() {
    lateinit var url:String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
            url = requireArguments().getString("url")!!
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view =inflater.inflate(R.layout.fragment_details, container, false)
        initViewModel(view)
        return view
    }

    private fun initViewModel(view: View) {
        val viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        viewModel.getSingleOwnerObserver().observe(viewLifecycleOwner, Observer<SingleOwner> {
            if (it!=null){
                val avatar = view.findViewById<CircleImageView>(R.id.avatar)
                val tvname = view.findViewById<TextView>(R.id.tvname)
                val tvbio = view.findViewById<TextView>(R.id.tvbio)
                val tvFollow = view.findViewById<TextView>(R.id.tvFollow)
                val tvCompany = view.findViewById<TextView>(R.id.tvCompany)
                val tvLocation = view.findViewById<TextView>(R.id.tvLocation)

                val tvBlog = view.findViewById<TextView>(R.id.tvBlog)
                val tvLastUpdated = view.findViewById<TextView>(R.id.tvLastUpdated)
                val url = it.avatar_url
                Picasso.get().load(url).into(avatar)
                tvname.text = it.name
                tvbio.text = it.bio
                tvFollow.text = "${it.followers} followers . ${it.following} following"
                tvCompany.text = it.company?.toString()

                tvBlog.text = it.blog
                tvLocation.text = it.location.toString()
                val updateTime = dateUtils().getCustomDate(it.updated_at)
                tvLastUpdated.text= "Updated  ${updateTime}"
            }
            else{
                Toast.makeText(activity,"Error",Toast.LENGTH_SHORT).show()
            }
        })
        viewModel.makeSingleOwnerApiCall(url)
    }
}