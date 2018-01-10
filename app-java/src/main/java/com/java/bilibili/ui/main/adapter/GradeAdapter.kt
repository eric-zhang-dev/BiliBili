//package com.d.m.system.ui.main.adapter
//
//import android.content.Context
//import android.os.Build
//import android.os.Handler
//import android.support.annotation.RequiresApi
//import android.support.v7.widget.RecyclerView
//import android.text.Editable
//import android.text.TextWatcher
//import android.view.LayoutInflater
//import android.view.View
//import android.view.ViewGroup
//import android.widget.TextView
//import android.widget.Toast
//import com.d.m.system.R
//import com.d.m.system.modle.Grade
//import kotlinx.android.synthetic.main.grade_content_item.view.*
//import java.util.*
//
//
//class GradeAdapter(private val context: Context) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
//    private var onItemClickListener: OnItemClickListener? = null
//    private var datas: MutableList<Grade>? = ArrayList()
//    fun setOnItemClickListener(listener: OnItemClickListener) {
//        this.onItemClickListener = listener
//    }
//
//    fun addData(data: MutableList<Grade>) {
//        clearData()
//        datas!!.addAll(data)
//
//    }
//
//    fun clearData() {
//        if (datas != null) {
//            datas!!.clear()
//        }
//    }
//
//    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
//    override fun onBindViewHolder(holder: RecyclerView.ViewHolder?, position: Int) {
//        val contentHolder = holder as ContentHolder
//        val data = datas!![position]
//        when (position) {
//            0 -> {
//                contentHolder.color!!.background = context.getDrawable(R.mipmap.hight_temp)
//            }
//            1 -> {
//                contentHolder.color!!.background = context.getDrawable(R.mipmap.middle_temp)
//            }
//            2 -> {
//                contentHolder.color!!.background = context.getDrawable(R.mipmap.normal_temp)
//            }
//            3 -> {
//                contentHolder.color!!.background = context.getDrawable(R.mipmap.low_temp)
//            }
//        }
//        contentHolder.d = data
//        contentHolder.temp!!.text = data.name
//        contentHolder.high_value!!.text = data.high_value
//        contentHolder.low_value!!.text = data.low_value
//        contentHolder.high_value!!.addTextChangedListener(object : TextWatcher {
//            override fun afterTextChanged(s: Editable?) {
//                datas!![position].high_value = s.toString()
//            }
//
//            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
//            }
//
//            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
//
//            }
//
//        }
//        )
//        contentHolder.low_value!!.addTextChangedListener(object : TextWatcher {
//            override fun afterTextChanged(s: Editable?) {
//                datas!![position].low_value = s.toString()
//            }
//
//            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
//            }
//
//            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
//            }
//
//        }
//        )
//    }
//
//    override fun getItemCount(): Int {
//        if (datas != null && datas!!.size > 0) {
//            return datas!!.size
//        }
//        return 0
//    }
//
//    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): RecyclerView.ViewHolder {
//        var viewHolder: RecyclerView.ViewHolder?
//        val inflater = LayoutInflater.from(parent!!.context)
//        viewHolder = ContentHolder(inflater.inflate(R.layout.grade_content_item, parent, false))
//        return viewHolder
//    }
//
//    interface OnItemClickListener {
//        fun lessClick(obj: Grade)
//
//        fun addClick(obj: Grade)
//    }
//
//    internal inner class ContentHolder(view: View) : RecyclerView.ViewHolder(view), View.OnClickListener {
//        internal var color: TextView? = view.color
//        internal var temp: TextView? = view.temp
//        internal var high_value: TextView? = view.high_value
//        internal var low_value: TextView? = view.low_value
//        internal var d: Grade? = null
//
//        init {
////            delete!!.setOnClickListener(this)
////            edit!!.setOnClickListener(this)
//        }
//
//        override fun onClick(v: View) {
//            val id = v.id
//            if (null != onItemClickListener) {
//                when (id) {
////                    R.id.edit -> onItemClickListener!!.lessClick(d)
////                    R.id.delete -> onItemClickListener!!.addClick(d)
//                }
//            }
//        }
//    }
//}