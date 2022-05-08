package com.ibox.nft.base.manager.download.file;

import android.os.AsyncTask;
import android.text.TextUtils;
import com.ibox.libs.common.manager.LocalControlTool;
import com.ibox.libs.common.utils.FileTool;
import com.ibox.libs.common.utils.LogTool;
import com.ibox.nft.base.manager.download.VersionDownloadTool;
import com.mob.apc.APCException;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/* loaded from: DownloadFileTask.class */
public class DownloadFileTask extends AsyncTask<String, Integer, File> {
    public String a;

    /* renamed from: b  reason: collision with root package name */
    public String f414b;
    public String c;

    /* renamed from: d  reason: collision with root package name */
    public DownloadFileCallback f415d;

    /* loaded from: DownloadFileTask$Builder.class */
    public static class Builder {
        public String a;

        /* renamed from: b  reason: collision with root package name */
        public String f416b;
        public String c;

        /* renamed from: d  reason: collision with root package name */
        public DownloadFileCallback f417d;

        public DownloadFileTask a() {
            return new DownloadFileTask(this);
        }

        public DownloadFileCallback b() {
            return this.f417d;
        }

        public String c() {
            return this.c;
        }

        public String d() {
            return this.a;
        }

        public String e() {
            return this.f416b;
        }

        public Builder f(DownloadFileCallback downloadFileCallback) {
            this.f417d = downloadFileCallback;
            return this;
        }

        public Builder g(String str) {
            this.c = str;
            return this;
        }

        public Builder h(String str) {
            this.a = str;
            return this;
        }

        public Builder i(String str) {
            this.f416b = str;
            return this;
        }
    }

    public DownloadFileTask(Builder builder) {
        this.a = builder.d();
        this.f414b = builder.e();
        this.c = builder.c();
        this.f415d = builder.b();
    }

    /* renamed from: a */
    public File doInBackground(String... strArr) {
        LogTool.a("####### [DownloadFile]  ------ doInBackground ");
        if (TextUtils.isEmpty(this.a)) {
            DownloadFileCallback downloadFileCallback = this.f415d;
            if (downloadFileCallback == null) {
                return null;
            }
            downloadFileCallback.c(APCException.AIDL_ERROR_CODE_SERVICE_BINDER_NULL_OR_TIMEOUT, "", this.a, new Exception("File URL is NULL!"));
            return null;
        }
        LogTool.a("####### [DownloadFile]  ------ doInBackground ----------- 1");
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(this.a).openConnection();
            int contentLength = httpURLConnection.getContentLength();
            httpURLConnection.getResponseCode();
            InputStream inputStream = httpURLConnection.getInputStream();
            LogTool.a("####### [DownloadFile]  ------ doInBackground ----------- 2");
            String str = "/sdcard/iBox/download/" + this.c;
            if (contentLength != -1) {
                String str2 = this.f414b;
                String str3 = str2;
                if (TextUtils.isEmpty(str2)) {
                    str3 = LocalControlTool.g();
                }
                LogTool.a("####### [DownloadFile]  ------ doInBackground ----------- 1");
                String str4 = this.c;
                String str5 = str4;
                if (TextUtils.isEmpty(str4)) {
                    str5 = VersionDownloadTool.f(this.a);
                }
                FileTool.a(str3);
                String str6 = str3 + File.separator + str5;
                LogTool.a("####### [DownloadFile]  ------ doInBackground ----------- 4");
                File file = new File(str6);
                if (file.exists()) {
                    file.delete();
                }
                String str7 = str6 + ".temp";
                LogTool.a("fileDirPath: " + str3 + "\nfilePath: " + str7);
                FileOutputStream fileOutputStream = new FileOutputStream(new File(str7));
                LogTool.a("####### [DownloadFile]  ------ doInBackground ----------- 5");
                byte[] bArr = new byte[1024];
                int i = 0;
                int i2 = 0;
                while (true) {
                    int read = inputStream.read(bArr);
                    if (read == -1) {
                        break;
                    }
                    fileOutputStream.write(bArr, 0, read);
                    int i3 = i + read;
                    int i4 = (i3 * 100) / contentLength;
                    i = i3;
                    if (i4 % 5 == 0) {
                        i = i3;
                        if (i4 != i2) {
                            publishProgress(Integer.valueOf(i4));
                            i2 = i4;
                            i = i3;
                        }
                    }
                }
                fileOutputStream.flush();
                fileOutputStream.close();
                str = str7;
            }
            inputStream.close();
            LogTool.a("####### [DownloadFile]  ------ doInBackground ----------- 6");
            return new File(str);
        } catch (RuntimeException e2) {
            LogTool.a("####### [DownloadFile]  ------ doInBackground ----------- 7");
            DownloadFileCallback downloadFileCallback2 = this.f415d;
            if (downloadFileCallback2 == null) {
                return null;
            }
            downloadFileCallback2.c(-1, "", this.a, e2);
            return null;
        } catch (Exception e3) {
            LogTool.a("####### [DownloadFile]  ------ doInBackground ----------- 8");
            DownloadFileCallback downloadFileCallback3 = this.f415d;
            if (downloadFileCallback3 == null) {
                return null;
            }
            downloadFileCallback3.c(-1, "", this.a, e3);
            return null;
        }
    }

    public final void b(File file) {
        LogTool.a("####### [DownloadFile]  ------ doInBackground ----------- 10");
        if (file == null) {
            DownloadFileCallback downloadFileCallback = this.f415d;
            if (downloadFileCallback != null) {
                downloadFileCallback.c(-1, "", this.a, new Exception("File is not exits!"));
                return;
            }
            return;
        }
        DownloadFileCallback downloadFileCallback2 = this.f415d;
        if (downloadFileCallback2 != null) {
            downloadFileCallback2.d(this.a, file);
        }
    }

    /* renamed from: c */
    public void onPostExecute(File file) {
        LogTool.a("####### [DownloadFile]  ------ doInBackground ----------- 9");
        if (file != null && file.exists()) {
            String trim = file.getName().replace(".temp", "").trim();
            File file2 = new File(file.getParent() + File.separator + trim);
            file.renameTo(file2);
            b(file2);
        }
    }

    /* renamed from: d */
    public void onProgressUpdate(Integer... numArr) {
        DownloadFileCallback downloadFileCallback = this.f415d;
        if (downloadFileCallback != null) {
            downloadFileCallback.b(this.a, numArr);
        }
    }

    @Override // android.os.AsyncTask
    public void onPreExecute() {
        DownloadFileCallback downloadFileCallback = this.f415d;
        if (downloadFileCallback != null) {
            downloadFileCallback.a();
        }
    }
}
