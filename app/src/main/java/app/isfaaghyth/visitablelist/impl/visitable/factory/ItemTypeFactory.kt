package app.isfaaghyth.visitablelist.impl.visitable.factory

import app.isfaaghyth.visitablelist.internal.visitable.AdapterTypeFactory
import app.isfaaghyth.visitablelist.entity.ProductHighLight
import app.isfaaghyth.visitablelist.entity.ShortcutMenu

interface ItemTypeFactory : AdapterTypeFactory {
    fun type(factory: ShortcutMenu): Int
    fun type(factory: ProductHighLight): Int
}