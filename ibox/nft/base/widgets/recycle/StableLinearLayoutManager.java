package com.ibox.nft.base.widgets.recycle;

import android.content.Context;
import android.util.AttributeSet;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.ibox.libs.common.utils.LogTool;

/* loaded from: StableLinearLayoutManager.class */
public class StableLinearLayoutManager extends LinearLayoutManager {
    public StableLinearLayoutManager(Context context) {
        super(context);
    }

    public StableLinearLayoutManager(Context context, int i, boolean z) {
        super(context, i, z);
    }

    public StableLinearLayoutManager(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
    }

    public void onLayoutChildren(RecyclerView.Recycler recycler, RecyclerView.State state) {
        try {
            StableLinearLayoutManager.super.onLayoutChildren(recycler, state);
        } catch (Exception e2) {
            LogTool.c("-->" + e2.toString());
            e2.printStackTrace();
        }
    }

    public int scrollVerticallyBy(int i, RecyclerView.Recycler recycler, RecyclerView.State state) {
        int i2;
        try {
            i2 = StableLinearLayoutManager.super.scrollVerticallyBy(i, recycler, state);
        } catch (Exception e2) {
            i2 = 0;
        }
        return i2;
    }
}
