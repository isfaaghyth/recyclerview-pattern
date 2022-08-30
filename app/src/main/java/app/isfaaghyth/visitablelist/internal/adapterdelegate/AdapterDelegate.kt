package app.isfaaghyth.visitablelist.internal.adapterdelegate

import android.os.Bundle
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

interface AdapterDelegate<T> {
    fun isForViewType(itemList: List<T>, position: Int, isFlexibleType: Boolean): Boolean
    fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder
    fun onBindViewHolder(itemList: List<T>, position: Int, holder: RecyclerView.ViewHolder)
    fun onBindViewHolder(itemList: List<T>, position: Int, payloads: Bundle, holder: RecyclerView.ViewHolder)
}