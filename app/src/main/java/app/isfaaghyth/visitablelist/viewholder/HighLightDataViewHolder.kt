package app.isfaaghyth.visitablelist.viewholder

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import app.isfaaghyth.visitablelist.R
import app.isfaaghyth.visitablelist.base.AbstractViewHolder
import app.isfaaghyth.visitablelist.entity.HighLight
import app.isfaaghyth.visitablelist.entity.HighLightData
import kotlinx.android.synthetic.main.item_highlight.view.*
import kotlinx.android.synthetic.main.item_overview_highlights.view.*

class HighLightDataViewHolder(view: View): AbstractViewHolder<HighLightData>(view) {

    private lateinit var adapter: HighLightAdapter
    private var lstHighlight = view.lstHighLight

    override fun bind(element: HighLightData) {
        adapter = HighLightAdapter(element.items)
        lstHighlight.layoutManager = LinearLayoutManager(
            itemView.context,
            LinearLayoutManager.HORIZONTAL,
            false)
        lstHighlight.adapter = adapter
    }

    class HighLightAdapter(
        private val items: List<HighLight>
    ) : RecyclerView.Adapter<HighLightAdapter.HighLightViewHolder>() {

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HighLightViewHolder {
            return HighLightViewHolder.inflate(parent)
        }

        override fun getItemCount(): Int = items.size

        override fun onBindViewHolder(holder: HighLightViewHolder, position: Int) {
            holder.bind(items[position])
        }

        class HighLightViewHolder(view: View): RecyclerView.ViewHolder(view) {

            private val txtTitle = view.txtTitle
            private val txtTag = view.txtTag

            fun bind(highLight: HighLight) {
                txtTitle.text = highLight.title
                txtTag.text = highLight.tag
            }

            companion object {
                fun inflate(viewGroup: ViewGroup): HighLightViewHolder {
                    val view = LayoutInflater
                        .from(viewGroup.context)
                        .inflate(R.layout.item_highlight, viewGroup, false)
                    return HighLightViewHolder(view)
                }
            }

        }
    }

    companion object {
        val LAYOUT = R.layout.item_overview_highlights
    }

}