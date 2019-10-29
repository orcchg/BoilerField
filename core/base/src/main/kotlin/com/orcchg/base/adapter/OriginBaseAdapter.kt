package com.orcchg.base.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes

abstract class OriginBaseAdapter<T : IListModel, VH : BaseViewHolder<T>>(diffCb: BaseDiffCallback<T>)
    : BaseAdapter<T, VH>(diffCb) {

    @LayoutRes protected abstract fun getLayoutId(): Int
    protected abstract fun instantiateViewHolder(view: View): VH

    // --------------------------------------------------------------------------------------------
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        val view = LayoutInflater.from(parent.context).inflate(getLayoutId(), parent, false)
        return instantiateViewHolder(view)
    }
}
