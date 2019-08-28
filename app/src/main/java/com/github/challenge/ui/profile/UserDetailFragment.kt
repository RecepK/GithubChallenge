package com.github.challenge.ui.profile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.github.challenge.R
import com.github.challenge.model.repositories.Item
import com.github.challenge.model.repositories.User
import com.github.challenge.model.user.UserDetailModel
import com.github.challenge.ui.profile.adapter.UserDetailAdapter
import com.github.challenge.viewmodel.MainViewModel
import kotlinx.android.synthetic.main.search_fragment.*

class UserDetailFragment : Fragment() {

    private val item: Item? by lazy {
        arguments?.let {
            UserDetailFragmentArgs.fromBundle(it).item
        }
    }

    private lateinit var viewModel: MainViewModel
    private var listAdapter = UserDetailAdapter()

    private val modelList = ArrayList<UserDetailModel>()
    private lateinit var user: User
    private lateinit var mList: List<Item>

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.user_detail_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)

        initRecyclerView()
        initLiveData()
        setUI()
    }

    private fun initRecyclerView() {
        recyclerView.apply {
            setHasFixedSize(true)
            adapter = listAdapter
        }
    }

    private fun setUI() {
        val userName = item!!.owner.login
        if (userName != null) {
            viewModel.getUserProfile(userName)
            viewModel.getUserRepositories(userName)
        }
    }

    private fun initLiveData() {
        // header
        viewModel.profile.observe(this, Observer {
            user = it
        })

        // repositories
        viewModel.repoList.observe(this, Observer {
            mList = it

            modelList.add(UserDetailModel(user, null))
            for (item: Item in it) {
                modelList.add(UserDetailModel(user, item))
            }

            listAdapter.list = modelList
        })
    }
}