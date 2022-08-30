package app.isfaaghyth.visitablelist.entity

import app.isfaaghyth.visitablelist.internal.visitable.Visitable
import app.isfaaghyth.visitablelist.impl.visitable.factory.ItemTypeFactory

data class Advertisement(
    val title: String = "",
    val description: String = ""
) : Visitable<ItemTypeFactory> {

    override fun type(typeFactory: ItemTypeFactory): Int {
        return typeFactory.type(this)
    }

}