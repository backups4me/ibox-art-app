package com.ibox.nft.base.widgets.dialog.menu.viewhandler;

import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import com.ibox.nft.base.widgets.dialog.menu.viewhandler.GridMenuViewItem.IGridMenuItemEntity;
import com.ibox.nft.base.widgets.recycle.IBoxDataType;
import java.io.Serializable;

/* loaded from: GridMenuViewItem.class */
public class GridMenuViewItem<T extends IGridMenuItemEntity, K> implements IBoxDataType, Serializable {
    private T menuItem;
    private OnGridMenuItemCallback onGridMenuItemCallback;

    /* loaded from: GridMenuViewItem$IGridMenuItemEntity.class */
    public interface IGridMenuItemEntity<K> {
        @DrawableRes
        int getMenuIcon();

        @DrawableRes
        int getMenuNormalBgResource();

        int getMenuNormalColor();

        int getMenuSelectColor();

        @DrawableRes
        int getMenuSelectedBgResource();

        int getMenuSelectedStyle();

        @NonNull
        String getMenuTitle();

        int getMenuTitleSize();

        boolean isOnlyShowSelectIcon();

        boolean isSelected();
    }

    /* loaded from: GridMenuViewItem$OnGridMenuItemCallback.class */
    public interface OnGridMenuItemCallback<T extends IGridMenuItemEntity> {
        void a(int i, T t, TextView textView, ImageView imageView);
    }

    public GridMenuViewItem() {
    }

    public GridMenuViewItem(T t, OnGridMenuItemCallback<T> onGridMenuItemCallback) {
        this.menuItem = t;
        this.onGridMenuItemCallback = onGridMenuItemCallback;
    }

    public T getMenuItem() {
        return this.menuItem;
    }

    public OnGridMenuItemCallback<T> getOnGridMenuItemCallback() {
        return this.onGridMenuItemCallback;
    }

    @Override // com.ibox.nft.base.widgets.recycle.IBoxDataType
    public String getViewHandlerName() {
        return GridMenuViewItemHandler.class.getName();
    }

    public void setMenuItem(T t) {
        this.menuItem = t;
    }

    public GridMenuViewItem setOnGridMenuItemCallback(OnGridMenuItemCallback<T> onGridMenuItemCallback) {
        this.onGridMenuItemCallback = onGridMenuItemCallback;
        return this;
    }
}
