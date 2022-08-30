package app.isfaaghyth.visitablelist.internal.adapterdelegate

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.recyclerview.widget.RecyclerView

abstract class BaseAdapterDelegate<T: ST, ST: Any, VH : RecyclerView.ViewHolder>(@LayoutRes private val layoutRes: Int) : AdapterDelegate<ST> {

    abstract fun onBindViewHolder(item: T, holder: VH)

    open fun onBindViewHolderWithPayloads(item: T, holder: VH, payloads: Bundle) {
        onBindViewHolder(item, holder)
    }

    abstract fun onCreateViewHolder(parent: ViewGroup, basicView: View): VH

    @Suppress("UNCHECKED_CAST")
    override fun onBindViewHolder(itemList: List<ST>, position: Int, holder: RecyclerView.ViewHolder) {
        onBindViewHolder(itemList[position] as T, holder as VH)
    }

    @Suppress("UNCHECKED_CAST")
    override fun onBindViewHolder(itemList: List<ST>, position: Int, payloads: Bundle, holder: RecyclerView.ViewHolder) {
        onBindViewHolderWithPayloads(itemList[position] as T, holder as VH, payloads)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return onCreateViewHolder(parent, getView(parent, layoutRes))
    }
}

@Suppress("unused")
fun <T> AdapterDelegate<T>.getView(
    parent: ViewGroup,
    @LayoutRes layoutRes: Int
): View = LayoutInflater.from(parent.context).inflate(layoutRes, parent, false)