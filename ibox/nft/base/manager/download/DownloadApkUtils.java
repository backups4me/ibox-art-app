package com.ibox.nft.base.manager.download;

import android.app.DownloadManager;
import android.content.BroadcastReceiver;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.pm.ResolveInfo;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.content.FileProvider;
import com.alipay.sdk.widget.d;
import com.ibox.libs.common.BaseApplication;
import d.c.d.d.f.a.a;
import java.io.File;
import java.util.List;
import java.util.concurrent.ScheduledExecutorService;

/* loaded from: DownloadApkUtils.class */
public class DownloadApkUtils {
    public static final String a = "DownloadApkUtils";

    /* renamed from: b  reason: collision with root package name */
    public static volatile DownloadApkUtils f405b;
    public Context c;

    /* renamed from: d  reason: collision with root package name */
    public DownloadManager f406d;

    /* renamed from: e  reason: collision with root package name */
    public SharedPreferences f407e;
    public long f;
    public ScheduledExecutorService g;
    public DownloadChangeObserver h;
    public DownLoadBroadcast i;
    public OnProgressListener j;
    public String k;
    public boolean l = false;
    public Runnable m = new 1(this);
    public Handler n = new 2(this, Looper.getMainLooper());

    /* loaded from: DownloadApkUtils$OnProgressListener.class */
    public interface OnProgressListener {
        void b(String str);

        void c(int i, int i2);

        void d(int i);

        void onError();
    }

    public static DownloadApkUtils q() {
        if (f405b == null) {
            synchronized (DownloadApkUtils.class) {
                try {
                    if (f405b == null) {
                        f405b = new DownloadApkUtils();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return f405b;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: t */
    public /* synthetic */ void u(String str) {
        w();
        Uri parse = Uri.parse(str.trim().replace("https://", "http://"));
        DownloadManager.Request request = new DownloadManager.Request(parse);
        request.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS, parse.getLastPathSegment());
        request.setNotificationVisibility(2);
        request.setAllowedNetworkTypes(3);
        request.allowScanningByMediaScanner();
        this.f = this.f406d.enqueue(request);
        this.f407e.edit().putLong("ibox_downloadId", this.f).commit();
        v();
    }

    public final void A() {
        int[] iArr = {-1, -1};
        Cursor cursor = null;
        try {
            Cursor query = this.f406d.query(new DownloadManager.Query().setFilterById(this.f));
            if (query != null && query.moveToFirst()) {
                int i = query.getInt(query.getColumnIndex("status"));
                if (i == 2) {
                    iArr[0] = query.getInt(query.getColumnIndexOrThrow("bytes_so_far"));
                    iArr[1] = query.getInt(query.getColumnIndexOrThrow("total_size"));
                    String string = query.getString(query.getColumnIndex(d.v));
                    if (!TextUtils.isEmpty(string) && TextUtils.isEmpty(this.k)) {
                        StringBuilder sb = new StringBuilder();
                        sb.append(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).getAbsolutePath());
                        sb.append(File.separator);
                        sb.append(string);
                        this.k = sb.toString();
                        String str = a;
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("fileName: ");
                        sb2.append(string);
                        Log.e(str, sb2.toString());
                    }
                } else if (i == 4) {
                    iArr[0] = query.getInt(query.getColumnIndex("reason"));
                }
                Handler handler = this.n;
                cursor = query;
                handler.sendMessage(handler.obtainMessage(3549, iArr[0], iArr[1], Integer.valueOf(i)));
            }
            if (query != null) {
                query.close();
            }
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    public final void o() {
        ScheduledExecutorService scheduledExecutorService = this.g;
        if (scheduledExecutorService != null && !scheduledExecutorService.isShutdown()) {
            this.g.shutdown();
        }
        Handler handler = this.n;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
    }

    public void p(Context context, String str, OnProgressListener onProgressListener) {
        if (!TextUtils.isEmpty(str)) {
            this.f407e = BaseApplication.b().getSharedPreferences("downLoadapk", 0);
            this.l = false;
            this.c = context;
            this.k = null;
            this.j = onProgressListener;
            this.f406d = (DownloadManager) context.getSystemService("download");
            long j = this.f407e.getLong("ibox_downloadId", 0L);
            this.f = j;
            this.f406d.remove(j);
            BaseApplication.b.postDelayed(new a(this, str), 500L);
        }
    }

    public final void r(Context context, File file) {
        try {
            Intent intent = new Intent();
            intent.setAction("android.intent.action.VIEW");
            intent.setFlags(268435456);
            if (Build.VERSION.SDK_INT >= 24) {
                Uri uriForFile = FileProvider.getUriForFile(context, context.getPackageName() + ".download.file.provider", file);
                intent.addFlags(1);
                intent.setDataAndType(uriForFile, "application/vnd.android.package-archive");
            } else {
                intent.setDataAndType(Uri.fromFile(file), "application/vnd.android.package-archive");
            }
            context.startActivity(intent);
        } catch (Exception e2) {
            Log.e(a, e2.getMessage());
        }
    }

    public final boolean s() {
        Intent intent = new Intent();
        intent.setAction("android.intent.action.DOWNLOAD_COMPLETE");
        List<ResolveInfo> queryBroadcastReceivers = this.c.getPackageManager().queryBroadcastReceivers(intent, 0);
        boolean z = false;
        if (queryBroadcastReceivers != null) {
            z = false;
            if (!queryBroadcastReceivers.isEmpty()) {
                z = true;
            }
        }
        return z;
    }

    public final void v() {
        s();
        y();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.DOWNLOAD_COMPLETE");
        Context context = this.c;
        DownLoadBroadcast downLoadBroadcast = new DownLoadBroadcast(this, (1) null);
        this.i = downLoadBroadcast;
        context.registerReceiver(downLoadBroadcast, intentFilter);
        s();
    }

    public final void w() {
        z();
        ContentResolver contentResolver = this.c.getContentResolver();
        Uri parse = Uri.parse("content://downloads/my_downloads");
        DownloadChangeObserver downloadChangeObserver = new DownloadChangeObserver(this);
        this.h = downloadChangeObserver;
        contentResolver.registerContentObserver(parse, false, downloadChangeObserver);
    }

    public final void x() {
        o();
        y();
        z();
    }

    public final void y() {
        BroadcastReceiver broadcastReceiver = this.i;
        if (broadcastReceiver != null) {
            try {
                this.c.unregisterReceiver(broadcastReceiver);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            this.i = null;
        }
    }

    public final void z() {
        if (this.h != null) {
            try {
                this.c.getContentResolver().unregisterContentObserver(this.h);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            this.h = null;
        }
    }
}
