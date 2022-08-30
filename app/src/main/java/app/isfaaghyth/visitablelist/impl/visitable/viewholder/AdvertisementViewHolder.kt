package app.isfaaghyth.visitablelist.impl.visitable.viewholder

import android.view.View
import androidx.annotation.LayoutRes
import app.isfaaghyth.visitablelist.R
import app.isfaaghyth.visitablelist.internal.visitable.AbstractViewHolder
import app.isfaaghyth.visitablelist.entity.Advertisement
import kotlinx.android.synthetic.main.item_ad_banner.view.*

class AdvertisementViewHolder(view: View): AbstractViewHolder<Advertisement>(view) {

    private val txtTitle = view.txtTitle
    private val txtSubTitle = view.txtSubTitle

    override fun bind(element: Advertisement) {
        txtTitle.text = element.title
        txtSubTitle.text = element.description
    }

    companion object {
        @LayoutRes val LAYOUT = R.layout.item_ad_banner
    }

}