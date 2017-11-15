//package com.d.m.system.ui.main.adapter
//
//import android.content.Context
//import android.support.v7.widget.RecyclerView
//import android.text.Html
//import android.text.TextUtils
//import android.view.LayoutInflater
//import android.view.View
//import android.view.ViewGroup
//import android.widget.ImageView
//import android.widget.RelativeLayout
//import android.widget.TextView
//import com.d.m.system.R
//import com.d.m.system.modle.Tem
//import kotlinx.android.synthetic.main.tem_monitor.view.*
//import java.util.*
//
//class BedMonitorAdapter(private val context: Context) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
//    private var onItemClickListener: OnItemClickListener? = null
//    private var tems: MutableList<Tem>? = ArrayList<Tem>()
//
//    fun setOnItemClickListener(listener: OnItemClickListener) {
//        this.onItemClickListener = listener
//    }
//
//    fun addData(data: MutableList<Tem>) {
//        if (tems == null) {
//            tems = data
//        } else {
//            clearData()
//            tems!!.addAll(data)
//        }
//    }
//
//    fun clearData() {
//        if (tems != null) {
//            tems!!.clear()
//        }
//    }
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
//        var viewHolder: RecyclerView.ViewHolder? = null
//        val inflater = LayoutInflater.from(parent.context)
//        viewHolder = ContentHolder(inflater.inflate(R.layout.tem_monitor, parent, false))
//        return viewHolder
//    }
//
//    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
//        val contentHolder = holder as ContentHolder
//        val tem = tems!![position]
//        contentHolder.tem = tem
//        contentHolder.room_bed!!.text=String.format("病房%s-%s床",tem.room_name,tem.bed_name)
//        var str: String? = null
//        contentHolder.name!!.text = tem.name
//        if (!TextUtils.isEmpty(tem.power)) {
//            val battery = Integer.valueOf(tem.power)
//            if (battery in 0..20) {
//                contentHolder.battery!!.setBackgroundResource(R.mipmap.battery_l)
//            } else if (battery in 21..60) {
//                contentHolder.battery!!.setBackgroundResource(R.mipmap.battery_m)
//            } else {
//                contentHolder.battery!!.setBackgroundResource(R.mipmap.battery_f)
//            }
//        } else {
//            contentHolder.battery!!.background = null
//        }
//        if (!TextUtils.isEmpty(tem.temp) && tem.temp !== "0.0") {
//            val temp = java.lang.Double.valueOf(tem.temp)
//            if (temp < 36) {
//                str = "<font color=#24beea>" + tem.temp + "<small>℃</small></font>"
//            } else if (temp >= 36 && temp < 37.5) {
//                str = "<font color=#6f7070>" + tem.temp + "<small>℃</small></font>"
//            } else if (temp >= 37.5 && temp < 38.5) {
//                str = "<font color=#ff9f1a>" + tem.temp + "<small>℃</small></font>"
//            } else if (temp >= 38.5) {
//                str = "<font color=#ff574a>" + tem.temp + "<small>℃</small></font>"
//            }
//        } else {
//            str = "<font color=#6f7070>--" + "<small>℃</small></font>"
//            contentHolder.battery!!.background = null
//        }
//        contentHolder.temp!!.text = Html.fromHtml(str)
//    }
//
//    override fun getItemCount(): Int {
//        if (tems != null && tems!!.size > 0) {
//            return tems!!.size
//        }
//        return 0
//    }
//
//    interface OnItemClickListener {
//        fun editPatientClick(obj: Tem)
//    }
//
//    internal inner class ContentHolder(view: View) : RecyclerView.ViewHolder(view), View.OnClickListener {
//        var name: TextView? = view.name
//        var room_bed: TextView? = view.room_bed
//        var temp: TextView? = view.temp
//        var battery: ImageView? = view.battery
//        var edit: RelativeLayout? = view.layout_item
//        var tem: Tem? = null
//
//        init {
//            edit!!.setOnClickListener(this)
//        }
//
//        override fun onClick(v: View) {
//            val id = v.id
//            if (null != onItemClickListener) {
//                when (id) {
//                    R.id.layout_item -> onItemClickListener!!.editPatientClick(tem!!)
//                }
//            }
//        }
//    }
//}
