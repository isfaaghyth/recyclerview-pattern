package app.isfaaghyth.visitablelist.entity

import app.isfaaghyth.visitablelist.base.BaseItemModel
import app.isfaaghyth.visitablelist.factory.ItemTypeFactory

data class HighLightData(
    val items: List<HighLight> = listOf()
) : BaseItemModel() {

    override fun type(typeFactory: ItemTypeFactory): Int {
        return typeFactory.type(this)
    }

}