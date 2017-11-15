//package com.d.m.system.ui.main.adapter
//
//import android.content.Context
//import android.support.v7.widget.RecyclerView
//import android.view.LayoutInflater
//import android.view.View
//import android.view.ViewGroup
//import android.widget.TextView
//import com.d.m.system.R
//import com.d.m.system.modle.Data
//import kotlinx.android.synthetic.main.patient_content_item.view.*
//import java.util.*
//
//class PatientAdapter(private val context: Context) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
//    private val mTypeList: MutableList<Int>
//    private var patientDBs: MutableList<Data>? = null
//    private var onItemClickListener: OnItemClickListener? = null
//
//    fun setOnItemClickListener(listener: OnItemClickListener) {
//        this.onItemClickListener = listener
//    }
//
//    init {
//        mTypeList = ArrayList<Int>()
//    }
//
//    fun addData(data: MutableList<Data>) {
//        if (patientDBs == null) {
//            patientDBs = data
//        } else {
//            patientDBs!!.addAll(data)
//        }
//    }
//
//    fun clearData() {
//        if (patientDBs != null) {
//            patientDBs!!.clear()
//        }
//    }
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
//        var viewHolder: RecyclerView.ViewHolder? = null
//        val inflater = LayoutInflater.from(parent.context)
//        when (viewType) {
//        //            case TYPE_MENU:
//        //                viewHolder = new MenuHolder(inflater.inflate(R.layout.patient_menu_item, parent, false));
//        //                break;
//        //            case TYPE_HEAD:
//        //                viewHolder = new HeadHolder(inflater.inflate(R.layout.patient_head_item, parent, false));
//        //                break;
//            TYPE_CONTENT -> viewHolder = ContentHolder(inflater.inflate(R.layout.patient_content_item, parent, false))
//        }
//        return viewHolder!!
//    }
//
//    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
//        val type = getItemViewType(position)
//        when (type) {
//
//            TYPE_CONTENT -> {
//                val contentHolder = holder as ContentHolder
//                val patientDB = patientDBs!![position]
//                contentHolder.patientDB = patientDB
//                contentHolder.age!!.text = patientDB.age
//                contentHolder.medical_record_number!!.text = patientDB.caseno
//                contentHolder.name!!.text = patientDB.name
//                contentHolder.ward!!.text = patientDB.room_name
//                contentHolder.bed!!.text = patientDB.bed_name
//            }
//        }
//    }
//
//    override fun getItemCount(): Int {
//        mTypeList.clear()
//        //        mTypeList.add(TYPE_MENU);
//        //        mTypeList.add(TYPE_CONTENT);//显示表头
//        //        mTypeList.add(TYPE_HEAD);
//        if (null != patientDBs && patientDBs!!.size > 0) {
//            for (i in patientDBs!!.indices) {
//                mTypeList.add(TYPE_CONTENT)
//            }
//        }
//        return mTypeList.size
//    }
//
//    override fun getItemViewType(position: Int): Int {
//        return mTypeList[position]
//    }
//
//    internal inner class ContentHolder(view: View) : RecyclerView.ViewHolder(view), View.OnClickListener {
//        var medical_record_number: TextView? = view.medical_record_number
//        var ward: TextView? = view.ward
//        var bed: TextView? = view.bed
//        var name: TextView? = view.name
//        var age: TextView? = view.age
//        var patientDB: Data? = null
//
//        init {
//            medical_record_number!!.setOnClickListener(this)
//            ward!!.setOnClickListener(this)
//            bed!!.setOnClickListener(this)
//            name!!.setOnClickListener(this)
//            age!!.setOnClickListener(this)
//        }
//
//        override fun onClick(v: View) {
//            val id = v.id
//            if (null != onItemClickListener) {
//                when (id) {
//                    R.id.medical_record_number,
//                    R.id.ward,
//                    R.id.bed,
//                    R.id.name,
//                    R.id.age -> onItemClickListener!!.detailPatientClick(patientDB!!)
//                }
//            }
//        }
//    }
//
//    interface OnItemClickListener {
//        fun detailPatientClick(obj: Data) //查看患者信息
//    }
//
//    companion object {
//        //    public static final int TYPE_MENU = 1;
//        //    public static final int TYPE_HEAD = 2;
//        val TYPE_CONTENT = 3
//    }
//}
