package app.isfaaghyth.visitablelist.impl.adapterdelegate.delegate

import android.view.View
import android.view.ViewGroup
import app.isfaaghyth.visitablelist.R
import app.isfaaghyth.visitablelist.entity.Advertisement
import app.isfaaghyth.visitablelist.impl.visitable.viewholder.AdvertisementViewHolder
import app.isfaaghyth.visitablelist.internal.adapterdelegate.TypedAdapterDelegate

class AdvertisementDelegate : TypedAdapterDelegate<
        Advertisement, Any, AdvertisementViewHolder>(R.layout.item_advertisement) {
    override fun onBindViewHolder(item: Advertisement, holder: AdvertisementViewHolder) {
        holder.bind(item)
    }

    override fun onCreateViewHolder(parent: ViewGroup, basicView: View): AdvertisementViewHolder {
        return AdvertisementViewHolder(basicView) // TODO: you can create a new one for viewHolder with extending the BaseViewHolder from adapter-delegate lib.
    }
}