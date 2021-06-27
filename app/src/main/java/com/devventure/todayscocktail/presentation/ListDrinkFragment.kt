package com.devventure.todayscocktail.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.devventure.todayscocktail.R
import com.devventure.todayscocktail.data.model.Drink
import com.devventure.todayscocktail.databinding.FragmentListDrinkBinding
import com.devventure.todayscocktail.presentation.adapters.DrinkAdapter
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

class ListDrinksFragment : Fragment(), DrinkAdapter.Interaction {
    private var _binding: FragmentListDrinkBinding? = null
    private val binding: FragmentListDrinkBinding
        get() = _binding!!

    private val viewModel: DrinkViewModel by sharedViewModel()
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
        mAdapter = DrinkAdapter(this)
        binding.rvDrinks.apply {
            adapter = mAdapter
        }
    }

    private fun subscribeObservers() {
        viewModel.getDrinks().observe(viewLifecycleOwner, Observer {
            mAdapter.drinkList = it
        })
    }

    override fun onItemSelected(item: Drink) {
        viewModel.setSelectedDrink(item)
        findNavController().navigate(R.id.action_listDrinksFragment_to_newDrinkFragment)
    }
}
