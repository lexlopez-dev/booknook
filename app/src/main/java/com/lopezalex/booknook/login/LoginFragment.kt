package com.lopezalex.booknook.login

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI
import com.lopezalex.booknook.R
import com.lopezalex.booknook.databinding.LoginFragmentBinding

/**
 * Fragment for the starting Login of the app
 */
class LoginFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val binding: LoginFragmentBinding = DataBindingUtil.inflate(inflater, R.layout.login_fragment, container, false)

        binding.loginBtn.setOnClickListener { findNavController().navigate(LoginFragmentDirections.actionLoginFragmentToWelcomeFragment()) }

        binding.createAccountBtn.setOnClickListener { findNavController().navigate(LoginFragmentDirections.actionLoginFragmentToWelcomeFragment()) }

        return binding.root

    }


}