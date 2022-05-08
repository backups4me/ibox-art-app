package com.ibox.nft.base.widgets.share;

import com.ibox.nft.base.widgets.recycle.IBoxDataType;
import java.io.Serializable;

/* loaded from: ShareMenuListItem.class */
public class ShareMenuListItem implements IBoxDataType, Serializable {
    private OnMenuItemCallback callback;
    private int menuIconRes;
    private String menuName;
    private String platName;

    /* loaded from: ShareMenuListItem$OnMenuItemCallback.class */
    public interface OnMenuItemCallback {
        void a(ShareMenuListItem shareMenuListItem);
    }

    public ShareMenuListItem(String str, String str2, int i, OnMenuItemCallback onMenuItemCallback) {
        this.platName = str;
        this.menuName = str2;
        this.menuIconRes = i;
        this.callback = onMenuItemCallback;
    }

    public OnMenuItemCallback getCallback() {
        return this.callback;
    }

    public int getMenuIconRes() {
        return this.menuIconRes;
    }

    public String getMenuName() {
        return this.menuName;
    }

    public String getPlatName() {
        return this.platName;
    }

    @Override // com.ibox.nft.base.widgets.recycle.IBoxDataType
    public String getViewHandlerName() {
        return ShareMenuListItemHandler.class.getName();
    }

    public void setCallback(OnMenuItemCallback onMenuItemCallback) {
        this.callback = onMenuItemCallback;
    }

    public void setMenuIconRes(int i) {
        this.menuIconRes = i;
    }

    public void setMenuName(String str) {
        this.menuName = str;
    }

    public void setPlatName(String str) {
        this.platName = str;
    }
}
