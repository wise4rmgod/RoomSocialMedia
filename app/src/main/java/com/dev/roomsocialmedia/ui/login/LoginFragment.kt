package com.dev.roomsocialmedia.ui.login

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.dev.roomsocialmedia.R
import com.dev.roomsocialmedia.databinding.FragmentLoginBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_login.*


@AndroidEntryPoint
class LoginFragment : Fragment() {
    val loginViewModel: LoginViewModel by viewModels()
    lateinit var loginBinding: FragmentLoginBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        //  loginBinding.lifecycleOwner = this

        loginBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_login, container, false)

        loginBinding.lifecycleOwner = this
        loginBinding.login = loginViewModel

        loginBinding.noAccount.setOnClickListener {

        }

        // check the status of post request
        loginViewModel.status.observe(viewLifecycleOwner, Observer {
            when (it) {
                true -> Toast.makeText(activity, "success", Toast.LENGTH_SHORT).show()
                false -> Toast.makeText(activity, "not success", Toast.LENGTH_SHORT).show()
                else -> Toast.makeText(activity, "not available", Toast.LENGTH_SHORT).show()
            }
        })


        /**  loginBinding.loginbtn.setOnClickListener {

        loginViewModel.login()
        //  val action = LoginFragmentDirections.actionLoginFragmentToDashboardFragment()
        // findNavController().navigate(action)
        } **/

        loginBinding.gotoReg.setOnClickListener {
            val action = LoginFragmentDirections.actionLoginFragmentToRegFragment()
            findNavController().navigate(action)
        }

        loginBinding.forgotPassword.setOnClickListener {
            val action = LoginFragmentDirections.actionLoginFragmentToForgotPasswordFragment()
            findNavController().navigate(action)
        }

        return loginBinding.root
    }


}