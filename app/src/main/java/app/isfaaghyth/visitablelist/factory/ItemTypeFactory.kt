package app.isfaaghyth.visitablelist.factory

import android.view.View
import app.isfaaghyth.visitablelist.base.AbstractViewHolder
import app.isfaaghyth.visitablelist.entity.OverviewMenu

interface ItemTypeFactory {
    fun type(typeFactory: OverviewMenu): Int

    fun createViewHolder(parent: View, type: Int): AbstractViewHolder<*>
}