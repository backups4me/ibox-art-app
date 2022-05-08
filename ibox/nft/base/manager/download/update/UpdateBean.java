package com.ibox.nft.base.manager.download.update;

import android.text.TextUtils;
import android.view.View;
import androidx.annotation.NonNull;
import com.ibox.libs.common.manager.LocalControlTool;
import com.ibox.nft.base.manager.download.DownloadCallback;
import com.ibox.nft.base.manager.download.VersionDownloadTool;
import java.io.Serializable;

/* loaded from: UpdateBean.class */
public class UpdateBean implements Serializable {
    private String dialogTitle;
    private View dialogView;
    private DownloadCallback downloadCallback;
    private String fileNameWithSuffix;
    private IVersionBean iVersionBean;
    private String targetPath;
    private UpdateCallback updateCallback;
    private boolean isDismissNotification = false;
    private boolean isShowDialog = false;
    private boolean isIgnoreVersion = false;
    private boolean isOnlyWifi = true;
    private int notifyIconResId = 0;

    public UpdateBean(@NonNull IVersionBean iVersionBean) {
        this.iVersionBean = iVersionBean;
    }

    public String getDialogTitle() {
        return this.dialogTitle;
    }

    public View getDialogView() {
        return this.dialogView;
    }

    public DownloadCallback getDownloadCallback() {
        return this.downloadCallback;
    }

    public String getFileNameWithSuffix() {
        return TextUtils.isEmpty(this.fileNameWithSuffix) ? VersionDownloadTool.e(this) : this.fileNameWithSuffix;
    }

    public String getNewVersion() {
        IVersionBean iVersionBean = this.iVersionBean;
        if (iVersionBean != null) {
            return iVersionBean.a();
        }
        return null;
    }

    public String getNewVersionLog() {
        IVersionBean iVersionBean = this.iVersionBean;
        if (iVersionBean != null) {
            return iVersionBean.d();
        }
        return null;
    }

    public String getNewVersionUrl() {
        IVersionBean iVersionBean = this.iVersionBean;
        if (iVersionBean != null) {
            return iVersionBean.c();
        }
        return null;
    }

    public int getNotifyIconResId() {
        return this.notifyIconResId;
    }

    public String getTargetPath() {
        return TextUtils.isEmpty(this.targetPath) ? LocalControlTool.g() : this.targetPath;
    }

    public UpdateCallback getUpdateCallback() {
        return this.updateCallback;
    }

    public boolean hasNewVersion() {
        IVersionBean iVersionBean = this.iVersionBean;
        if (iVersionBean != null) {
            return iVersionBean.f();
        }
        return false;
    }

    public boolean isDismissNotification() {
        return this.isDismissNotification;
    }

    public boolean isForcedUpdate() {
        IVersionBean iVersionBean = this.iVersionBean;
        if (iVersionBean != null) {
            return iVersionBean.e();
        }
        return false;
    }

    public boolean isIgnoreVersion() {
        IVersionBean iVersionBean = this.iVersionBean;
        if (iVersionBean != null) {
            return iVersionBean.b();
        }
        return false;
    }

    public boolean isOnlyWifi() {
        return this.isOnlyWifi;
    }

    public boolean isShowDialog() {
        return this.isShowDialog;
    }

    public void setDialogTitle(String str) {
        this.dialogTitle = str;
    }

    public void setDialogView(View view) {
        this.dialogView = view;
    }

    public void setDismissNotification(boolean z) {
        this.isDismissNotification = z;
    }

    public void setDownloadCallback(DownloadCallback downloadCallback) {
        this.downloadCallback = downloadCallback;
    }

    public void setFileNameWithSuffix(String str) {
        this.fileNameWithSuffix = str;
    }

    public void setNotifyIconResId(int i) {
        this.notifyIconResId = i;
    }

    public void setOnlyWifi(boolean z) {
        this.isOnlyWifi = z;
    }

    public void setShowDialog(boolean z) {
        this.isShowDialog = z;
    }

    public void setTargetPath(String str) {
        this.targetPath = str;
    }

    public void setUpdateCallback(UpdateCallback updateCallback) {
        this.updateCallback = updateCallback;
    }
}
