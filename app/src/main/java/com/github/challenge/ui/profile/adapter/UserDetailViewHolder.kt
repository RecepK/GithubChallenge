package com.github.challenge.ui.profile.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.github.challenge.model.user.UserDetailModel
import kotlinx.android.synthetic.main.repository_list_row.view.*
import kotlinx.android.synthetic.main.user_detail_header.view.*

class UserDetailViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun bindHeader(profile: UserDetailModel) {
        Glide.with(itemView.context).load(profile.user!!.avatarUrl).into(itemView.imgAvatarUser)
        itemView.tvName.text = "Name: " + profile.user.name
        itemView.tvUsername.text = "User Name: " + profile.user.login
        itemView.tvEmail.text = "Email: " + profile.user.email
        itemView.tvCompany.text = "Company: " + profile.user.company
        itemView.tvLocation.text = "Location: " + profile.user.location
    }

    fun bind(model: UserDetailModel) {
        Glide.with(itemView.context).load(model.user!!.avatarUrl).into(itemView.imgRepositoryAvatar)
        itemView.tvRepositoryUsername.text  = "Repository Name: " + model.repositories?.name
        itemView.tvRepositoryRepositoryName.text = "Description: " + model.repositories?.description
    }
}
