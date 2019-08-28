package com.github.challenge.ui.repository

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.github.challenge.R
import com.github.challenge.model.repositories.Item
import kotlinx.android.synthetic.main.repository_detail.*

class RepositoryDetailFragment : Fragment() {

    private val item: Item? by lazy {
        arguments?.let {
            RepositoryDetailFragmentArgs.fromBundle(it).item
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.repository_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setUI()
        setClickListener()
    }

    private fun setUI() {
        Glide.with(this).load(item!!.owner.avatarUrl).into(imgRepositoryDetailAvatar)
        tvRepositoryName.text = "Repository Name: " + item!!.name
        tvUserName.text = "User Name: " + item!!.owner.login
        tvForkCount.text = "Fork Count: " + item!!.forksCount.toString()
        tvLanguage.text = "Language: " + item!!.language
        tvDefaultBranch.text = "Default Branch: " + item!!.defaultBranch
    }

    private fun setClickListener() {
        imgRepositoryDetailAvatar.setOnClickListener {
            val action =
                RepositoryDetailFragmentDirections.repositoryDetailFragmentToUserDetailFragment()
                    .also {
                        it.item = item
                    }
            findNavController().navigate(action)
        }
    }
}