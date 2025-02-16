package io.charg.chargstation.ui.dialogs;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.AppCompatSeekBar;
import android.text.InputType;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.charg.chargstation.R;
import io.charg.chargstation.root.IAsyncCommand;
import io.charg.chargstation.root.ICallbackOnComplete;

public class EditTextDialog {

    @BindView(R.id.tv_message)
    TextView mTvMessage;

    @BindView(R.id.edt_value)
    EditText mEtValue;

    private Context mContext;
    private AlertDialog mDialog;

    private String mTitle;
    private String mOldValue;

    private ICallbackOnComplete<String> mOnComplete;

    public EditTextDialog(Context context, String title, String oldValue) {
        mContext = context;
        mTitle = title;
        mOldValue = oldValue;
        initDialog();
    }

    private void initDialog() {
        View view = LayoutInflater.from(mContext).inflate(R.layout.dlg_change_text, null);
        ButterKnife.bind(this, view);

        mTvMessage.setText(mTitle);
        mEtValue.setText(mOldValue);

        mDialog = new AlertDialog.Builder(mContext)
                .setView(view)
                .create();
    }

    public void show() {
        mDialog.show();
    }

    @OnClick(R.id.btn_yes)
    void onBtnSaveClicked() {
        if (mOnComplete != null) {
            mOnComplete.onComplete(mEtValue.getText().toString());
        }
        mDialog.dismiss();
    }

    @OnClick(R.id.btn_no)
    void onBtnDiscardClicked() {
        mDialog.dismiss();
    }

    public void setOnComplete(ICallbackOnComplete<String> onComplete) {
        mOnComplete = onComplete;
    }
}
