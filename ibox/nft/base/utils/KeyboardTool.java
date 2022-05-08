package com.ibox.nft.base.utils;

import android.app.Activity;
import android.content.Context;
import android.os.ResultReceiver;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import com.ibox.libs.common.utils.LogTool;

/* loaded from: KeyboardTool.class */
public final class KeyboardTool {
    public static void a(Activity activity) {
        b(activity, null);
    }

    public static void b(Activity activity, ResultReceiver resultReceiver) {
        View peekDecorView;
        if (activity != null && (peekDecorView = activity.getWindow().peekDecorView()) != null) {
            ((InputMethodManager) activity.getSystemService("input_method")).hideSoftInputFromWindow(peekDecorView.getWindowToken(), 0, resultReceiver);
        }
    }

    public static void c(View view) {
        d(view, null);
    }

    public static void d(View view, ResultReceiver resultReceiver) {
        if (view != null) {
            ((InputMethodManager) view.getContext().getSystemService("input_method")).hideSoftInputFromWindow(view.getWindowToken(), 0, resultReceiver);
        }
    }

    public static void e(Context context, EditText editText) {
        if (context != null && editText != null) {
            editText.requestFocus();
            try {
                editText.setSelection(editText.getText().toString().length());
            } catch (Exception e2) {
                LogTool.e(e2);
            }
            ((InputMethodManager) context.getSystemService("input_method")).showSoftInput(editText, 2);
        }
    }
}
