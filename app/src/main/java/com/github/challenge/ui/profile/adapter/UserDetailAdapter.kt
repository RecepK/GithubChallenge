package com.github.challenge.ui.profile.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.github.challenge.R
import com.github.challenge.model.user.UserDetailModel

class UserDetailAdapter : RecyclerView.Adapter<UserDetailViewHolder>() {

    var list: List<UserDetailModel> = ArrayList()
        set(value) {
            field = value
            this.notifyDataSetChanged()
        }

    override fun getItemViewType(position: Int): Int =
        if (position > UserViewType.HEADER) UserViewType.OTHER else UserViewType.HEADER

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserDetailViewHolder {
        val view: View = when (viewType) {
            UserViewType.HEADER -> LayoutInflater.from(parent.context)
                .inflate(R.layout.user_detail_header, parent, false)

            UserViewType.OTHER -> LayoutInflater.from(parent.context)
                .inflate(R.layout.repository_list_row, parent, false)
            else -> LayoutInflater.from(parent.context)
                .inflate(R.layout.repository_list_row, parent, false)
        }

        return UserDetailViewHolder(view)
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: UserDetailViewHolder, position: Int) {
        when (position) {
            UserViewType.HEADER -> holder.bindHeader(list[position])

            UserViewType.OTHER -> holder.bind(list[position])
            else -> holder.bind(list[position])
        }
    }

}
