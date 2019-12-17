package app.isfaaghyth.visitablelist.factory

import android.view.View
import app.isfaaghyth.visitablelist.base.AbstractViewHolder
import app.isfaaghyth.visitablelist.entity.OverviewMenu
import app.isfaaghyth.visitablelist.viewholder.OverviewMenuViewHolder

class ItemTypeFactoryImpl: ItemTypeFactory {

    override fun type(typeFactory: OverviewMenu): Int = OverviewMenuViewHolder.LAYOUT

    override fun createViewHolder(parent: View, type: Int): AbstractViewHolder<*> {
        return when(type) {
            OverviewMenuViewHolder.LAYOUT -> OverviewMenuViewHolder(parent)
            else -> createViewHolder(parent, type)
        }
    }

}