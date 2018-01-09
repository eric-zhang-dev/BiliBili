//package com.kotlin.bilibili.ui.main.dialog;
//
//import android.app.Dialog;
//import android.content.Context;
//import android.os.Bundle;
//import android.support.annotation.IdRes;
//import android.text.Editable;
//import android.text.TextWatcher;
//import android.view.Gravity;
//import android.view.View;
//import android.view.Window;
//import android.view.WindowManager;
//import android.widget.AdapterView;
//import android.widget.EditText;
//import android.widget.ImageView;
//import android.widget.RadioGroup;
//import android.widget.Spinner;
//import android.widget.TextView;
//import android.widget.Toast;
//
//import com.d.m.system.R;
//import com.d.m.system.modle.Bed;
//
//
//public class AddBedDialog extends Dialog implements TextWatcher, AdapterView.OnItemSelectedListener {
//    private TextView textView, dlgTitle;
//    private Spinner spinner;
//    private EditText editText;
//    private ImageView back;
//    private View.OnClickListener onClickListener;
//    private int type = 0;
//    private String content;
//    private Bed bedDB;
//    public String titleString;
//    private RadioGroup group;
//    private Context context;
//
//    public AddBedDialog(Context context, View.OnClickListener listener, Bed bedD, String title) {
//        super(context);
//        this.context = context;
//        this.onClickListener = listener;
//        this.bedDB = bedD;
//        this.titleString = title;
//    }
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        requestWindowFeature(Window.FEATURE_NO_TITLE);
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.add_bed_dialog);
//        Window dialogWindow = getWindow();
//        setCanceledOnTouchOutside(false);
//        WindowManager.LayoutParams params = dialogWindow.getAttributes();
//        params.gravity = Gravity.CENTER;
//        dialogWindow.setAttributes(params);
//        textView = (TextView) dialogWindow.findViewById(R.id.ok);
//        dlgTitle = (TextView) dialogWindow.findViewById(R.id.dlgTitle);
//        group = (RadioGroup) dialogWindow.findViewById(R.id.radioGroup);
////        spinner = (Spinner) dialogWindow.findViewById(R.id.spinner);
//        editText = (EditText) dialogWindow.findViewById(R.id.content);
//
////        spinner.setOnItemSelectedListener(this);
//        dlgTitle.setText(titleString);
//        back = (ImageView) dialogWindow.findViewById(R.id.back);
//        back.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                dismiss();
//            }
//        });
////        type = spinner.getSelectedItem().toString().equals("正常") ? 0 : 1;
//        editText.addTextChangedListener(this);
//        textView.setOnClickListener(onClickListener);
//        group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
//                if (R.id.radiook == checkedId) {
//                    type = 0;
//                } else if (R.id.radiono == checkedId) {
//                    type = 1;
//                }
//
//            }
//        });
//        if (null != bedDB) {
//            editText.setText(bedDB.getBed_name());
//            editText.setSelection(editText.getText().length());
//            if (bedDB.getType() == "0") {
//                group.check(R.id.radiook);
//            } else {
//                group.check(R.id.radiono);
//            }
////            spinner.setSelection(bedDB.getBedType());
//        }
//    }
//
//    public String getContent() {
//        return content;
//    }
//
//    public void clearContent() {
//        content = "";
//    }
//
//    public int getType() {
//        return type;
//    }
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
//        content = s.toString();
//    }
//
//    @Override
//    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//        type = spinner.getSelectedItem().toString().equals("正常") ? 0 : 1;
//    }
//
//    @Override
//    public void onNothingSelected(AdapterView<?> parent) {
//
//    }
//}
