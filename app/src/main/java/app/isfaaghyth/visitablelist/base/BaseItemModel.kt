package app.isfaaghyth.visitablelist.base

import app.isfaaghyth.visitablelist.factory.ItemTypeFactory

abstract class BaseItemModel {
    abstract fun type(typeFactory: ItemTypeFactory): Int
}