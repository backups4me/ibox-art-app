package com.ibox.nft.base.widgets.dialog.menu.viewhandler;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.ibox.nft.base.R;
import com.ibox.nft.base.widgets.dialog.menu.viewhandler.GridMenuViewItem;
import com.ibox.nft.base.widgets.recycle.IBoxViewHandler;
import com.ibox.nft.base.widgets.recycle.IBoxViewHolder;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import d.c.d.d.i.d.c.e.a;

/* loaded from: GridMenuViewItemHandler.class */
public class GridMenuViewItemHandler implements IBoxViewHandler {
    public FrameLayout a;

    /* renamed from: b  reason: collision with root package name */
    public FrameLayout f470b;
    public ImageView c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f471d;

    /* renamed from: e  reason: collision with root package name */
    public ImageView f472e;

    /* JADX INFO: Access modifiers changed from: private */
    @SensorsDataInstrumented
    /* renamed from: f */
    public /* synthetic */ void g(GridMenuViewItem.OnGridMenuItemCallback onGridMenuItemCallback, int i, GridMenuViewItem.IGridMenuItemEntity iGridMenuItemEntity, View view) {
        if (onGridMenuItemCallback != null) {
            onGridMenuItemCallback.a(i, iGridMenuItemEntity, this.f471d, this.f472e);
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    @Override // com.ibox.nft.base.widgets.recycle.IBoxViewHandler
    public int b() {
        return R.layout.item_dialog_grid_menu_list;
    }

    public final void d(IBoxViewHolder iBoxViewHolder, int i, GridMenuViewItem gridMenuViewItem) {
        GridMenuViewItem.IGridMenuItemEntity menuItem;
        if (gridMenuViewItem != null && gridMenuViewItem.getMenuItem() != null && (menuItem = gridMenuViewItem.getMenuItem()) != null) {
            boolean isSelected = menuItem.isSelected();
            int i2 = 0;
            if (menuItem.getMenuSelectedStyle() == 258) {
                int menuNormalBgResource = menuItem.getMenuNormalBgResource();
                menuNormalBgResource = menuItem.getMenuSelectedBgResource();
                FrameLayout frameLayout = this.f470b;
                if (isSelected) {
                }
                frameLayout.setBackgroundResource(menuNormalBgResource);
            } else {
                this.f470b.setBackgroundResource(0);
            }
            if (menuItem.getMenuIcon() != 0) {
                if (menuItem.isOnlyShowSelectIcon()) {
                    ImageView imageView = this.c;
                    if (!isSelected) {
                        i2 = 8;
                    }
                    imageView.setVisibility(i2);
                } else {
                    this.c.setVisibility(0);
                }
                this.c.setImageResource(menuItem.getMenuIcon());
            } else {
                this.c.setVisibility(8);
            }
            this.f471d.setText(menuItem.getMenuTitle());
            this.f471d.setTextColor(isSelected ? menuItem.getMenuSelectColor() : menuItem.getMenuNormalColor());
            this.f471d.setTextSize(menuItem.getMenuTitleSize());
            ((RecyclerView.ViewHolder) iBoxViewHolder).itemView.setOnClickListener(new a(this, gridMenuViewItem.getOnGridMenuItemCallback(), i, menuItem));
        }
    }

    /* renamed from: e */
    public void a(IBoxViewHolder iBoxViewHolder, int i, GridMenuViewItem gridMenuViewItem, ViewGroup viewGroup) {
        if (iBoxViewHolder != null) {
            this.a = (FrameLayout) iBoxViewHolder.b().a(R.id.rl_item_root_view);
            this.f470b = (FrameLayout) iBoxViewHolder.b().a(R.id.fl_menu_item_container);
            this.c = iBoxViewHolder.b().b(R.id.iv_menu_icon);
            this.f471d = iBoxViewHolder.b().d(R.id.tv_menu_title);
            this.f472e = iBoxViewHolder.b().b(R.id.iv_menu_img);
            d(iBoxViewHolder, i, gridMenuViewItem);
        }
    }
}
