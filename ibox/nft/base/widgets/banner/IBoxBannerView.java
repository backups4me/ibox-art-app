package com.ibox.nft.base.widgets.banner;

import android.content.Context;
import android.util.AttributeSet;
import com.ibox.nft.base.widgets.recycle.IBoxDataType;
import java.util.List;

/* loaded from: IBoxBannerView.class */
public class IBoxBannerView<T extends IBoxDataType> extends RollPagerView {
    public IBoxBannerAdapter x = null;

    public IBoxBannerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        v(context);
    }

    public IBoxBannerAdapter getAdapter() {
        return this.x;
    }

    public List<T> getData() {
        IBoxBannerAdapter iBoxBannerAdapter = this.x;
        if (iBoxBannerAdapter != null) {
            return iBoxBannerAdapter.e();
        }
        return null;
    }

    public void setData(List<T> list) {
        IBoxBannerAdapter iBoxBannerAdapter = this.x;
        if (iBoxBannerAdapter != null) {
            iBoxBannerAdapter.g(list);
            this.x.notifyDataSetChanged();
        }
    }

    public final void v(Context context) {
        IBoxBannerAdapter iBoxBannerAdapter = new IBoxBannerAdapter(this);
        this.x = iBoxBannerAdapter;
        setAdapter(iBoxBannerAdapter);
    }
}
