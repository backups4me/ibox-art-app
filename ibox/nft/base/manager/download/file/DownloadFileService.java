package com.ibox.nft.base.manager.download.file;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.ibox.libs.common.utils.ContextTool;
import com.ibox.libs.common.utils.FileTool;
import com.ibox.libs.common.utils.LogTool;
import com.ibox.libs.common.utils.MD5Tool;
import com.ibox.nft.base.manager.download.file.DownloadFileTask;
import com.stub.StubApp;
import d.c.d.d.f.a.c.a;
import java.io.File;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

/* loaded from: DownloadFileService.class */
public class DownloadFileService extends IntentService {

    /* renamed from: b  reason: collision with root package name */
    public static boolean f410b;
    public static Context c;

    /* renamed from: d  reason: collision with root package name */
    public static DownloadFileService f411d;

    /* renamed from: e  reason: collision with root package name */
    public Resources f412e;
    public DownloadFileManager f;
    public DownloadFileTask g;
    public DownloadFileCallback h;
    public String j;
    public LinkedList<String> k;
    public Object i = new Object();
    public Handler l = new Handler(a.f1152b);

    static {
        StubApp.interface11(3924);
    }

    public DownloadFileService() {
        super("IBoxDownloadFileService");
    }

    public static DownloadFileService j() {
        if (f411d == null) {
            f411d = new DownloadFileService();
        }
        return f411d;
    }

    public final void d() {
        stopSelf();
        f410b = false;
    }

    public final LinkedList<String> e(List<String> list) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        LinkedList<String> linkedList = new LinkedList<>();
        for (String str : list) {
            linkedList.push(str);
        }
        return linkedList;
    }

    public final DownloadFileTask f(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        this.f412e = getResources();
        DownloadFileTask a = new DownloadFileTask.Builder().h(str).i(str2).g(i(str)).f(new DownloadFileCallback(this, str) { // from class: com.ibox.nft.base.manager.download.file.DownloadFileService.1
            public final String a;

            /* renamed from: b  reason: collision with root package name */
            public final DownloadFileService f413b;

            {
                this.f413b = this;
                this.a = str;
            }

            @Override // com.ibox.nft.base.manager.download.file.DownloadFileCallback
            public void a() {
                LogTool.a("###### [DownloadFile]  ------ Pre_url: " + this.a);
                if (this.f413b.h != null) {
                    this.f413b.h.a();
                }
            }

            @Override // com.ibox.nft.base.manager.download.file.DownloadFileCallback
            public void b(String str3, Integer... numArr) {
                if (this.f413b.h != null) {
                    this.f413b.h.b(str3, numArr);
                }
            }

            @Override // com.ibox.nft.base.manager.download.file.DownloadFileCallback
            public void c(int i, String str3, String str4, Exception exc) {
                LogTool.a("####### [DownloadFile]  ------ onFail_url: " + str4);
                this.f413b.g();
                if (this.f413b.h != null) {
                    this.f413b.h.c(i, str3, str4, exc);
                }
            }

            @Override // com.ibox.nft.base.manager.download.file.DownloadFileCallback
            public void d(String str3, File file) {
                LogTool.a("####### [DownloadFile]  ------ onFinish_url: " + str3);
                this.f413b.h(file);
                if (this.f413b.h != null) {
                    this.f413b.h.d(str3, file);
                }
            }
        }).a();
        a.execute(new String[0]);
        return a;
    }

    public final void g() {
        LogTool.a("####### [DownloadFile]  ------ downloadFailure");
        this.g = null;
        LinkedList<String> linkedList = this.k;
        if (linkedList == null || linkedList.isEmpty()) {
            d();
            return;
        }
        String pop = this.k.pop();
        LogTool.a("####### [DownloadFile]  ------ downloadFailure_urlSize: " + this.k.size());
        this.g = f(pop, this.j);
    }

    public final void h(File file) {
        LogTool.a("####### [DownloadFile]  ------ downloadSuccess");
        this.g = null;
        LinkedList<String> linkedList = this.k;
        if (linkedList == null || linkedList.isEmpty()) {
            d();
            return;
        }
        String pop = this.k.pop();
        LogTool.a("####### [DownloadFile]  ------ downloadSuccess_urlSize: " + this.k.size());
        this.g = f(pop, this.j);
    }

    public final String i(String str) {
        return MD5Tool.b(str) + FileTool.m(str);
    }

    public Intent l(Context context, @NonNull DownloadFileManager downloadFileManager) {
        LogTool.a("###### [DownloadFile]  ------ DownloadFileService_startService");
        if (!ContextTool.c(context)) {
            return null;
        }
        c = context;
        try {
            Bundle bundle = new Bundle();
            bundle.putSerializable("DownloadFileManager", downloadFileManager);
            Intent intent = new Intent(context, DownloadFileService.class);
            intent.putExtras(bundle);
            context.startService(intent);
            return intent;
        } catch (IllegalStateException e2) {
            LogTool.e(e2);
            return null;
        }
    }

    public void m(Context context, Intent intent) {
        if (ContextTool.c(context)) {
            context.stopService(intent);
        }
    }

    public void n() {
        DownloadFileTask downloadFileTask = this.g;
        if (downloadFileTask != null) {
            downloadFileTask.cancel(true);
        }
    }

    @Override // android.app.IntentService, android.app.Service
    public void onCreate() {
        super.onCreate();
    }

    @Override // android.app.IntentService, android.app.Service
    public void onDestroy() {
        super.onDestroy();
        n();
    }

    @Override // android.app.IntentService
    public void onHandleIntent(Intent intent) {
        if (intent == null) {
            d();
            return;
        }
        Serializable serializableExtra = intent.getSerializableExtra("DownloadFileManager");
        if (serializableExtra != null && (serializableExtra instanceof DownloadFileManager)) {
            DownloadFileManager downloadFileManager = (DownloadFileManager) serializableExtra;
            this.f = downloadFileManager;
            this.j = downloadFileManager.getTargetPath();
            this.k = e(this.f.getFileUrlList());
            this.h = this.f.getDownloadCallback();
        }
        if (this.f == null) {
            d();
            return;
        }
        LinkedList<String> linkedList = this.k;
        if (linkedList == null || linkedList.isEmpty()) {
            d();
            return;
        }
        LogTool.a("###### [DownloadFile]  ------ DownloadFileService_onHandleIntent_urlSize: " + this.k.size());
        this.g = f(this.k.pop(), this.j);
    }
}
