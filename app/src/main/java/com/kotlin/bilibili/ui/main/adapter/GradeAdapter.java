package com.kotlin.bilibili.ui.main.adapter;//package com.d.m.system.ui.main.adapter;
//
//import android.content.Context;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.BaseAdapter;
//import android.widget.RelativeLayout;
//import android.widget.TextView;
//
//import com.inuker.bluetooth.library.search.SearchResult;
//import com.tmholter.department2.R;
//
//import java.util.ArrayList;
//import java.util.Collection;
//import java.util.Collections;
//import java.util.Comparator;
//
//public class GradeAdapter extends BaseAdapter implements Comparator<SearchResult> {
//	private Context context;
//	private ArrayList<SearchResult> dataList = new ArrayList<SearchResult>();
//	public int selectedIndex = -1;
//
//	public GradeAdapter(Context context) {
//		super();
//		this.context = context;
//	}
//
//	public void setData(Collection<SearchResult> datas) {
//		dataList.clear();
//		dataList.addAll(datas);
//		Collections.sort(dataList, this);
//		notifyDataSetChanged();
//	}
//	public void clear() {
//		if (dataList!=null){
//			this.dataList.clear();
//		}
//	}
//
//	public SearchResult getSelectedItem() {
//		if (selectedIndex >= 0) {
//			return dataList.get(selectedIndex);
//		} else {
//			return null;
//		}
//	}
//
//	@Override
//	public int getCount() {
//		return dataList.size();
//	}
//
//	@Override
//	public Object getItem(int position) {
//		return null;
//	}
//
//	@Override
//	public long getItemId(int position) {
//		return 0;
//	}
//
//	@Override
//	public View getView(int position, View convertView, ViewGroup parent) {
//		ViewHolder holder;
//		if (convertView == null) {
//			convertView = LayoutInflater.from(context).inflate(
//					R.layout.item_ble_list, null);
//			holder = new ViewHolder(convertView);
//			convertView.setTag(holder);
//		} else {
//			holder = (ViewHolder) convertView.getTag();
//		}
//
//		SearchResult snapshot = dataList.get(position);
//		holder.tvDeviceName.setText(snapshot.device.getName());
//		holder.tvRssi.setText(snapshot.rssi + "dbm");
//		holder.tvDeviceMac.setText(snapshot.getAddress());
////		holder.tvTemp.setText(snapshot.getTemperature() + "℃" + " "
////				+ snapshot.getNewTemperature() + "℃");
//
//		if (position == selectedIndex) {
//			holder.rlItem.setBackgroundResource(R.color.colorAccent);
//		} else {
//			holder.rlItem.setBackgroundResource(R.color.white);
//		}
//		return convertView;
//	}
//
//	@Override
//	public int compare(SearchResult o1, SearchResult o2) {
//		return o2.rssi-o1.rssi;
//	}
//
//	private class ViewHolder {
//		TextView tvDeviceName, tvRssi, tvDeviceMac, tvTemp;
//		RelativeLayout rlItem;
//
//		public ViewHolder(View convertView) {
//			rlItem = (RelativeLayout) convertView.findViewById(R.id.rlItem);
//			tvDeviceName = (TextView) convertView.findViewById(R.id.tvDeviceName);
//			tvRssi = (TextView) convertView.findViewById(R.id.tvRssi);
//			tvDeviceMac = (TextView) convertView.findViewById(R.id.tvDeviceMac);
//			tvTemp = (TextView) convertView.findViewById(R.id.tvTemp);
//		}
//	}
//}
