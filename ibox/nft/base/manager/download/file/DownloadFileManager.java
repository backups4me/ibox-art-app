package com.ibox.nft.base.manager.download.file;

import java.io.Serializable;
import java.util.List;

/* loaded from: DownloadFileManager.class */
public class DownloadFileManager implements Serializable {
    private DownloadFileCallback downloadCallback;
    private String fileNameWithSuffix;
    private List<String> fileUrlList;
    private String targetPath;

    /* loaded from: DownloadFileManager$Builder.class */
    public static class Builder {
        public List<String> a;

        /* renamed from: b  reason: collision with root package name */
        public String f408b;
        public String c;

        /* renamed from: d  reason: collision with root package name */
        public DownloadFileCallback f409d;

        public DownloadFileManager a() {
            return new DownloadFileManager(this);
        }

        public DownloadFileCallback b() {
            return this.f409d;
        }

        public String c() {
            return this.c;
        }

        public List<String> d() {
            return this.a;
        }

        public String e() {
            return this.f408b;
        }

        public Builder f(DownloadFileCallback downloadFileCallback) {
            this.f409d = downloadFileCallback;
            return this;
        }

        public Builder g(String str) {
            this.c = str;
            return this;
        }

        public Builder h(List<String> list) {
            this.a = list;
            return this;
        }

        public Builder i(String str) {
            this.f408b = str;
            return this;
        }
    }

    public DownloadFileManager() {
        throw new UnsupportedOperationException("cannot be instantiated");
    }

    public DownloadFileManager(Builder builder) {
        this.fileUrlList = builder.d();
        this.targetPath = builder.e();
        this.fileNameWithSuffix = builder.c();
        this.downloadCallback = builder.b();
    }

    public DownloadFileCallback getDownloadCallback() {
        return this.downloadCallback;
    }

    public String getFileNameWithSuffix() {
        return this.fileNameWithSuffix;
    }

    public List<String> getFileUrlList() {
        return this.fileUrlList;
    }

    public String getTargetPath() {
        return this.targetPath;
    }
}
