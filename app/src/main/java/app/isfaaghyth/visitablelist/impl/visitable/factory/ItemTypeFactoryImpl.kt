package app.isfaaghyth.visitablelist.impl.visitable.factory

import android.view.View
import app.isfaaghyth.visitablelist.entity.ProductHighLight
import app.isfaaghyth.visitablelist.entity.ShortcutMenu
import app.isfaaghyth.visitablelist.impl.visitable.viewholder.ProductHighLightViewHolder
import app.isfaaghyth.visitablelist.impl.visitable.viewholder.ShortcutMenuViewHolder
import app.isfaaghyth.visitablelist.internal.visitable.AbstractViewHolder

class ItemTypeFactoryImpl: ItemTypeFactory {

    override fun type(factory: ShortcutMenu): Int = ShortcutMenuViewHolder.LAYOUT

    override fun type(factory: ProductHighLight): Int = ProductHighLightViewHolder.LAYOUT

    override fun createViewHolder(parent: View, type: Int): AbstractViewHolder<*> {
        return when(type) {
            ProductHighLightViewHolder.LAYOUT -> ProductHighLightViewHolder(parent)
            ShortcutMenuViewHolder.LAYOUT -> ShortcutMenuViewHolder(parent)
            else -> createViewHolder(parent, type)
        }
    }

}