package app.isfaaghyth.visitablelist.internal.visitable

import android.view.View

interface AdapterTypeFactory {
    fun createViewHolder(parent: View, type: Int): AbstractViewHolder<*>
}