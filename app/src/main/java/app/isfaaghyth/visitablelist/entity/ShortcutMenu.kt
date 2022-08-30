package app.isfaaghyth.visitablelist.entity

import app.isfaaghyth.visitablelist.internal.visitable.Visitable
import app.isfaaghyth.visitablelist.impl.visitable.factory.ItemTypeFactory

data class ShortcutMenu(
    val scan: Menu,
    val pay: Menu,
    val history: Menu,
    val user: Menu
) : Visitable<ItemTypeFactory> {

    override fun type(typeFactory: ItemTypeFactory): Int {
        return typeFactory.type(this)
    }

}

data class Menu(
    val icon: Int = 0,
    val title: String = ""
)