package app.isfaaghyth.visitablelist.impl.adapterdelegate.delegate

import android.view.View
import android.view.ViewGroup
import app.isfaaghyth.visitablelist.R
import app.isfaaghyth.visitablelist.entity.ShortcutMenu
import app.isfaaghyth.visitablelist.impl.adapterdelegate.viewholder.ShortcutMenuViewHolder
import app.isfaaghyth.visitablelist.internal.adapterdelegate.TypedAdapterDelegate

class ShortcutMenuDelegate : TypedAdapterDelegate<ShortcutMenu, Any, ShortcutMenuViewHolder>(R.layout.item_overview_menu) {

    override fun onBindViewHolder(item: ShortcutMenu, holder: ShortcutMenuViewHolder) {
        holder.bind(item)
    }

    override fun onCreateViewHolder(parent: ViewGroup, basicView: View): ShortcutMenuViewHolder {
        return ShortcutMenuViewHolder(basicView) // or you can use exsiting viewHolder from Visitable
    }

}