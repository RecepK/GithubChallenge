package com.github.challenge.ui.search

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import com.github.challenge.R
import com.github.challenge.ui.search.adapter.SearchListAdapter
import com.github.challenge.viewmodel.MainViewModel
import kotlinx.android.synthetic.main.search_fragment.*

class SearchFragment : Fragment() {

    private lateinit var viewModel: MainViewModel
    private val listAdapter = SearchListAdapter()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.search_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)

        initRecyclerView()
        initLiveData()
        onClicked()
        editTextControl()
    }

    private fun initRecyclerView() {
        recyclerView.apply {
            setHasFixedSize(true)
            adapter = listAdapter
        }
    }

    private fun initLiveData() {
        viewModel.repository.observe(this, Observer {
            listAdapter.list = it.items!!
            searchButton.visibility = View.VISIBLE
        })
    }

    private fun onClicked() {
        // Avatar
        listAdapter.setOnClickListenerAvatar { item ->
            val action = SearchFragmentDirections.mainFragmentToUserDetailFragment().also {
                it.item = item
            }
            findNavController().navigate(action)
        }

        // Item
        listAdapter.setOnClickListenerItem { item ->
            val action = SearchFragmentDirections.mainFragmentToRepositoryDetailFragment().also {
                it.item = item
            }
            findNavController().navigate(action)
        }
    }

    private fun editTextControl() {
        searchButton.setOnClickListener {
            viewModel.getSearchRepositories(editTextSearch.text.trim().toString())
            searchButton.visibility = View.GONE
        }
    }
}
