package com.github.challenge.ui.search.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.github.challenge.R
import com.github.challenge.model.repositories.Item

class SearchListAdapter : RecyclerView.Adapter<SearchViewHolder>() {

    var list: List<Item> = ArrayList()
        set(value) {
            field = value
            this.notifyDataSetChanged()
        }

    private var onClickListenerAvatar: ((Item?) -> Unit)? = null
    private var onClickListenerItem: ((Item?) -> Unit)? = null

    fun setOnClickListenerAvatar(onClickListenerAvatar: ((Item?) -> Unit)?) {
        this.onClickListenerAvatar = onClickListenerAvatar
    }

    fun setOnClickListenerItem(onClickListenerItem: ((Item?) -> Unit)?) {
        this.onClickListenerItem = onClickListenerItem
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.repository_list_row, parent, false)
        return SearchViewHolder(view)
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holderSearch: SearchViewHolder, position: Int) {
        holderSearch.bin(list[position], onClickListenerAvatar, onClickListenerItem)
    }
}