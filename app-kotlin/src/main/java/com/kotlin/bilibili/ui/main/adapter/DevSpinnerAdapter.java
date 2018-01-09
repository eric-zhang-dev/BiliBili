//package com.kotlin.bilibili.ui.main.adapter;
//
//import android.content.Context;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.BaseAdapter;
//import android.widget.TextView;
//
//import com.d.m.system.R;
//import com.inuker.bluetooth.library.search.SearchResult;
//
//import java.util.ArrayList;
//import java.util.Collection;
//import java.util.Collections;
//import java.util.Comparator;
//import java.util.List;
//
//public class DevSpinnerAdapter extends BaseAdapter implements Comparator<SearchResult> {
//    private Context context;
//    private List<SearchResult> searchResults = new ArrayList<>();
//
//    public DevSpinnerAdapter(Context context) {
//        this.context = context;
//    }
//
//    @Override
//    public int getCount() {
//        if (searchResults != null && searchResults.size() > 0) {
//            return searchResults.size();
//        }
//        return 0;
//    }
//
//    @Override
//    public Object getItem(int position) {
//        return searchResults.get(position);
//    }
//
//    public void setData(Collection<SearchResult> datas) {
//        searchResults.clear();
//        searchResults.addAll(datas);
//        Collections.sort(searchResults, this);
//        notifyDataSetChanged();
//    }
//
//    @Override
//    public long getItemId(int position) {
//        return position;
//    }
//
//    @Override
//    public View getView(int position, View convertView, ViewGroup parent) {
//        ViewHolder holder;
//        if (convertView == null) {
//            convertView = LayoutInflater.from(context).inflate(
//                    R.layout.spinner_adapter, null);
//            holder = new ViewHolder(convertView);
//            convertView.setTag(holder);
//        } else {
//            holder = (ViewHolder) convertView.getTag();
//        }
//        SearchResult searchResult = searchResults.get(position);
//        holder.textView.setText(searchResult.getAddress());
//        holder.rssi.setText(searchResult.rssi+"");
//        return convertView;
//    }
//
//    @Override
//    public int compare(SearchResult o1, SearchResult o2) {
//        return o2.rssi - o1.rssi;
//    }
//
//    private class ViewHolder {
//        TextView textView;
//        TextView rssi;
//
//        public ViewHolder(View view) {
//            textView = (TextView) view.findViewById(R.id.sp_item);
//            rssi = (TextView) view.findViewById(R.id.rssi);
//        }
//    }
//}
