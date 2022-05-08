package com.ibox.nft.base.utils;

import android.app.Activity;
import android.content.pm.PackageManager;
import android.os.Build;
import androidx.fragment.app.FragmentActivity;
import com.tbruyelle.rxpermissions3.RxPermissions;
import io.reactivex.rxjava3.functions.Consumer;

/* loaded from: PermissionTool.class */
public final class PermissionTool {
    public static boolean a(Activity activity, String... strArr) {
        if (activity == null) {
            return false;
        }
        boolean z = false;
        if (strArr != null) {
            if (strArr.length != 0) {
                PackageManager packageManager = activity.getPackageManager();
                String packageName = activity.getPackageName();
                int length = strArr.length;
                int i = 0;
                while (true) {
                    boolean z2 = true;
                    if (i >= length) {
                        z = true;
                        break;
                    }
                    if (packageManager.checkPermission(strArr[i], packageName) != 0) {
                        z2 = false;
                    }
                    if (!z2) {
                        z = false;
                        break;
                    }
                    i++;
                }
            } else {
                z = false;
            }
        }
        return z;
    }

    public static boolean b(Activity activity) {
        return a(activity, "android.permission.WRITE_EXTERNAL_STORAGE", "android.permission.READ_EXTERNAL_STORAGE");
    }

    public static void c(Activity activity) {
        if (activity != null) {
            PackageManager packageManager = activity.getPackageManager();
            String packageName = activity.getPackageName();
            boolean z = true;
            boolean z2 = packageManager.checkPermission("android.permission.WRITE_EXTERNAL_STORAGE", packageName) == 0;
            boolean z3 = packageManager.checkPermission("android.permission.READ_EXTERNAL_STORAGE", packageName) == 0;
            if (packageManager.checkPermission("android.permission.READ_PHONE_STATE", packageName) != 0) {
                z = false;
            }
            if (Build.VERSION.SDK_INT < 23) {
                return;
            }
            if (!z2 || !z3 || !z) {
                activity.requestPermissions(new String[]{"android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE", "android.permission.READ_PHONE_STATE"}, 269484032);
            }
        }
    }

    public static void d(FragmentActivity fragmentActivity, Consumer<Boolean> consumer, Consumer consumer2) {
        e(fragmentActivity, new String[]{"android.permission.CAMERA", "android.permission.RECORD_AUDIO", "android.permission.WRITE_EXTERNAL_STORAGE", "android.permission.READ_EXTERNAL_STORAGE"}, consumer, consumer2);
    }

    public static void e(FragmentActivity fragmentActivity, String[] strArr, Consumer<Boolean> consumer, Consumer consumer2) {
        new RxPermissions(fragmentActivity).request(strArr).subscribe(consumer, consumer2);
    }

    public static void f(Activity activity) {
        if (activity != null) {
            boolean a = a(activity, "android.permission.WRITE_EXTERNAL_STORAGE", "android.permission.READ_EXTERNAL_STORAGE");
            if (Build.VERSION.SDK_INT >= 23 && !a) {
                activity.requestPermissions(new String[]{"android.permission.WRITE_EXTERNAL_STORAGE", "android.permission.READ_EXTERNAL_STORAGE"}, 269484033);
            }
        }
    }
}
