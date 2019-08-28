package com.github.challenge.ui.search.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.github.challenge.model.repositories.Item
import kotlinx.android.synthetic.main.repository_list_row.view.*

class SearchViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun bin(
        item: Item,
        onClickListenerAvatar: ((Item) -> Unit)?,
        onClickListenerItem: ((Item) -> Unit)?
    ) {
        // set UI
        Glide.with(itemView.context).load(item.owner.avatarUrl).into(itemView.imgRepositoryAvatar)

        val userName = item.owner.login
        itemView.tvRepositoryUsername.text = "User Name: $userName"

        val repositoryName = item.owner.login
        itemView.tvRepositoryRepositoryName.text = "Repository Name: $repositoryName"

        // click Listeners
        itemView.imgRepositoryAvatar.setOnClickListener { onClickListenerAvatar?.invoke(item) }
        itemView.rootView.setOnClickListener { onClickListenerItem?.invoke(item) }
    }
}