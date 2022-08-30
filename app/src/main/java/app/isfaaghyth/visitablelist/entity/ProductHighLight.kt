package app.isfaaghyth.visitablelist.entity

import app.isfaaghyth.visitablelist.internal.visitable.Visitable
import app.isfaaghyth.visitablelist.impl.visitable.factory.ItemTypeFactory

data class ProductHighLight(
    val items: List<HighLight> = listOf()
) : Visitable<ItemTypeFactory> {

    override fun type(typeFactory: ItemTypeFactory): Int {
        return typeFactory.type(this)
    }

}

data class HighLight(
    val title: String = "",
    val tag: String = ""
)