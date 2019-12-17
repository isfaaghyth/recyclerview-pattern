package app.isfaaghyth.visitablelist.viewholder

import android.view.View
import app.isfaaghyth.visitablelist.R
import app.isfaaghyth.visitablelist.base.AbstractViewHolder
import app.isfaaghyth.visitablelist.entity.AdBanner
import kotlinx.android.synthetic.main.item_ad_banner.view.*

class AdBannerViewHolder(view: View): AbstractViewHolder<AdBanner>(view) {

    private val txtTitle = view.txtTitle
    private val txtSubTitle = view.txtSubTitle

    override fun bind(element: AdBanner) {
        txtTitle.text = element.title
        txtSubTitle.text = element.description
    }

    companion object {
        val LAYOUT = R.layout.item_ad_banner
    }

}