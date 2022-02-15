package com.lopezalex.booknook.welcome

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI
import com.lopezalex.booknook.R
import com.lopezalex.booknook.databinding.WelcomeFragmentBinding

class WelcomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val binding: WelcomeFragmentBinding = DataBindingUtil.inflate(inflater, R.layout.welcome_fragment, container, false)

        binding.instructionsBtn.setOnClickListener { findNavController().navigate(WelcomeFragmentDirections.actionWelcomeDestinationToInstructionsFragment()) }

        return binding.root
    }


}