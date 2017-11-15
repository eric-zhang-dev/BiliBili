//package com.d.m.system.ui.main.adapter
//
//import android.content.Context
//import android.support.v7.widget.RecyclerView
//import android.view.LayoutInflater
//import android.view.View
//import android.view.ViewGroup
//import android.widget.LinearLayout
//import android.widget.TextView
//import com.d.m.system.R
//import com.d.m.system.modle.Bed
//import kotlinx.android.synthetic.main.bed_content_item.view.*
//import java.util.*
//
//class BedAdapter(private val context: Context) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
//    private var onItemClickListener: OnItemClickListener? = null
//    private var bedDBs: MutableList<Bed>? = ArrayList()
//
//    fun setOnItemClickListener(listener: OnItemClickListener) {
//        this.onItemClickListener = listener
//    }
//
//    fun addData(data: MutableList<Bed>) {
//        if (bedDBs == null) {
//            bedDBs = data
//        } else {
//            clearData()
//            bedDBs!!.addAll(data)
//        }
//    }
//
//    fun clearData() {
//        if (bedDBs != null) {
//            bedDBs!!.clear()
//        }
//    }
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
//        var viewHolder: RecyclerView.ViewHolder?
//        val inflater = LayoutInflater.from(parent.context)
//        viewHolder = ContentHolder(inflater.inflate(R.layout.bed_content_item, parent, false))
//        return viewHolder
//    }
//
//    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
//        val contentHolder = holder as ContentHolder
//        val bedDB = bedDBs!![position]
//        contentHolder.bed = bedDB
//        contentHolder.bed_r!!.text = bedDB.bed_name
//        if (bedDB.type.toInt() == 0) {
//            contentHolder.bed_type!!.text = "正常"
//        } else {
//            contentHolder.bed_type!!.text = "加床"
//        }
//        contentHolder.patient!!.text = bedDB.name
//    }
//
//    override fun getItemCount(): Int {
//        if (bedDBs != null && bedDBs!!.size > 0) {
//            return bedDBs!!.size
//        }
//        return 0
//    }
//
//    interface OnItemClickListener {
//        fun editPatientClick(obj: Bed)
//        fun deletePatientClick(obj: Bed)
//    }
//
//    internal inner class ContentHolder(view: View) : RecyclerView.ViewHolder(view), View.OnClickListener {
//        var bed_r: TextView? = view.bed_r
//        var bed_type: TextView? = view.bed_type
//        var patient: TextView? = view.patient
//        var edit: LinearLayout? = view.edit
//        var delete: LinearLayout? = view.delete
//        var bed: Bed? = null
//
//        init {
//            delete!!.setOnClickListener(this)
//            edit!!.setOnClickListener(this)
//        }
//
//        override fun onClick(v: View) {
//            val id = v.id
//            if (null != onItemClickListener) {
//                when (id) {
//                    R.id.edit -> onItemClickListener!!.editPatientClick(bed!!)
//                    R.id.delete -> onItemClickListener!!.deletePatientClick(bed!!)
//                }
//            }
//        }
//    }
//}
