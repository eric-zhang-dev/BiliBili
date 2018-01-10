//package com.d.m.system.ui.main.adapter
//
//import android.content.Context
//import android.view.LayoutInflater
//import android.view.View
//import android.view.ViewGroup
//import android.widget.BaseAdapter
//import android.widget.TextView
//
//import com.d.m.system.R
//import com.d.m.system.modle.BedInfo
//import com.d.m.system.modle.User
//import kotlinx.android.synthetic.main.bed_item.view.*
//
//import java.util.ArrayList
//
//
//class UserInfoAdapter(private val context: Context) : BaseAdapter() {
//    private val datas = ArrayList<User>()
//
//    override fun getCount(): Int {
//        return datas.size
//    }
//
//    override fun getItem(position: Int): Any {
//        return datas[position]
//    }
//
//    fun setData(data: MutableList<User>) {
//        datas.clear()
//        datas.addAll(data)
//        notifyDataSetChanged()
//    }
//
//    override fun getItemId(position: Int): Long {
//        return position.toLong()
//    }
//
//    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
//        var convertView = convertView
//        val holder: ViewHolder
//        if (convertView == null) {
//            convertView = LayoutInflater.from(context).inflate(
//                    R.layout.bed_item, null)
//            holder = ViewHolder(convertView)
//            convertView!!.tag = holder
//        } else {
//            holder = convertView.tag as ViewHolder
//        }
//        val bed = datas[position]
//        holder.textView.text = bed.name
//        return convertView
//    }
//
//    private inner class ViewHolder(view: View) {
//        internal var textView: TextView = view.tv
//
//    }
//}
