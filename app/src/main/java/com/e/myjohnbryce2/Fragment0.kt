package com.e.myjohnbryce2

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.lifecycle.Observer

class Fragment0 : Fragment() {

    companion object {
        fun newInstance() = Fragment0()
    }

    private lateinit var viewModel: Fragment0ViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment0_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(Fragment0ViewModel::class.java)
        // TODO: Use the ViewModel

        viewModel.countries.observe(viewLifecycleOwner, Observer {
           var a = it
        })
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<View>(R.id.add_country).setOnClickListener(View.OnClickListener {
            viewModel.add("Israel", "Jerusalem")
        })


    }

}