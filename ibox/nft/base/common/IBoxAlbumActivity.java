package com.ibox.nft.base.common;

import android.content.ContentUris;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.provider.DocumentsContract;
import android.provider.MediaStore;
import androidx.annotation.NonNull;
import androidx.core.content.FileProvider;
import com.ibox.certificate.camera.CertCameraActivity;
import com.ibox.certificate.camera.CertCameraTypeEnum;
import com.ibox.libs.common.utils.ClickTool;
import com.ibox.libs.common.utils.ContextTool;
import com.ibox.libs.common.utils.DisplayTool;
import com.ibox.libs.common.utils.FileTool;
import com.ibox.libs.common.utils.LogTool;
import com.ibox.libs.common.utils.StringTool;
import com.ibox.libs.common.utils.ToastTool;
import com.ibox.nft.base.R;
import com.ibox.nft.base.common.IBoxAlbumActivity;
import com.ibox.nft.base.mvp.IBoxActivityPresenter;
import com.ibox.nft.base.mvp.IBoxUI;
import com.ibox.nft.base.utils.PermissionTool;
import com.ibox.nft.base.widgets.dialog.album.PickImagePopWindow;
import com.igexin.push.core.c;
import com.lzr.takephoto.manager.TakePhotoManager;
import com.lzr.takephoto.manager.TakePhotoResult;
import com.lzr.takephoto.manager.UTakePhoto;
import d.c.d.d.b.h;
import io.reactivex.rxjava3.functions.Consumer;
import java.io.File;
import java.util.List;

/* loaded from: IBoxAlbumActivity.class */
public abstract class IBoxAlbumActivity<P extends IBoxActivityPresenter<V>, V extends IBoxUI> extends IBoxBaseActivity<P, V> {
    public int l = 0;
    public String m = "ibox_take_photo.jpg";
    public String n = "ibox_take_video.mp4";
    public String o = "uic_crop.jpg";

    /* loaded from: IBoxAlbumActivity$OnCheckPermissionCallback.class */
    public interface OnCheckPermissionCallback {
        void a();
    }

    public static /* synthetic */ void Q1(OnCheckPermissionCallback onCheckPermissionCallback, Boolean bool) throws Throwable {
        LogTool.a("Permission result " + bool);
        if (!bool.booleanValue()) {
            ToastTool.g("请到设置-应用管理中打开存储和摄像机权限");
        } else if (onCheckPermissionCallback != null) {
            onCheckPermissionCallback.a();
        }
    }

    public static /* synthetic */ void R1(Throwable th) throws Throwable {
        LogTool.e(th);
        ToastTool.f("请到设置-应用管理中打开存储和摄像机权限");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: S1 */
    public /* synthetic */ void T1(int i) {
        DisplayTool.c(this);
        UTakePhoto.a.a(this).m(TakePhotoManager.Mode.ALBUM).a(false).t(1024).s(1.0f).u(DisplayTool.a(800.0f), DisplayTool.a(800.0f)).f().o(new TakePhotoResult(this, i) { // from class: com.ibox.nft.base.common.IBoxAlbumActivity.3
            public final int a;

            /* renamed from: b  reason: collision with root package name */
            public final IBoxAlbumActivity f385b;

            {
                this.f385b = this;
                this.a = i;
            }

            @Override // com.lzr.takephoto.manager.TakePhotoResult
            public void a() {
                LogTool.a("取消选择图片");
            }

            @Override // com.lzr.takephoto.manager.TakePhotoResult
            public void b(Exception exc) {
                ToastTool.f(exc.getMessage());
            }

            @Override // com.lzr.takephoto.manager.TakePhotoResult
            public void c(String str) {
                this.f385b.M1(this.a, str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: U1 */
    public /* synthetic */ void V1(int i, String str) {
        Intent intent;
        this.l = i;
        this.m = str;
        if (Build.VERSION.SDK_INT < 19) {
            intent = new Intent("android.intent.action.GET_CONTENT");
            intent.setType("image/*");
        } else {
            intent = new Intent("android.intent.action.PICK", MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        }
        startActivityForResult(intent, 129);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: W1 */
    public /* synthetic */ void X1() {
        CertCameraActivity.o(this, 133, CertCameraTypeEnum.TYPE_ID_CARD_BACK.type);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: Y1 */
    public /* synthetic */ void Z1(int i, int i2) {
        if (ClickTool.b(1000)) {
            if (i2 == 0) {
                L1(new OnCheckPermissionCallback(this) { // from class: d.c.d.d.b.g
                    public final IBoxAlbumActivity a;

                    {
                        this.a = this;
                    }

                    @Override // com.ibox.nft.base.common.IBoxAlbumActivity.OnCheckPermissionCallback
                    public final void a() {
                        this.a.X1();
                    }
                });
            } else if (i2 == 1) {
                m2(i);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: a2 */
    public /* synthetic */ void b2() {
        CertCameraActivity.o(this, 132, CertCameraTypeEnum.TYPE_ID_CARD_FRONT.type);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c2 */
    public /* synthetic */ void d2(int i, int i2) {
        if (ClickTool.b(1000)) {
            if (i2 == 0) {
                L1(new OnCheckPermissionCallback(this) { // from class: d.c.d.d.b.i
                    public final IBoxAlbumActivity a;

                    {
                        this.a = this;
                    }

                    @Override // com.ibox.nft.base.common.IBoxAlbumActivity.OnCheckPermissionCallback
                    public final void a() {
                        this.a.b2();
                    }
                });
            } else if (i2 == 1) {
                m2(i);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: e2 */
    public /* synthetic */ void f2(int i, int i2, int i3, int i4) {
        TakePhotoManager.Mode mode = TakePhotoManager.Mode.ALBUM;
        if (i == 0) {
            mode = TakePhotoManager.Mode.CAMERA;
        }
        UTakePhoto.a.a(this).m(mode).a(true).r(i2, i3).s(0.8f).f().o(new TakePhotoResult(this, i4) { // from class: com.ibox.nft.base.common.IBoxAlbumActivity.1
            public final int a;

            /* renamed from: b  reason: collision with root package name */
            public final IBoxAlbumActivity f384b;

            {
                this.f384b = this;
                this.a = i4;
            }

            @Override // com.lzr.takephoto.manager.TakePhotoResult
            public void a() {
                LogTool.a("取消选择图片");
            }

            @Override // com.lzr.takephoto.manager.TakePhotoResult
            public void b(Exception exc) {
                ToastTool.f(exc.getMessage());
            }

            @Override // com.lzr.takephoto.manager.TakePhotoResult
            public void c(String str) {
                this.f384b.M1(this.a, str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: g2 */
    public /* synthetic */ void h2(final int i, final int i2, final int i3, final int i4) {
        if (ClickTool.b(1000)) {
            L1(new OnCheckPermissionCallback(this, i4, i, i2, i3) { // from class: d.c.d.d.b.b
                public final IBoxAlbumActivity a;

                /* renamed from: b  reason: collision with root package name */
                public final int f1128b;
                public final int c;

                /* renamed from: d  reason: collision with root package name */
                public final int f1129d;

                /* renamed from: e  reason: collision with root package name */
                public final int f1130e;

                {
                    this.a = this;
                    this.f1128b = i4;
                    this.c = i;
                    this.f1129d = i2;
                    this.f1130e = i3;
                }

                @Override // com.ibox.nft.base.common.IBoxAlbumActivity.OnCheckPermissionCallback
                public final void a() {
                    this.a.f2(this.f1128b, this.c, this.f1129d, this.f1130e);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: i2 */
    public /* synthetic */ void j2(int i, String str) {
        Uri uri;
        this.l = i;
        this.m = str;
        Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
        File j = FileTool.j(this, c.ae, this.m);
        if (j == null || j.getParentFile() == null || !j.getParentFile().exists()) {
            j.getParentFile().mkdirs();
        }
        if (Build.VERSION.SDK_INT >= 24) {
            uri = FileProvider.getUriForFile(this, getPackageName() + ".album.file.provider", j);
            intent.setFlags(2);
        } else {
            uri = Uri.fromFile(j);
        }
        intent.putExtra("orientation", 0);
        intent.putExtra("output", uri);
        startActivityForResult(intent, 128);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: k2 */
    public /* synthetic */ void l2(int i, String str) {
        Uri uri;
        this.l = i;
        this.n = str;
        Intent intent = new Intent("android.media.action.VIDEO_CAPTURE");
        File j = FileTool.j(this, "video", this.n);
        if (j == null || j.getParentFile() == null || !j.getParentFile().exists()) {
            j.getParentFile().mkdirs();
        }
        if (Build.VERSION.SDK_INT >= 24) {
            uri = FileProvider.getUriForFile(this, getPackageName() + ".album.file.provider", j);
            intent.setFlags(2);
        } else {
            uri = Uri.fromFile(j);
        }
        intent.putExtra("orientation", 0);
        intent.putExtra("output", uri);
        startActivityForResult(intent, 131);
    }

    public final void L1(final OnCheckPermissionCallback onCheckPermissionCallback) {
        PermissionTool.d(this, new Consumer(onCheckPermissionCallback) { // from class: d.c.d.d.b.e

            /* renamed from: b  reason: collision with root package name */
            public final IBoxAlbumActivity.OnCheckPermissionCallback f1134b;

            {
                this.f1134b = onCheckPermissionCallback;
            }

            @Override // io.reactivex.rxjava3.functions.Consumer
            public final void accept(Object obj) {
                IBoxAlbumActivity.Q1(this.f1134b, (Boolean) obj);
            }
        }, h.f1136b);
    }

    public void M1(int i, String str) {
    }

    public final String N1(Context context, Uri uri, String str) {
        String str2;
        if (!ContextTool.c(context)) {
            return "";
        }
        String str3 = "";
        try {
            Cursor query = context.getContentResolver().query(uri, null, str, null, null);
            str2 = "";
            if (query != null) {
                str2 = "";
                if (query.moveToFirst()) {
                    str2 = query.getString(query.getColumnIndex("_data"));
                }
                str3 = str2;
                query.close();
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            str2 = str3;
        }
        return str2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final String O1(Intent intent) {
        Cursor managedQuery = managedQuery(intent.getData(), new String[]{"_data"}, null, null, null);
        int columnIndexOrThrow = managedQuery.getColumnIndexOrThrow("_data");
        managedQuery.moveToFirst();
        return managedQuery.getString(columnIndexOrThrow);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Uri P1(Context context, Intent intent) {
        String str;
        String N1;
        if (!ContextTool.c(context) || intent == null || intent.getData() == null) {
            return null;
        }
        Uri data = intent.getData();
        int i = Build.VERSION.SDK_INT;
        if (i >= 24) {
            if (!"file".equalsIgnoreCase(data.getScheme())) {
                return data;
            }
            str = data.getPath();
        } else if (i < 19) {
            str = N1(context, intent.getData(), null);
        } else if (DocumentsContract.isDocumentUri(context, data)) {
            String documentId = DocumentsContract.getDocumentId(data);
            if ("com.android.providers.media.documents".equals(data.getAuthority())) {
                N1 = N1(context, MediaStore.Images.Media.EXTERNAL_CONTENT_URI, "_id=" + documentId.split(":")[1]);
            } else {
                str = null;
                if ("com.android.providers.downloads.documents".equals(data.getAuthority())) {
                    N1 = N1(context, ContentUris.withAppendedId(Uri.parse("content://downloads/public_downloads"), Long.valueOf(documentId).longValue()), null);
                }
            }
            str = N1;
        } else if ("content".equalsIgnoreCase(data.getScheme())) {
            str = N1(context, data, null);
        } else {
            str = null;
            if ("file".equalsIgnoreCase(data.getScheme())) {
                str = data.getPath();
            }
        }
        File file = new File(str);
        if (i < 24) {
            return Uri.fromFile(file);
        }
        return FileProvider.getUriForFile(this, getPackageName() + ".album.file.provider", file);
    }

    public final void m2(final int i) {
        L1(new OnCheckPermissionCallback(this, i) { // from class: d.c.d.d.b.l
            public final IBoxAlbumActivity a;

            /* renamed from: b  reason: collision with root package name */
            public final int f1139b;

            {
                this.a = this;
                this.f1139b = i;
            }

            @Override // com.ibox.nft.base.common.IBoxAlbumActivity.OnCheckPermissionCallback
            public final void a() {
                this.a.T1(this.f1139b);
            }
        });
    }

    public void n2(final int i, final String str) {
        L1(new OnCheckPermissionCallback(this, i, str) { // from class: d.c.d.d.b.a
            public final IBoxAlbumActivity a;

            /* renamed from: b  reason: collision with root package name */
            public final int f1127b;
            public final String c;

            {
                this.a = this;
                this.f1127b = i;
                this.c = str;
            }

            @Override // com.ibox.nft.base.common.IBoxAlbumActivity.OnCheckPermissionCallback
            public final void a() {
                this.a.V1(this.f1127b, this.c);
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void o2(final int i) {
        this.l = i;
        new PickImagePopWindow(this, new PickImagePopWindow.SelectListener(this, i) { // from class: d.c.d.d.b.k
            public final IBoxAlbumActivity a;

            /* renamed from: b  reason: collision with root package name */
            public final int f1138b;

            {
                this.a = this;
                this.f1138b = i;
            }

            @Override // com.ibox.nft.base.widgets.dialog.album.PickImagePopWindow.SelectListener
            public final void a(int i2) {
                this.a.Z1(this.f1138b, i2);
            }
        }).e();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.ibox.nft.base.mvp.IBoxMVPActivity
    public void onActivityResult(int i, int i2, Intent intent) {
        Uri uri;
        Uri uri2;
        if (i != 0) {
            if (-1 == i2) {
                if (128 == i) {
                    File j = FileTool.j(this, c.ae, this.m);
                    if (Build.VERSION.SDK_INT >= 24) {
                        uri2 = FileProvider.getUriForFile(this, getPackageName() + ".album.file.provider", j);
                    } else {
                        uri2 = Uri.fromFile(j);
                    }
                    s2(uri2);
                } else if (129 == i) {
                    if (Build.VERSION.SDK_INT >= 26) {
                        s2(P1(this, intent));
                    } else {
                        String O1 = O1(intent);
                        this.o = O1;
                        M1(this.l, O1);
                    }
                } else if (130 == i) {
                    M1(this.l, this.o);
                    if (intent != null) {
                        intent.putExtra("cropImageRetName", this.o);
                    }
                } else if (132 == i || 133 == i) {
                    M1(this.l, CertCameraActivity.d(intent));
                } else if (131 == i) {
                    File j2 = FileTool.j(this, "video", this.n);
                    if (Build.VERSION.SDK_INT >= 24) {
                        uri = FileProvider.getUriForFile(this, getPackageName() + ".album.file.provider", j2);
                    } else {
                        uri = Uri.fromFile(j2);
                    }
                    LogTool.a("###### 录像本地存储地址：" + uri.getPath());
                    M1(this.l, uri.getPath());
                }
            }
            super.onActivityResult(i, i2, intent);
        }
    }

    @Override // com.ibox.nft.base.common.IBoxBaseActivity, pub.devrel.easypermissions.EasyPermissions.PermissionCallbacks
    public void onPermissionsDenied(int i, @NonNull List list) {
        if (128 == i) {
            ToastTool.f(StringTool.b(R.string.hint_wmxyfwsxt));
        } else if (129 == i) {
            ToastTool.f(StringTool.b(R.string.activity_main_permission_storage));
        } else if (18283 == i) {
            ToastTool.f(StringTool.b(R.string.hint_wmxyfwmkf));
        }
    }

    @Override // com.ibox.nft.base.common.IBoxBaseActivity, pub.devrel.easypermissions.EasyPermissions.PermissionCallbacks
    public void onPermissionsGranted(int i, @NonNull List list) {
        if (128 == i) {
            if (list.size() > 1) {
                t2(this.l, this.m);
            }
        } else if (129 == i) {
            n2(this.l, this.m);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void p2(final int i) {
        this.l = i;
        new PickImagePopWindow(this, new PickImagePopWindow.SelectListener(this, i) { // from class: d.c.d.d.b.j
            public final IBoxAlbumActivity a;

            /* renamed from: b  reason: collision with root package name */
            public final int f1137b;

            {
                this.a = this;
                this.f1137b = i;
            }

            @Override // com.ibox.nft.base.widgets.dialog.album.PickImagePopWindow.SelectListener
            public final void a(int i2) {
                this.a.d2(this.f1137b, i2);
            }
        }).e();
    }

    public void q2(int i) {
        r2(i, 1, 1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void r2(final int i, final int i2, final int i3) {
        this.l = i;
        new PickImagePopWindow(this, new PickImagePopWindow.SelectListener(this, i2, i3, i) { // from class: d.c.d.d.b.d
            public final IBoxAlbumActivity a;

            /* renamed from: b  reason: collision with root package name */
            public final int f1132b;
            public final int c;

            /* renamed from: d  reason: collision with root package name */
            public final int f1133d;

            {
                this.a = this;
                this.f1132b = i2;
                this.c = i3;
                this.f1133d = i;
            }

            @Override // com.ibox.nft.base.widgets.dialog.album.PickImagePopWindow.SelectListener
            public final void a(int i4) {
                this.a.h2(this.f1132b, this.c, this.f1133d, i4);
            }
        }).e();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void s2(Uri uri) {
        if (uri != null) {
            Intent intent = new Intent("com.android.camera.action.CROP");
            intent.setDataAndType(uri, "image/*");
            if (Build.VERSION.SDK_INT >= 24) {
                intent.addFlags(1);
            }
            intent.putExtra("crop", true);
            intent.putExtra("aspectX", 1);
            intent.putExtra("aspectY", 1);
            intent.putExtra("return-data", false);
            this.o = getExternalCacheDir().getAbsolutePath() + "/image/uic_" + System.currentTimeMillis() + "crop.jpg";
            File file = new File(this.o);
            if (!file.getParentFile().exists()) {
                file.getParentFile().mkdirs();
            }
            intent.putExtra("output", Uri.fromFile(file));
            intent.putExtra("outputFormat", Bitmap.CompressFormat.JPEG.toString());
            try {
                startActivityForResult(intent, 130);
            } catch (Exception e2) {
                e2.printStackTrace();
                ToastTool.f("裁剪图片错误");
            }
        }
    }

    public void t2(final int i, final String str) {
        L1(new OnCheckPermissionCallback(this, i, str) { // from class: d.c.d.d.b.f
            public final IBoxAlbumActivity a;

            /* renamed from: b  reason: collision with root package name */
            public final int f1135b;
            public final String c;

            {
                this.a = this;
                this.f1135b = i;
                this.c = str;
            }

            @Override // com.ibox.nft.base.common.IBoxAlbumActivity.OnCheckPermissionCallback
            public final void a() {
                this.a.j2(this.f1135b, this.c);
            }
        });
    }

    public void u2(final int i, final String str) {
        L1(new OnCheckPermissionCallback(this, i, str) { // from class: d.c.d.d.b.c
            public final IBoxAlbumActivity a;

            /* renamed from: b  reason: collision with root package name */
            public final int f1131b;
            public final String c;

            {
                this.a = this;
                this.f1131b = i;
                this.c = str;
            }

            @Override // com.ibox.nft.base.common.IBoxAlbumActivity.OnCheckPermissionCallback
            public final void a() {
                this.a.l2(this.f1131b, this.c);
            }
        });
    }
}
