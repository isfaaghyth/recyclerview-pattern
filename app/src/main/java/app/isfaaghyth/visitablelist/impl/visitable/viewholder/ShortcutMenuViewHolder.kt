package app.isfaaghyth.visitablelist.impl.visitable.viewholder

import android.view.View
import androidx.annotation.LayoutRes
import app.isfaaghyth.visitablelist.R
import app.isfaaghyth.visitablelist.internal.visitable.AbstractViewHolder
import app.isfaaghyth.visitablelist.entity.Menu
import app.isfaaghyth.visitablelist.entity.ShortcutMenu
import kotlinx.android.synthetic.main.item_overview_menu.view.*

class ShortcutMenuViewHolder(view: View): AbstractViewHolder<ShortcutMenu>(view) {

    private val imgScan = view.imgScan
    private val txtTitleScan = view.txtTitleScan

    private val imgPay = view.imgPay
    private val txtTitlePay = view.txtTitlePay

    private val imgHistory = view.imgHistory
    private val txtTitleHistory = view.txtTitleHistory

    private val imgUser = view.imgUser
    private val txtTitleUser = view.txtTitleUser

    override fun bind(element: ShortcutMenu) {
        setBtnScan(element.scan)
        setBtnPay(element.pay)
        setBtnHistory(element.history)
        setBtnUser(element.user)
    }

    private fun setBtnScan(scan: Menu) {
        imgScan.setImageResource(scan.icon)
        txtTitleScan.text = scan.title
    }

    private fun setBtnPay(pay: Menu) {
        imgPay.setImageResource(pay.icon)
        txtTitlePay.text = pay.title
    }

    private fun setBtnHistory(history: Menu) {
        imgHistory.setImageResource(history.icon)
        txtTitleHistory.text = history.title
    }

    private fun setBtnUser(user: Menu) {
        imgUser.setImageResource(user.icon)
        txtTitleUser.text = user.title
    }

    companion object {
        @LayoutRes val LAYOUT = R.layout.item_overview_menu
    }

}