package com.dev.roomsocialmedia.ui.register

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.dev.roomsocialmedia.R
import com.dev.roomsocialmedia.databinding.FragmentRegBinding
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class RegFragment : Fragment() {
    private val regViewModel: RegViewModel by viewModels()
    lateinit var regBinding: FragmentRegBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        regBinding = FragmentRegBinding.inflate(inflater, container, false)
        // DataBindingUtil.inflate(inflater, R.layout.fragment_reg, container, false)

        regBinding.lifecycleOwner = this
        regBinding.register = regViewModel

        regViewModel.status.observe(viewLifecycleOwner, Observer {
            if (it == true) Toast.makeText(activity, "success", Toast.LENGTH_SHORT).show()
            else Toast.makeText(activity, "not success", Toast.LENGTH_SHORT).show()
        })

        regViewModel.firstTodo.observe(viewLifecycleOwner, Observer {
            it
        })


        return regBinding.root

    }

}