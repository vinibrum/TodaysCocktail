package com.devventure.todayscocktail.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import com.devventure.todayscocktail.databinding.FragmentListDrinkBinding
import com.devventure.todayscocktail.presentation.adapters.DrinkAdapter
import org.koin.androidx.viewmodel.ext.android.viewModel

class ListDrinksFragment : Fragment() {
    private var _binding: FragmentListDrinkBinding? = null
    private val binding: FragmentListDrinkBinding
        get() = _binding!!

    private val viewModel: DrinkViewModel by viewModel()
    private lateinit var mAdapter: DrinkAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentListDrinkBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecyclerView()
        subscribeObservers()
    }

    private fun initRecyclerView() {
        mAdapter = DrinkAdapter()
        binding.rvDrinks.apply {
            adapter = mAdapter
        }
    }

    private fun subscribeObservers() {
        viewModel.getDrinks().observe(viewLifecycleOwner, Observer {
            mAdapter.drinkList = it
        })
    }
}
