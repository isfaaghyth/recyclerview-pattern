package app.isfaaghyth.visitablelist.factory

import android.view.View
import app.isfaaghyth.visitablelist.base.AbstractViewHolder
import app.isfaaghyth.visitablelist.entity.AdBanner
import app.isfaaghyth.visitablelist.entity.HighLightData
import app.isfaaghyth.visitablelist.entity.OverviewMenu
import app.isfaaghyth.visitablelist.viewholder.AdBannerViewHolder
import app.isfaaghyth.visitablelist.viewholder.HighLightDataViewHolder
import app.isfaaghyth.visitablelist.viewholder.OverviewMenuViewHolder

class ItemTypeFactoryImpl: ItemTypeFactory {

    override fun type(typeFactory: OverviewMenu): Int = OverviewMenuViewHolder.LAYOUT

    override fun type(typeFactory: AdBanner): Int = AdBannerViewHolder.LAYOUT

    override fun type(typeFactory: HighLightData): Int = HighLightDataViewHolder.LAYOUT

    override fun createViewHolder(parent: View, type: Int): AbstractViewHolder<*> {
        return when(type) {
            HighLightDataViewHolder.LAYOUT -> HighLightDataViewHolder(parent)
            OverviewMenuViewHolder.LAYOUT -> OverviewMenuViewHolder(parent)
            AdBannerViewHolder.LAYOUT -> AdBannerViewHolder(parent)
            else -> createViewHolder(parent, type)
        }
    }

}