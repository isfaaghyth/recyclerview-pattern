package app.isfaaghyth.visitablelist

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import app.isfaaghyth.visitablelist.entity.HighLight
import app.isfaaghyth.visitablelist.entity.Menu
import app.isfaaghyth.visitablelist.entity.ProductHighLight
import app.isfaaghyth.visitablelist.entity.ShortcutMenu
import app.isfaaghyth.visitablelist.impl.adapterdelegate.FeatureDelegateAdapter
import app.isfaaghyth.visitablelist.impl.visitable.FeatureVisitableAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        lstItems.layoutManager = LinearLayoutManager(this)

        setupVisitableItems() // visitor pattern
//        setupAdapterDelegateItems() // adapter delegate
    }

    private fun setupAdapterDelegateItems() {
        val adapter = FeatureDelegateAdapter()
        lstItems.adapter = adapter

        adapter.addItems(shortcutMenu())
    }

    private fun setupVisitableItems() {
        val adapter = FeatureVisitableAdapter()
        lstItems.adapter = adapter

        adapter.addItem(shortcutMenu())
        adapter.addItem(productHighlight())
    }

    private fun shortcutMenu() = listOf(
        ShortcutMenu(
            Menu(R.mipmap.ic_overview_scan, "Scan"),
            Menu(R.mipmap.ic_overview_pay, "Pay"),
            Menu(R.mipmap.ic_overview_history, "History"),
            Menu(R.mipmap.ic_overview_user, "Account")
        )
    )

    private fun productHighlight() = listOf(
        ProductHighLight(listOf(
            HighLight("Macbook", "#electronic"),
            HighLight("Galaxy S22", "#electronic"),
            HighLight("Lenovo X1 Carbon", "#electronic")
        ))
    )

}
