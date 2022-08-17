package com.muhmmad.shoppingapp.ui.fragment.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.muhmmad.shoppingapp.adapter.ProductsAdapter
import com.muhmmad.shoppingapp.databinding.FragmentHomeBinding
import com.muhmmad.shoppingapp.ui.activity.login.LoginActivity.Companion.name
import com.muhmmad.shoppingapp.ui.activity.login.LoginActivity.Companion.token


class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding
    private lateinit var viewModel: HomeViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        viewModel = ViewModelProvider(this)[HomeViewModel::class.java]

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {
            viewModel.getPosts(binding.root.context, token.toString())
            tvHi.text = "${tvHi.text} $name"
        }

        viewModel.posts.observe(viewLifecycleOwner) {
            if (it != null) {
                binding.rvProducts.adapter = ProductsAdapter(it)
            }
        }
    }

}