package app.isfaaghyth.visitablelist.internal.adapterdelegate

import android.os.Bundle
import android.view.ViewGroup
import androidx.collection.SparseArrayCompat
import androidx.recyclerview.widget.RecyclerView

class AdapterDelegatesManager<T: Any>(
    private val isFlexibleType: Boolean = false
) {

    private val typedAdapterDelegatesMap: MutableMap<Class<*>, Int> = mutableMapOf()
    private val specialAdapterDelegates: MutableList<Int> by lazy { mutableListOf<Int>() }

    private val adapterDelegates: SparseArrayCompat<AdapterDelegate<T>> = SparseArrayCompat()

    /**
     * Adding delegate to the list of delegates
     * If the adapter delegate to be added is of type [TypedAdapterDelegate], it will be put in a Map
     * Other type will be added to a regular list
     * @param adapterDelegate - adapter delegate to be added
     * @return [AdapterDelegatesManager] to support chaining
     */
    fun addDelegate(adapterDelegate: AdapterDelegate<T>): AdapterDelegatesManager<T> {
        val index = adapterDelegates.size()
        if (adapterDelegate is TypedAdapterDelegate<*, *, *>) {
            typedAdapterDelegatesMap[adapterDelegate.itemClass] = index
        } else {
            specialAdapterDelegates.add(index)
        }
        adapterDelegates.put(index, adapterDelegate)
        return this
    }

    fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return adapterDelegates[viewType]?.onCreateViewHolder(parent, viewType) ?: throw IllegalStateException("viewType is defined, but does not exist on adapter delegates")
    }

    fun getItemViewType(itemList: List<T>, position: Int): Int {
        return adapterDelegates.indexOfValue(getAdapterDelegate(itemList, position))
    }

    fun onBindViewHolder(itemList: List<T>, position: Int, holder: RecyclerView.ViewHolder) {
        return getAdapterDelegate(itemList, position).onBindViewHolder(itemList, position, holder)
    }

    fun onBindViewHolder(itemList: List<T>, position: Int, holder: RecyclerView.ViewHolder, payloads: Bundle) {
        return getAdapterDelegate(itemList, position).onBindViewHolder(itemList, position, payloads, holder)
    }

    private fun getAdapterDelegate(itemList: List<T>, position: Int): AdapterDelegate<T> {
        val item = itemList[position]
        val itemClass = item::class.java

        if (typedAdapterDelegatesMap.containsKey(itemClass)) {
            return adapterDelegates[typedAdapterDelegatesMap[itemClass]!!] ?: throw IllegalStateException("Index of adapter delegates found but does not exist in adapter delegate list")
        }
        else {
            specialAdapterDelegates.forEach { delegateIndex ->
                val adapterDelegate = adapterDelegates[delegateIndex]
                if (adapterDelegate?.isForViewType(itemList, position, isFlexibleType) == true) return adapterDelegate
            }
        }

        if (isFlexibleType) {
            for (index in 0 until adapterDelegates.size()) {
                val adapterDelegate = adapterDelegates[index]
                if (adapterDelegate?.isForViewType(itemList, position, isFlexibleType) == true) return adapterDelegate
            }
        }

        throw IllegalArgumentException("No delegate is found for item: $item with type: $itemClass on position: $position")
    }
}