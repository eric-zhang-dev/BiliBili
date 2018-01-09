//package com.d.m.system.ui.main.adapter
//
//import android.content.Context
//import android.support.v7.widget.RecyclerView
//import android.view.LayoutInflater
//import android.view.View
//import android.view.ViewGroup
//import android.widget.LinearLayout
//import android.widget.TextView
//
//import java.util.ArrayList
//import com.d.m.system.R
//import com.d.m.system.modle.Datas
//import kotlinx.android.synthetic.main.bed_content_item.view.*
//
//class RoomAdapter(private val context: Context) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
//    private var onItemClickListener: OnItemClickListener? = null
//    private var datas: MutableList<Datas>? = ArrayList<Datas>()
//
//    fun setOnItemClickListener(listener: OnItemClickListener) {
//        this.onItemClickListener = listener
//    }
//
//    fun addData(data: MutableList<Datas>) {
//        if (datas == null) {
//            datas = data
//        } else {
//            clearData()
//            datas!!.addAll(data)
//        }
//    }
//
//    fun clearData() {
//        if (datas != null) {
//            datas!!.clear()
//        }
//    }
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
//        var viewHolder: RecyclerView.ViewHolder? = null
//        val inflater = LayoutInflater.from(parent.context)
//        viewHolder = ContentHolder(inflater.inflate(R.layout.room_content_item, parent, false))
//        return viewHolder
//    }
//
//    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
//        val contentHolder = holder as ContentHolder
//        val data = datas!![position]
//        contentHolder.d = data
//        contentHolder.bed_r!!.text = data.room_name
//        if (data.bed_name != null && data.bed_name.size > 0) {
//            val result = StringBuilder()
//            var flag = false
//            for (i in data.bed_name.indices) {
//                if (flag) {
//                    result.append("  ")
//                } else {
//                    flag = true
//                }
//                result.append(data.bed_name[i].name)
//                if (i >= 8) {
//                    result.append("...")
//                    break
//                }
//            }
//            contentHolder.patient!!.text = result.toString()
//        } else {
//            contentHolder.patient!!.text = "未添加"
//        }
//    }
//
//    override fun getItemCount(): Int {
//        if (datas != null && datas!!.size > 0) {
//            return datas!!.size
//        }
//        return 0
//    }
//
//    interface OnItemClickListener {
//        fun itemClick(obj: Datas)
//        fun editPatientClick(obj: Datas) //编辑患者信息
//
//        fun deletePatientClick(obj: Datas) //删除患者
//    }
//
//    internal inner class ContentHolder(view: View) : RecyclerView.ViewHolder(view), View.OnClickListener {
//        internal var bed_r: TextView? = view.bed_r
//        internal var patient: TextView? = view.patient
//        internal var edit: LinearLayout? = view.edit
//        internal var delete: LinearLayout? = view.delete
//        internal var d: Datas? = null
//
//        init {
//            delete!!.setOnClickListener(this)
//            edit!!.setOnClickListener(this)
//            bed_r!!.setOnClickListener(this)
//            patient!!.setOnClickListener(this)
//        }
//
//        override fun onClick(v: View) {
//            val id = v.id
//            if (null != onItemClickListener) {
//                when (id) {
//                    R.id.edit -> onItemClickListener!!.editPatientClick(d!!)
//                    R.id.delete -> onItemClickListener!!.deletePatientClick(d!!)
//                    R.id.bed_r, R.id.patient -> {
//                        onItemClickListener!!.itemClick(d!!)
//                    }
//                }
//            }
//        }
//    }
//}
