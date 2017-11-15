//package com.d.m.system.ui.main.adapter
//
//import android.content.Context
//import android.support.v7.widget.RecyclerView
//import android.text.TextUtils
//import android.view.LayoutInflater
//import android.view.View
//import android.view.ViewGroup
//import android.widget.LinearLayout
//import android.widget.TextView
//import com.d.m.system.R
//import com.d.m.system.modle.Device
//import com.d.m.system.utils.DateUtil
//import kotlinx.android.synthetic.main.device_content_item.view.*
//import java.util.*
//
//class DeviceAdapter(private val context: Context) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
//    private var onItemClickListener: OnItemClickListener? = null
//    private var deviceDBs: MutableList<Device>? = ArrayList<Device>()
//
//    fun setOnItemClickListener(listener: OnItemClickListener) {
//        this.onItemClickListener = listener
//    }
//
//    fun addData(data: MutableList<Device>) {
//        if (deviceDBs == null) {
//            deviceDBs = data
//        } else {
//            deviceDBs!!.addAll(data)
//        }
//    }
//
//    fun clearData() {
//        if (deviceDBs != null) {
//            deviceDBs!!.clear()
//        }
//    }
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
//        var viewHolder: RecyclerView.ViewHolder?
//        val inflater = LayoutInflater.from(parent.context)
//        viewHolder = ContentHolder(inflater.inflate(R.layout.device_content_item, parent, false))
//        return viewHolder
//    }
//
//    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
//        val contentHolder = holder as ContentHolder
//        val deviceDB = deviceDBs!![position]
//        contentHolder.device = deviceDB
//        contentHolder.device_num!!.text = deviceDB.device_number
//        contentHolder.mac_address!!.text = deviceDB.mac
//        contentHolder.bind_time!!.text = deviceDB.creat_time
//        contentHolder.patient!!.text = deviceDB.name
//    }
//
//    override fun getItemCount(): Int {
//        if (deviceDBs != null && deviceDBs!!.size > 0) {
//            return deviceDBs!!.size
//        }
//        return 0
//    }
//
//    interface OnItemClickListener {
//        fun editDeviceClick(obj: Device)
//
//        fun deleteDeviceClick(obj: Device)
//    }
//
//    internal inner class ContentHolder(view: View) : RecyclerView.ViewHolder(view), View.OnClickListener {
//        var device_num: TextView? = view.device_num
//        var mac_address: TextView? = view.mac_address
//        var patient: TextView? = view.patient
//        var bind_time: TextView? = view.bind_time
//        var edit: LinearLayout? = view.edit
//        var delete: LinearLayout? = view.delete
//        var device: Device? = null
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
//                    R.id.edit -> onItemClickListener!!.editDeviceClick(device!!)
//                    R.id.delete -> onItemClickListener!!.deleteDeviceClick(device!!)
//                }
//            }
//        }
//    }
//}
