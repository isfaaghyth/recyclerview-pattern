package app.isfaaghyth.visitablelist.entity

import app.isfaaghyth.visitablelist.base.BaseItemModel
import app.isfaaghyth.visitablelist.factory.ItemTypeFactory

data class OverviewMenu(
    val scan: Menu,
    val pay: Menu,
    val history: Menu,
    val user: Menu
) : BaseItemModel() {

    override fun type(typeFactory: ItemTypeFactory): Int {
        return typeFactory.type(this)
    }

}