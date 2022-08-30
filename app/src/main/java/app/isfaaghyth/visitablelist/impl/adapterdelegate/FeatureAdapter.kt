package app.isfaaghyth.visitablelist.impl.adapterdelegate

import app.isfaaghyth.visitablelist.impl.adapterdelegate.delegate.ShortcutMenuDelegate
import app.isfaaghyth.visitablelist.internal.adapterdelegate.BaseAdapter

class FeatureAdapter : BaseAdapter<Any>() {

    init {
        delegatesManager
            .addDelegate(ShortcutMenuDelegate())
    }

}