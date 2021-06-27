package com.devventure.todayscocktail.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import com.bumptech.glide.Glide
import com.devventure.todayscocktail.data.model.DrinkDetail
import com.devventure.todayscocktail.databinding.FragmentDetailDrinkBinding
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

class DetailDrinkFragment : Fragment() {
    private var _binding: FragmentDetailDrinkBinding? = null
    private val binding: FragmentDetailDrinkBinding
        get() = _binding!!

    private lateinit var drinkDetail: DrinkDetail
    private val viewModel: DrinkViewModel by sharedViewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDetailDrinkBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        subscribeObservers()
    }

    private fun subscribeObservers() {
        /**
         * O retorno da API é um JSONArray com apenas um JSONObject, selecionamos então apenas os dados
         * do primeiro elemento são recuperados
         */
        viewModel.drinkDetails.observe(viewLifecycleOwner, Observer {
            drinkDetail = it[0]
            setDrinkDetailsToView()
        })
    }

    private fun setDrinkDetailsToView() {
        Glide.with(requireContext()).load(drinkDetail.strDrinkThumb).into(binding.tvDrinkImage)
        binding.tvDrinkTitle.text = drinkDetail.strDrink
    }
}