package app.isfaaghyth.visitablelist.entity

import app.isfaaghyth.visitablelist.impl.visitable.factory.ItemTypeFactory
import app.isfaaghyth.visitablelist.internal.visitable.Visitable

data class Advertisement(
    val title: String,
    val subtitle: String
) : Visitable<ItemTypeFactory> /* TODO: you can remove this interface when adopting the adapter delegate */ {

    override fun type(typeFactory: ItemTypeFactory): Int {
        return typeFactory.type(this)
    }

}