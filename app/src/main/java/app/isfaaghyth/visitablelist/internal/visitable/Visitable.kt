package app.isfaaghyth.visitablelist.internal.visitable

interface Visitable<T> {
    fun type(typeFactory: T): Int
}