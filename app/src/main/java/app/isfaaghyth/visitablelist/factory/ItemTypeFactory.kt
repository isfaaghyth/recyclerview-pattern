package app.isfaaghyth.visitablelist.factory

import android.view.View
import app.isfaaghyth.visitablelist.base.AbstractViewHolder
import app.isfaaghyth.visitablelist.entity.AdBanner
import app.isfaaghyth.visitablelist.entity.OverviewMenu

interface ItemTypeFactory {
    fun type(typeFactory: OverviewMenu): Int
    fun type(typeFactory: AdBanner): Int

    fun createViewHolder(parent: View, type: Int): AbstractViewHolder<*>
}