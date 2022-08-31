package app.isfaaghyth.visitablelist.impl.visitable.viewholder

import android.view.View
import androidx.annotation.LayoutRes
import app.isfaaghyth.visitablelist.R
import app.isfaaghyth.visitablelist.entity.Advertisement
import app.isfaaghyth.visitablelist.internal.visitable.AbstractViewHolder
import kotlinx.android.synthetic.main.item_advertisement.view.*

class AdvertisementViewHolder(view: View) : AbstractViewHolder<Advertisement>(view) {

    private val txtTitle = view.txtTitle
    private val txtSubtitle = view.txtSubTitle

    override fun bind(element: Advertisement) {
        txtTitle.text = element.title
        txtSubtitle.text = element.subtitle
    }

    companion object {
        @LayoutRes val LAYOUT = R.layout.item_advertisement
    }

}