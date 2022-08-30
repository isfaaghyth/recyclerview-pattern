package app.isfaaghyth.visitablelist.internal.adapterdelegate

import android.os.Bundle
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

abstract class BaseAdapter<T: Any>(isFlexibleType: Boolean = false) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    protected val delegatesManager = AdapterDelegatesManager<T>(isFlexibleType)
    protected val itemList: MutableList<T> = mutableListOf()

    @Deprecated(
        message = "Use getItems() instead",
        replaceWith = ReplaceWith("getItems()"),
        level = DeprecationLevel.WARNING
    )
    val data: List<T>
        get() = itemList

    val firstIndex: Int
        get() = if (itemList.isNotEmpty()) 0 else -1

    val lastIndex: Int
        get() = itemList.size - 1

    override fun onCreateViewHolder(parent: ViewGroup, position: Int): RecyclerView.ViewHolder {
        return delegatesManager.onCreateViewHolder(parent, position)
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    override fun getItemViewType(position: Int): Int {
        return delegatesManager.getItemViewType(itemList, position)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        delegatesManager.onBindViewHolder(itemList, position, holder)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int, payloads: List<Any>) {
        if (payloads.isEmpty()) onBindViewHolder(holder, position)
        else delegatesManager.onBindViewHolder(itemList, position, holder, payloads = payloads.filterIsInstance<Bundle>().reduce {
                acc, bundle -> acc.apply { putAll(bundle) }
        })
    }

    override fun onViewRecycled(holder: RecyclerView.ViewHolder) {
        super.onViewRecycled(holder)
        if (holder is BaseViewHolder) { holder.onViewRecycled() }
    }

    /**
     * @return whole lists of item
     */
    fun getItems(): List<T> = itemList

    /**
     * @param position - the position of the item
     * @return the item in the list at the specified position
     */
    fun getItem(position: Int): T = itemList[position]

    /**
     * Overwrite the current item list with the new one
     * @param itemList - the new list of item
     */
    fun setItems(itemList: List<T>) {
        this.itemList.clear()
        addItems(itemList)
    }

    /**
     * Add list of items to current item list
     * @param itemList - the list of item to be added
     */
    fun addItems(itemList: List<T>) {
        this.itemList.addAll(itemList)
    }

    /**
     * Insert an item to the last position of current item list
     * @param item - the item to be inserted
     */
    fun addItem(item: T) {
        this.itemList.add(item)
    }

    /**
     * Add an item to specified position of current item list
     * @param position - the position to where the item will be inserted
     * @param item - the item to be inserted
     */
    fun addItem(position: Int, item: T) {
        this.itemList.add(position, item)
    }

    /**
     * Remove specified item from the current item list
     * @param item - the item to be removed
     */
    fun removeItem(item: T) {
        this.itemList.remove(item)
    }

    /**
     * Remove the item at specified position from the current item list
     * @param position - the position of item to be removed
     */
    fun removeItemAt(position: Int) {
        this.itemList.removeAt(position)
    }

    /**
     * Clear all items from current item list
     */
    fun clearAllItems() {
        this.itemList.clear()
    }
}