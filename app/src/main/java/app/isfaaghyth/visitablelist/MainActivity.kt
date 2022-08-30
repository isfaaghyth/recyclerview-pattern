package app.isfaaghyth.visitablelist

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import app.isfaaghyth.visitablelist.internal.visitable.BaseListAdapter
import app.isfaaghyth.visitablelist.entity.*
import app.isfaaghyth.visitablelist.impl.adapterdelegate.FeatureAdapter
import app.isfaaghyth.visitablelist.impl.visitable.factory.ItemTypeFactoryImpl
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        lstItems.layoutManager = LinearLayoutManager(this)

        setupVisitableItems()
//        setupAdapterDelegateItems()
    }

    private fun setupAdapterDelegateItems() {
        val adapter = FeatureAdapter()
        lstItems.adapter = adapter

        adapter.addItems(shortcutMenu())
    }

    private fun setupVisitableItems() {
        val adapter = BaseListAdapter(ItemTypeFactoryImpl())
        lstItems.adapter = adapter

        adapter.addItem(shortcutMenu())
        adapter.addItem(productHighlight())
        adapter.addItem(advertisement())
    }

    private fun shortcutMenu() = listOf(
        ShortcutMenu(
            Menu(R.mipmap.ic_overview_scan, "Scan"),
            Menu(R.mipmap.ic_overview_pay, "Pay"),
            Menu(R.mipmap.ic_overview_history, "History"),
            Menu(R.mipmap.ic_overview_user, "Account")
        )
    )

    private fun advertisement() = listOf(
        Advertisement("the one and only, Isfa!", "who the most handsome guy?")
    )

    private fun productHighlight() = listOf(
        ProductHighLight(listOf(
            HighLight("Macbook", "#electronic"),
            HighLight("Galaxy S22", "#electronic"),
            HighLight("Lenovo X1 Carbon", "#electronic")
        ))
    )

}
