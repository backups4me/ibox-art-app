package com.ibox.nft.base.manager.download;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.core.content.FileProvider;
import com.ibox.libs.common.BaseApplication;
import com.ibox.libs.common.manager.LocalControlTool;
import com.ibox.libs.common.manager.exception.ExceptionHandler;
import com.ibox.libs.common.manager.exception.ExceptionHandlerHelper;
import com.ibox.libs.common.utils.EncryptTool;
import com.ibox.libs.common.utils.StringTool;
import com.ibox.libs.common.utils.ToastTool;
import com.ibox.nft.base.R;
import com.ibox.nft.base.manager.download.update.UpdateBean;
import com.stub.StubApp;
import d.c.d.d.f.a.b;
import java.io.File;

/* loaded from: VersionDownloadTool.class */
public final class VersionDownloadTool {
    public static Dialog a;

    public static int a(String str, String str2) {
        return b(str, str2, -2);
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:0x0090, code lost:
        if (r14 >= r0.length) goto L51;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x00a0, code lost:
        if (java.lang.Long.parseLong(r0[r14]) <= 0) goto L33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x00a3, code lost:
        return -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x00a5, code lost:
        r14 = r14 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x00ab, code lost:
        return 0;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r9v0 */
    /* JADX WARN: Type inference failed for: r9v1 */
    /* JADX WARN: Type inference failed for: r9v3, types: [long] */
    /* JADX WARN: Type inference failed for: r9v4 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int b(java.lang.String r5, java.lang.String r6, int r7) {
        /*
            Method dump skipped, instructions count: 193
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ibox.nft.base.manager.download.VersionDownloadTool.b(java.lang.String, java.lang.String, int):int");
    }

    public static void c(Context context) {
        Dialog dialog = a;
        if (dialog != null && context != null) {
            if (dialog.isShowing()) {
                a.dismiss();
            }
            a = null;
        }
    }

    public static void d(Activity activity, String str) {
        if (!TextUtils.isEmpty(str) && !str.contains("https:") && !str.contains("http:")) {
            ToastTool.f("Illegal apkUrl :" + str);
        } else if (activity != null && !StringTool.d(str)) {
            try {
                Uri parse = Uri.parse(str);
                Intent intent = new Intent("android.intent.action.VIEW");
                intent.setData(parse);
                activity.startActivity(intent);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    @NonNull
    public static String e(@NonNull UpdateBean updateBean) {
        return LocalControlTool.d() + "_" + updateBean.getNewVersion() + ".apk";
    }

    @NonNull
    public static String f(@NonNull String str) {
        return g(str, EncryptTool.d(str));
    }

    @NonNull
    public static String g(@NonNull String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        String lowerCase = str.substring(str.lastIndexOf("/") + 1).toLowerCase();
        if (TextUtils.isEmpty(lowerCase)) {
            lowerCase = str2;
        }
        return lowerCase;
    }

    public static Intent h(File file) {
        try {
            Context context = BaseApplication.c;
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setFlags(268435456);
            if (Build.VERSION.SDK_INT >= 24) {
                intent.setFlags(65);
                intent.setDataAndType(FileProvider.getUriForFile(context, StubApp.getOrigApplicationContext(context.getApplicationContext()).getPackageName() + ".download.file.provider", file), "application/vnd.android.package-archive");
            } else {
                intent.setDataAndType(Uri.fromFile(file), "application/vnd.android.package-archive");
            }
            return intent;
        } catch (Exception e2) {
            ExceptionHandler a2 = ExceptionHandlerHelper.a();
            if (a2 == null) {
                return null;
            }
            a2.onException(e2);
            return null;
        }
    }

    public static void j(int i) {
        ProgressBar progressBar;
        Dialog dialog = a;
        if (dialog != null && (progressBar = (ProgressBar) dialog.findViewById(R.id.pb_progressing)) != null) {
            progressBar.setProgress(i);
            progressBar.postInvalidate();
        }
    }

    public static void k(int i, int i2) {
        Dialog dialog = a;
        if (dialog != null) {
            ProgressBar progressBar = (ProgressBar) dialog.findViewById(R.id.pb_progressing);
            TextView textView = (TextView) a.findViewById(R.id.tv_progress_desp);
            if (progressBar != null) {
                progressBar.setProgress((int) (((i * 1.0f) / i2) * 100.0f));
                progressBar.postInvalidate();
            }
            if (textView != null) {
                textView.setText(String.format("%.2fM/%.2fM", Float.valueOf((i * 1.0f) / 1048576.0f), Float.valueOf((i2 * 1.0f) / 1048576.0f)));
            }
        }
    }

    public static void l(Context context, String str, View.OnClickListener onClickListener) {
        if (context != null) {
            a = new Dialog(context, R.style.dialog_full_screen_style);
            View inflate = View.inflate(context, R.layout.dialog_download_progress, null);
            TextView textView = (TextView) inflate.findViewById(R.id.tv_progress_title);
            if (!TextUtils.isEmpty(str)) {
                textView.setText(str);
            }
            a.setCancelable(false);
            a.setCanceledOnTouchOutside(false);
            a.setContentView(inflate);
            a.show();
            a.setOnDismissListener(b.f1151b);
        }
    }
}
