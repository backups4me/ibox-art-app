package com.ibox.nft.base.widgets.recycle;

import android.view.ViewGroup;
import androidx.annotation.NonNull;
import java.util.List;

/* loaded from: IBoxSupportPartialRefreshViewHandler.class */
public interface IBoxSupportPartialRefreshViewHandler<T> extends IBoxViewHandler<IBoxViewHolder, T> {
    void c(IBoxViewHolder iBoxViewHolder, int i, T t, ViewGroup viewGroup, @NonNull List<Object> list);
}
