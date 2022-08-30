@file:Suppress("UNCHECKED_CAST", "NotifyDataSetChanged")
package app.isfaaghyth.visitablelist.internal.visitable

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import java.util.*

open class BaseListAdapter(
    private val adapterTypeFactory: AdapterTypeFactory,
    private val items: ArrayList<Visitable<Any>> = arrayListOf()
): RecyclerView.Adapter<AbstractViewHolder<Visitable<Any>>>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AbstractViewHolder<Visitable<Any>> {
        val view = inflateItem(parent, viewType)
        return adapterTypeFactory.createViewHolder(view, viewType) as AbstractViewHolder<Visitable<Any>>
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: AbstractViewHolder<Visitable<Any>>, position: Int) {
        holder.bind(items[position])
    }

    private fun inflateItem(viewGroup: ViewGroup, viewType: Int): View {
        return LayoutInflater.from(viewGroup.context).inflate(viewType, viewGroup, false)
    }

    override fun getItemViewType(position: Int): Int {
        return items[position].type(adapterTypeFactory)
    }

    fun <T : Any> addItem(items: List<Visitable<T>>) {
        this.items.addAll(items as List<Visitable<Any>>)
        notifyDataSetChanged()
    }

    fun removeItem(item: Visitable<Any>) {
        this.items.remove(item)
        notifyDataSetChanged()
    }

}