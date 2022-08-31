package app.isfaaghyth.visitablelist.impl.adapterdelegate

import app.isfaaghyth.visitablelist.impl.adapterdelegate.delegate.AdvertisementDelegate
import app.isfaaghyth.visitablelist.impl.adapterdelegate.delegate.ShortcutMenuDelegate
import app.isfaaghyth.visitablelist.internal.adapterdelegate.BaseAdapter

class FeatureDelegateAdapter : BaseAdapter<Any>() {

    init {
        delegatesManager
            .addDelegate(ShortcutMenuDelegate())
            .addDelegate(AdvertisementDelegate())
    }

}