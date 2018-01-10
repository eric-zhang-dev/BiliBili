package com.java.bilibili.ui.main.adapter;//package com.kotlin.bilibili.ui.main.adapter;
//
//import android.app.Dialog;
//import android.bluetooth.BluetoothAdapter;
//import android.content.Context;
//import android.os.Bundle;
//import android.text.Editable;
//import android.text.TextWatcher;
//import android.view.Gravity;
//import android.view.View;
//import android.view.Window;
//import android.view.WindowManager;
//import android.widget.AdapterView;
//import android.widget.EditText;
//import android.widget.ImageView;
//import android.widget.LinearLayout;
//import android.widget.Spinner;
//import android.widget.TextView;
//
//import com.d.m.system.R;
//import com.d.m.system.manager.ClientManager;
//import com.d.m.system.modle.Device;
//import com.inuker.bluetooth.library.search.SearchRequest;
//import com.inuker.bluetooth.library.search.SearchResult;
//import com.inuker.bluetooth.library.search.response.SearchResponse;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class AddDeviceDialog extends Dialog implements TextWatcher, AdapterView.OnItemSelectedListener {
//    private ImageView mClose;
//    private EditText editText;
//    private Spinner spinner;
//    private TextView ok, title;
//    private LinearLayout macLayout;
//    private  String deciceNum;
//    private  SearchResult macAddress;
//    private List<String> list = new ArrayList<String>();
//    private Context context;
//    private View.OnClickListener listener;
//    private List<SearchResult> searchResults = new ArrayList<>();
//    private BluetoothAdapter mBtAdapter = BluetoothAdapter.getDefaultAdapter();
//    private DevSpinnerAdapter devSpinnerAdapter;
//    Device deviceDB;
//
//    public AddDeviceDialog(Context context, View.OnClickListener listener, Device deviceDB) {
//        super(context);
//        this.context = context;
//        this.listener = listener;
//        this.deviceDB = deviceDB;
//    }
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        requestWindowFeature(Window.FEATURE_NO_TITLE);
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.add_device_dialog);
//        Window dialogWindow = getWindow();
//        setCanceledOnTouchOutside(false);
//        WindowManager.LayoutParams params = dialogWindow.getAttributes();
//        params.gravity = Gravity.CENTER;
//        dialogWindow.setAttributes(params);
//        mClose = (ImageView) dialogWindow.findViewById(R.id.close);
//        editText = (EditText) dialogWindow.findViewById(R.id.content);
//        spinner = (Spinner) dialogWindow.findViewById(R.id.spinner);
//        ok = (TextView) dialogWindow.findViewById(R.id.ok);
//        title = (TextView) dialogWindow.findViewById(R.id.titles);
//        macLayout = (LinearLayout) dialogWindow.findViewById(R.id.mac_layout);
//        ok.setOnClickListener(listener);
//        spinner.setAdapter(devSpinnerAdapter = new DevSpinnerAdapter(context));
//        mClose.setOnClickListener(listener);
//        editText.addTextChangedListener(this);
//        spinner.setOnItemSelectedListener(this);
//        if (deviceDB != null) {
//            title.setText("编辑设备");
//            macLayout.setVisibility(View.GONE);
//            editText.setText(deviceDB.getDevice_number());
//            editText.setSelection(editText.getText().length());
//        } else {
//            title.setText("添加设备");
//            macLayout.setVisibility(View.VISIBLE);
//            if (mBtAdapter.isEnabled()) {
//                searchDevice();
//            }
//        }
//
//    }
//
//    private void searchDevice() {
//        SearchRequest request = new SearchRequest.Builder().searchBluetoothLeDevice(3000, 1).build();
//        ClientManager.INSTANCE.getClient().search(request, response);
//    }
//
//    private final SearchResponse response = new SearchResponse() {
//        @Override
//        public void onSearchStarted() {
//        }
//
//        @Override
//        public void onDeviceFounded(SearchResult device) {
//            if (!searchResults.contains(device)) {
//                searchResults.add(device);
//            }
//        }
//
//        @Override
//        public void onSearchStopped() {
//            devSpinnerAdapter.setData(searchResults);
//        }
//
//        @Override
//        public void onSearchCanceled() {
//        }
//    };
//
//    @Override
//    public void beforeTextChanged(CharSequence s, int start, int count, int after) {
//
//    }
//
//    @Override
//    public void onTextChanged(CharSequence s, int start, int before, int count) {
//
//    }
//
//    @Override
//    public void afterTextChanged(Editable s) {
//        deciceNum = s.toString();
//    }
//
//    public  String getContent() {
//        return deciceNum;
//    }
//
//    public  void clearContent() {
//        deciceNum = "";
//    }
//
//    public  SearchResult getMAC() {
//        return macAddress;
//    }
//
//
//    @Override
//    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//        if (searchResults == null) return;
//        macAddress = (SearchResult) devSpinnerAdapter.getItem(position);
//    }
//
//    @Override
//    public void onNothingSelected(AdapterView<?> parent) {
//        if (searchResults == null) return;
//        macAddress = searchResults.get(0);
//    }
//}
