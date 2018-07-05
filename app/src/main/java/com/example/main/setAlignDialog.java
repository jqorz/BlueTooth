package com.example.main;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.bluetoothassist.R;

/**
 * Created by Administrator on 2017/12/3.
 */

public class setAlignDialog extends Dialog {
    private TextView alignTips;
    private TextView alignNum;
    private EditText alignNumIn;
    private Button confirm;
    private Bundle bundle;
    private DialogCallback callback;
    /**
     * 按键监听对象
     */
    private View.OnClickListener buttonDialogListener = new View.OnClickListener() {

        @Override
        public void onClick(View view) {
            // TODO Auto-generated method stub
            if (view.getId() == R.id.confirm) {
                String s = alignNumIn.getText().toString();
                if (s.length() == 0) {
                    alignNumIn.setHint("输入不能为空");
                    return;
                }
                int num = Integer.valueOf(s);
                callback.DialogReturn(num);
                dismiss();
            }
        }
    };

    protected setAlignDialog(Context context, DialogCallback callback) {
        super(context);
        this.callback = callback;
    }

    private void assignViews() {
        alignTips = findViewById(R.id.align_tips);
        alignNum = findViewById(R.id.align_num);
        alignNumIn = findViewById(R.id.align_num_in);
        confirm = findViewById(R.id.confirm);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.set_align_dialog);
        this.setTitle("对齐设置");
        setCanceledOnTouchOutside(false);
        assignViews();
        confirm.setOnClickListener(buttonDialogListener);
    }

    public interface DialogCallback {
        void DialogReturn(int i);
    }
}
