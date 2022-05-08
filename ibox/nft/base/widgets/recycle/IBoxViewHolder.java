package com.ibox.nft.base.widgets.recycle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.ButterKnife;
import com.ibox.libs.common.utils.IBoxViewFinder;

/* loaded from: IBoxViewHolder.class */
public class IBoxViewHolder extends RecyclerView.ViewHolder {
    public IBoxViewFinder a;

    public IBoxViewHolder(View view) {
        super(view);
        this.a = null;
        this.a = new IBoxViewFinder(view);
        ButterKnife.bind(this, view);
    }

    public static IBoxViewHolder a(ViewGroup viewGroup, int i) {
        return new IBoxViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(i, viewGroup, false));
    }

    public IBoxViewFinder b() {
        return this.a;
    }
}
