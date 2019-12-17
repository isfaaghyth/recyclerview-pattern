package app.isfaaghyth.visitablelist.entity

import app.isfaaghyth.visitablelist.base.BaseItemModel
import app.isfaaghyth.visitablelist.factory.ItemTypeFactory

data class AdBanner(
    val title: String = "",
    val description: String = ""
) : BaseItemModel() {

    override fun type(typeFactory: ItemTypeFactory): Int {
        return typeFactory.type(this)
    }

}