//package com.d.m.system.ui.main.adapter
//
//import android.content.Context
//import android.view.LayoutInflater
//import android.view.View
//import android.view.ViewGroup
//import android.widget.BaseAdapter
//import android.widget.ImageView
//import android.widget.LinearLayout
//import android.widget.TextView
//import com.d.m.system.R
//import com.d.m.system.modle.MenuBeen
//import kotlinx.android.synthetic.main.menu_item.view.*
//import java.util.*
//
//class MenuAdapter(private val context: Context, n: List<MenuBeen>) : BaseAdapter() {
//    private var menuBeens = ArrayList<MenuBeen>()
//    private var index = 0
//
//    init {
//        this.menuBeens = n as ArrayList<MenuBeen>
//    }
//
//    fun refreshItemBg(position: Int) {
//        this.index = position
//        notifyDataSetChanged()
//    }
//
//    override fun getView(position: Int, v: View?, parent: ViewGroup?): View {
//        var convertView = v
//        val holder: ViewHolder
//        if (convertView == null) {
//            convertView = LayoutInflater.from(context).inflate(R.layout.menu_item, null)
//            holder = ViewHolder(convertView)
//            convertView!!.tag = holder
//        } else {
//            holder = convertView.tag as ViewHolder
//        }
//        val menuBeen = menuBeens[position]
//        if (index == position) {
//            holder.itemBg.background = context.resources.getDrawable(R.drawable.menu_bg)
//            holder.textView.setTextColor(context.resources.getColor(R.color.gray))
//            when (position) {
//                0 -> {
//                    holder.imageView.setBackgroundResource(R.mipmap.temp_h)
//                }
//                1 -> {
//                    holder.imageView.setBackgroundResource(R.mipmap.patient_h)
//                }
//                2 -> {
//                    holder.imageView.setBackgroundResource(R.mipmap.bed_h)
//                }
//                3 -> {
//                    holder.imageView.setBackgroundResource(R.mipmap.device_h)
//                }
//                4 -> {
//                    holder.imageView.setBackgroundResource(R.mipmap.grade_h)
//                }
//            }
//        } else {
//            holder.itemBg.setBackgroundColor(context.resources.getColor(R.color.colorAccent))
//            holder.imageView.setBackgroundResource(menuBeen.pic)
//            holder.textView.setTextColor(context.resources.getColor(R.color.white))
//        }
//        holder.textView.setText(menuBeen.name)
//        return convertView
//    }
//
//    override fun getItem(position: Int): Any {
//        return menuBeens[position]
//    }
//
//    override fun getItemId(position: Int): Long {
//        return position.toLong()
//    }
//
//    override fun getCount(): Int {
//        return menuBeens.size
//    }
//
//    private inner class ViewHolder(view: View) {
//        internal var imageView: ImageView = view.item_img
//        internal var textView: TextView = view.item_name
//        internal var itemBg: LinearLayout = view.item_bg
//    }
//}