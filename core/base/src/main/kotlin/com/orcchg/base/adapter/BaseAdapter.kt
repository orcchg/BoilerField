package com.orcchg.base.adapter

import androidx.recyclerview.widget.AdapterListUpdateCallback
import androidx.recyclerview.widget.AsyncDifferConfig
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.RecyclerView

abstract class BaseAdapter<T : IListModel, VH : BaseViewHolder<T>>(protected val diffCb: BaseDiffCallback<T>)
    : RecyclerView.Adapter<VH>() {

    init {
        setHasStableIds(true)
    }

    private val helper by lazy {
        AsyncListDiffer<T>(AdapterListUpdateCallback(this), AsyncDifferConfig.Builder(diffCb).build())
    }

    // --------------------------------------------------------------------------------------------
    override fun onBindViewHolder(holder: VH, position: Int) {
        holder.bind(getItem(position))
    }

    override fun onBindViewHolder(holder: VH, position: Int, payloads: List<Any>) {
        payloads
            .takeIf { !it.isEmpty() }
            ?.let { holder.bind(getItem(position), payloads) }
            ?: run { holder.bind(getItem(position)) }
    }

    private fun getItem(position: Int): T = helper.currentList[position]

    override fun getItemCount(): Int = helper.currentList.size

    override fun getItemId(position: Int): Long = getItem(position).id

    // --------------------------------------------------------------------------------------------
    fun append(list: List<T>?) {
        if (!list.isNullOrEmpty()) {
            helper.submitList(mutableListOf<T>().apply { addAll(helper.currentList) }.also { it.addAll(list) })
        }
    }
}
