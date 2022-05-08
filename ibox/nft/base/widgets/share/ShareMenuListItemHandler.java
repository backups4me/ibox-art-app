package com.ibox.nft.base.widgets.share;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView;
import com.ibox.libs.widgets.textview.AutoSizeTextView;
import com.ibox.nft.base.R;
import com.ibox.nft.base.widgets.recycle.IBoxViewHandler;
import com.ibox.nft.base.widgets.recycle.IBoxViewHolder;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import d.c.d.d.i.i.c;

/* loaded from: ShareMenuListItemHandler.class */
public class ShareMenuListItemHandler implements IBoxViewHandler {
    public ImageView a;

    /* renamed from: b  reason: collision with root package name */
    public AutoSizeTextView f507b;

    @SensorsDataInstrumented
    public static /* synthetic */ void e(ShareMenuListItem shareMenuListItem, View view) {
        if (shareMenuListItem.getCallback() != null) {
            shareMenuListItem.getCallback().a(shareMenuListItem);
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    @Override // com.ibox.nft.base.widgets.recycle.IBoxViewHandler
    public int b() {
        return R.layout.item_share_dialog_menu_list;
    }

    /* renamed from: d */
    public void a(IBoxViewHolder iBoxViewHolder, int i, ShareMenuListItem shareMenuListItem, ViewGroup viewGroup) {
        this.a = iBoxViewHolder.b().b(R.id.iv_share_menu_icon);
        this.f507b = iBoxViewHolder.b().a(R.id.tv_share_menu_text);
        this.a.setImageResource(shareMenuListItem.getMenuIconRes());
        this.f507b.setText(shareMenuListItem.getMenuName());
        ((RecyclerView.ViewHolder) iBoxViewHolder).itemView.setOnClickListener(new c(shareMenuListItem));
    }
}
