package app.isfaaghyth.visitablelist.factory

import android.view.View
import app.isfaaghyth.visitablelist.base.AbstractViewHolder

interface ItemTypeFactory {
    fun createViewHolder(parent: View, type: Int): AbstractViewHolder<*>
}