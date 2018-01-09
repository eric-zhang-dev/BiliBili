//package com.kotlin.bilibili.ui.main.dialog;
//
//import android.app.Dialog;
//import android.content.Context;
//import android.os.Bundle;
//import android.text.Editable;
//import android.text.TextUtils;
//import android.text.TextWatcher;
//import android.view.Gravity;
//import android.view.View;
//import android.view.Window;
//import android.view.WindowManager;
//import android.widget.EditText;
//import android.widget.ImageView;
//import android.widget.TextView;
//
//import com.d.m.system.R;
//
//
//public class AddRoomDialog extends Dialog {
//    private ImageView imageView;
//    private EditText editText;
//    private TextView textView;
//    private View.OnClickListener clickListener;
//    private String content;
//
//    public AddRoomDialog(Context context, String type, View.OnClickListener listener) {
//        super(context);
//        this.clickListener = listener;
//        this.content = type;
//    }
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        requestWindowFeature(Window.FEATURE_NO_TITLE);
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.add_room_dialog);
//        Window dialogWindow = getWindow();
//        setCanceledOnTouchOutside(false);
//        WindowManager.LayoutParams params = dialogWindow.getAttributes();
//        params.gravity = Gravity.CENTER;
//        dialogWindow.setAttributes(params);
//        imageView = (ImageView) dialogWindow.findViewById(R.id.close);
//        imageView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                dismiss();
//            }
//        });
//        editText = (EditText) dialogWindow.findViewById(R.id.content);
//        if (!TextUtils.isEmpty(content)) {
//            editText.setText(content);
//            editText.setSelection(content.length());
//        }
//        editText.addTextChangedListener(new TextWatcher() {
//            @Override
//            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
//
//            }
//
//            @Override
//            public void onTextChanged(CharSequence s, int start, int before, int count) {
//
//            }
//
//            @Override
//            public void afterTextChanged(Editable s) {
//                content = s.toString();
//            }
//        });
//        textView = (TextView) dialogWindow.findViewById(R.id.ok);
//        textView.setOnClickListener(clickListener);
//    }
//
//    public String getContentText() {
//        return content;
//    }
//
//    public void clearContent() {
//        content = "";
//    }
//}
