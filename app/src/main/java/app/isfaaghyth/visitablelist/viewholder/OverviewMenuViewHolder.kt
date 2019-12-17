package app.isfaaghyth.visitablelist.viewholder

import android.view.View
import app.isfaaghyth.visitablelist.R
import app.isfaaghyth.visitablelist.base.AbstractViewHolder
import app.isfaaghyth.visitablelist.entity.Menu
import app.isfaaghyth.visitablelist.entity.OverviewMenu
import kotlinx.android.synthetic.main.item_overview_menu.view.*

class OverviewMenuViewHolder(view: View): AbstractViewHolder<OverviewMenu>(view) {

    private val imgScan = view.imgScan
    private val txtTitleScan = view.txtTitleScan

    private val imgPay = view.imgPay
    private val txtTitlePay = view.txtTitlePay

    private val imgHistory = view.imgHistory
    private val txtTitleHistory = view.txtTitleHistory

    private val imgUser = view.imgUser
    private val txtTitleUser = view.txtTitleUser

    override fun bind(element: OverviewMenu) {
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
        val LAYOUT = R.layout.item_overview_menu
    }

}