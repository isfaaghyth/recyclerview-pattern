package app.isfaaghyth.visitablelist

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import app.isfaaghyth.visitablelist.base.BaseListAdapter
import app.isfaaghyth.visitablelist.entity.AdBanner
import app.isfaaghyth.visitablelist.entity.Menu
import app.isfaaghyth.visitablelist.entity.OverviewMenu
import app.isfaaghyth.visitablelist.factory.ItemTypeFactoryImpl
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var adapter: BaseListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        adapter = BaseListAdapter(ItemTypeFactoryImpl())
        lstItems.layoutManager = LinearLayoutManager(this)
        lstItems.adapter = adapter

        overviewMenu()
        advertisementBanner()
    }

    private fun overviewMenu() {
        val overviewMenus = listOf(
            OverviewMenu(
                Menu(R.mipmap.ic_overview_scan, "Pindai"),
                Menu(R.mipmap.ic_overview_pay, "Bayar"),
                Menu(R.mipmap.ic_overview_history, "Riwayat"),
                Menu(R.mipmap.ic_overview_user, "Akun")
            )
        )
        adapter.addItem(overviewMenus)
    }

    private fun advertisementBanner() {
        val adBanners = listOf(
            AdBanner("Tokopedia Saja!", "Gratis Ongkir?")
        )
        adapter.addItem(adBanners)
    }

}
